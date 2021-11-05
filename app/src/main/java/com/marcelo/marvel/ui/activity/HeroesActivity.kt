package com.marcelo.marvel.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityHeroesBinding
import com.marcelo.marvel.databinding.ToolbarBinding
import com.marcelo.marvel.ui.adapter.HeroesAdapter

class HeroesActivity : BaseActivity() {
    private lateinit var bindingMain: ActivityHeroesBinding
    private lateinit var bindingToolbar: ToolbarBinding

    private lateinit var adapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_heroes)
        bindingToolbar = DataBindingUtil.setContentView(this, R.layout.toolbar)

        setupToolbar(bindingToolbar.toolbarMain, bindingToolbar.titleToolbar, R.string.title_toolbar)
        setupViewModel()
        showHeroesRecyclerView()
    }

    private fun setupViewModel() {

    }

    private fun showHeroesRecyclerView() {
        bindingMain.recyclerHeroes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        bindingMain.recyclerHeroes.adapter = adapter


    }
}