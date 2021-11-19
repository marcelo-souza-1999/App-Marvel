package com.marcelo.marvel.extensions

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.TextView


fun View.configureBackAction(activity: Activity) = setOnClickListener {
    Log.d("testeBtn", "aqui")
    activity.finish()
    activity.moveTaskToBack(true)
}

fun View.changeVisibility(isVisible: Boolean) {
    this.context.run {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
