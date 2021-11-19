package com.marcelo.marvel.presentation.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityHeroesBinding
import com.marcelo.marvel.presentation.adapter.HeroesAdapter
import com.marcelo.marvel.presentation.customviews.HeaderSimpleView
import com.marcelo.marvel.presentation.viewmodel.HeroesViewModel
import kotlinx.android.synthetic.main.view_header.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityHeroesBinding
    private val viewModel: HeroesViewModel by viewModel()
    private val header: HeaderSimpleView by lazy {findViewById(R.id.toolbar)}

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_heroes)

        setupHeader()
        setupObservers()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupHeader() {

        header.initHeader {
            updateHeader(false, getString(R.string.title_toolbar_heroes))
        }
    }

    private fun setupObservers() {
        viewModel.heroEvent.observe(this) { heroes ->
            heroes?.let { getHeroes ->
                with(bindingMain.recyclerHeroes) {
                    LinearLayoutManager(this@HeroesActivity, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = HeroesAdapter(getHeroes) { comic ->
                        val intent = ComicsActivity.getStartIntent(
                            this@HeroesActivity,
                            comic.id
                        )
                        bindingMain.recyclerHeroes.adapter = adapter
                        this@HeroesActivity.startActivity(intent)
                    }
                }
            }
        }

        viewModel.viewFlipperLiveData.observe(this@HeroesActivity) { pairs ->
            pairs?.let { viewFlipper ->
                bindingMain.viewFlipperHeros.displayedChild = viewFlipper.first
                viewFlipper.second?.let { msgErrorId ->
                    bindingMain.textViewShowError.text = getString(msgErrorId)
                }
            }
        }

        viewModel.getHeroes()
    }
}