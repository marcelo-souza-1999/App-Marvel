package com.marcelo.marvel.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityHeroesBinding
import com.marcelo.marvel.databinding.ToolbarBinding
import com.marcelo.marvel.ui.adapter.HeroesAdapter
import com.marcelo.marvel.ui.viewmodel.HeroesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesActivity : BaseActivity() {
    private lateinit var bindingMain: ActivityHeroesBinding
    private val viewModel: HeroesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_heroes)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.heroesEvent.observe(this) { heroes ->
            heroes?.let { it ->
                with(bindingMain.recyclerHeroes) {
                    LinearLayoutManager(this@HeroesActivity, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = HeroesAdapter(it)
                    bindingMain.recyclerHeroes.adapter = adapter
                    Log.d("teste", "Herois: "+it)
                }
            }
        }

        /*viewModel.viewFlipperLiveData.observe(this@HeroesActivity) { pairs ->
            pairs?.let { viewFlipper ->
                viewFlipperHeros.displayedChild = viewFlipper.first
                viewFlipper.second?.let { msgErrorId ->
                    bindingMain.textViewShowError.text = getString(msgErrorId)
                }
            }
        }*/

        viewModel.getHeroes()
    }
}