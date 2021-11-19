package com.marcelo.marvel.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityComicsBinding
import com.marcelo.marvel.presentation.adapter.ComicsAdapter
import com.marcelo.marvel.presentation.customviews.HeaderSimpleView
import com.marcelo.marvel.presentation.viewmodel.ComicsViewModel
import kotlinx.android.synthetic.main.view_header.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsActivity : AppCompatActivity() {
    private lateinit var bindingComics: ActivityComicsBinding
    private val viewModelComic: ComicsViewModel by viewModel()
    private val header: HeaderSimpleView by lazy {findViewById(R.id.toolbarComics)}

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingComics = DataBindingUtil.setContentView(this,R.layout.activity_comics)

        setupHeader()
        setupClickListener()
        setupObservers()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupHeader() {

        header.initHeader {
            updateHeader(true, getString(R.string.title_toolbar_comics))
        }
    }

    private fun setupClickListener() {
       header.btnHeaderBack.setOnClickListener {
           onBackPressed()
       }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun setupObservers() {
        viewModelComic.comicsEvent.observe(this) {comics ->
            comics?.let { getComics ->
                with (bindingComics.recyclerComics) {
                    LinearLayoutManager(this@ComicsActivity, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = ComicsAdapter(applicationContext, getComics)
                    bindingComics.recyclerComics.adapter = adapter
                }
            }
        }

       viewModelComic.viewFlipperLiveData.observe(this@ComicsActivity) { pairs ->
            pairs?.let { viewFlipper ->
                bindingComics.viewFlipperComics.displayedChild = viewFlipper.first
                viewFlipper.second?.let { msgErrorId ->
                    bindingComics.textViewShowError.text = getString(msgErrorId)
                }
            }
        }

        viewModelComic.getComics(intent.getLongExtra(EXTRA_ID, id))
    }


    companion object {
        private const val EXTRA_ID = "ID_CHARACTER"
        private var id: Long = 0

        fun getStartIntent(context: Context, idCharacter: Long) : Intent {
            return Intent(context, ComicsActivity::class.java).apply {
                putExtra(EXTRA_ID, idCharacter)
                id = idCharacter
            }
        }
    }
}