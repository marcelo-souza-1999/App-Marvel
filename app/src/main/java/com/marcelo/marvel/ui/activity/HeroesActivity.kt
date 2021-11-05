package com.marcelo.marvel.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ActivityHeroesBinding
import com.marcelo.marvel.databinding.ToolbarBinding

class HeroesActivity : BaseActivity() {
    private lateinit var bindingMain: ActivityHeroesBinding
    private lateinit var bindingToolbar: ToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_heroes)
        bindingToolbar = DataBindingUtil.setContentView(this, R.layout.toolbar)

        setupToolbar(bindingToolbar.toolbarMain, bindingToolbar.titleToolbar, R.string.title_toolbar)
        setupViewModel()
        initRecyclerView()
    }

    private fun setupViewModel() {

    }

    private fun initRecyclerView() {
        bindingMain.recyclerHeroes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}