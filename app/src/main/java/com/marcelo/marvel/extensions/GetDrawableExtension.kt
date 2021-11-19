package com.marcelo.marvel.extensions

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getResDrawable(@DrawableRes idDrawable: Int) = ContextCompat.getDrawable(this, idDrawable)