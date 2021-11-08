package com.marcelo.marvel.ui.activity

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, textView: TextView, titleIdRes: Int, showButtonBack: Boolean = false) {
        toolbar.title = ""
        textView.text = getString(titleIdRes)

        setSupportActionBar(toolbar)
        if (showButtonBack){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}