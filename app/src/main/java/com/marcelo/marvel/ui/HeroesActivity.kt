package com.marcelo.marvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.marvel.R

class HeroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_itens_heroes)
    }
}