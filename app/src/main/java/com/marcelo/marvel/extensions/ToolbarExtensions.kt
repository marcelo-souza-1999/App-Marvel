package com.marcelo.marvel.extensions

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat

fun ViewGroup.adjustViewToTopInsets() = run {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        setPadding(0, insets.systemWindowInsetTop, 0, 0)
        insets.consumeSystemWindowInsets()
    }
}