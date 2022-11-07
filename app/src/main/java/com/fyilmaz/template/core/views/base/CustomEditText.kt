package com.fyilmaz.template.core.views.base

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatEditText
import com.fyilmaz.template.R

class CustomEditText(
    context: Context,
    attrs: AttributeSet
) : AppCompatEditText(context, attrs) {
    var backgroundNormal: Drawable? = null
    var backgroundError: Drawable? = null
    var backgroundFocus: Drawable? = null
    private var customAttributesStyle: TypedArray? = null
    init {

        customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0)
        customAttributesStyle?.let { attrsStyle ->
            // set attr
            backgroundNormal = attrsStyle.getDrawable(R.styleable.CustomEditText_textBackgroundNormal)
            backgroundError = attrsStyle.getDrawable(R.styleable.CustomEditText_textBackgroundError)
            backgroundFocus = attrsStyle.getDrawable(R.styleable.CustomEditText_textBackgroundFocus)
            setOnFocusChangeListener { view, b ->
                if (b) {
                    changeBackground(backgroundFocus)
                } else {
                    changeBackground(backgroundNormal)
                }
            }
            // set default color
            changeBackground(backgroundNormal)
        }
    }
    private fun changeBackground(drawable: Drawable?) {
        drawable?.let {
            background = it
        }
    }
    fun runError(@StringRes errorMessage: Int?) {
        changeBackground(backgroundError)
        errorMessage?.let { error = context.getString(it) }
    }
}
