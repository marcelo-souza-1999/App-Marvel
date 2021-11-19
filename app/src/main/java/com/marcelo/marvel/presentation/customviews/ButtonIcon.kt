package com.marcelo.marvel.presentation.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.updateLayoutParams
import com.marcelo.marvel.R
import com.marcelo.marvel.extensions.getResColor
import com.marcelo.marvel.extensions.toDp

class ButtonIcon
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatButton(context, attrs, defStyleAttr) {

    init {
        gravity = Gravity.CENTER
        textAlignment = View.TEXT_ALIGNMENT_CENTER
        textSize = DEFAULT_TEXT_SIZE
        setBackgroundColor(context.getResColor(R.color.transparent))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateLayoutParams<ViewGroup.LayoutParams> {
            height = DEFAULT_BUTTON_SIZE.toDp()
            width = DEFAULT_BUTTON_SIZE.toDp()
        }
    }

    companion object {
        private const val DEFAULT_TEXT_SIZE = 24F
        private const val DEFAULT_BUTTON_SIZE = 48
    }
}