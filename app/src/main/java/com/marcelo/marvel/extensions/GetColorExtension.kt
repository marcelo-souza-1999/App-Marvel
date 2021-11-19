package com.marcelo.marvel.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.getResColor(@ColorRes idColor: Int) = ContextCompat.getColor(this, idColor)