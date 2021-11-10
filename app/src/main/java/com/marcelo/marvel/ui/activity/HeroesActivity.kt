package com.marcelo.marvel.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityHeroesBinding
import com.marcelo.marvel.ui.adapter.HeroesAdapter
import com.marcelo.marvel.ui.viewmodel.HeroesViewModel
import kotlinx.android.synthetic.main.toolbar_heroes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityHeroesBinding
    private val viewModel: HeroesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_heroes)

        setupToolbar()
        setupObservers()
    }

    private fun setupToolbar() {
        toolbar.title = ""
        titleToolbar.text = getString(R.string.title_toolbar_heroes)
        setSupportActionBar(toolbar)
    }

    private fun setupObservers() {
        viewModel.heroesEvent.observe(this) { heroes ->
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