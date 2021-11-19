package com.marcelo.marvel.presentation.customviews

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.marcelo.marvel.R
import com.marcelo.marvel.extensions.changeVisibility
import com.marcelo.marvel.extensions.configureBackAction

@SuppressLint("ResourceAsColor")
@RequiresApi(Build.VERSION_CODES.O)
class HeaderSimpleView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr:
                         Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private var headerTitle: String?
    private var headerContentColor: Int = R.color.transparent
    private var showBackButton: Boolean
    private var buttonBack: String
    private val btnSimpleHeader by lazy { findViewById<TextView>(R.id.btnHeaderBack) }
    private val textViewHeaderTitle by lazy { findViewById<TextView>(R.id.titleHeader) }

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.view_header, this, true)
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.HeaderSimpleView, 0, 0)
        headerTitle = typedArray.getString(R.styleable.HeaderSimpleView_headerTitle)
        headerContentColor =
            typedArray.getColor(
                R.styleable.HeaderSimpleView_headerContentColor,
                ContextCompat.getColor(context, R.color.white)
            )
        buttonBack = (typedArray.getString(R.styleable.HeaderSimpleView_buttonBack)).toString()
        showBackButton = typedArray.getBoolean(R.styleable.HeaderSimpleView_showBack, true)
        updateHeader(showBackButton)
    }

    fun updateHeader(
        showBack: Boolean = false,
        title: String? = null
    ) {
        showBackButton = showBack
        updateHeaderTitle(title ?: headerTitle)

        btnSimpleHeader.run {
            if (showBack) {
                text = buttonBack
                setTextColor(headerContentColor)
                (context as? Activity)?.let { configureBackAction(it) }
            } else changeVisibility(false)
        }
    }

    private fun updateHeaderTitle(headerTitle: String?) {
        headerTitle?.let {
            textViewHeaderTitle.run {
                text = headerTitle
                this.setTextColor(headerContentColor)
                setPadding(12, 16, 12, 8)
                importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            }
        }
    }

    fun initHeader(func: HeaderSimpleView.() -> Unit) = apply {
        func()
        updateHeader(showBack = true)
    }
}