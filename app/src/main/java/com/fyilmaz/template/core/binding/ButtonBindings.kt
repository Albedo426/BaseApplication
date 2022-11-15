package com.fyilmaz.template.core.binding

import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.fyilmaz.template.core.views.base.CustomButton

@BindingAdapter("app:alphaChange")
fun AppCompatButton.setAlpha(enabled: Boolean) {
    if (enabled) {
        this.alpha = 1.0f
    } else {
        this.alpha = 0.5f
    }
}

@BindingAdapter("app:alphaEnabledChange")
fun AppCompatButton.setAlphaEn(enabled: Boolean) {
    if (enabled) {
        this.alpha = 1.0f
        this.isEnabled = true
    } else {
        this.alpha = 0.5f
        this.isEnabled = false
    }
}

@BindingAdapter("app:customAlphaEn")
fun CustomButton.setAlphaEn(enabled: Boolean) {
    if (enabled) {
        backgroundInActive?.let {
            this.changeBackground(backGroundDefault)
        } ?: run {
            alpha = 1.0f
        }
        isEnabled = true
    } else {
        backgroundInActive?.let {
            this.changeBackground(backgroundInActive)
        } ?: run {
            alpha = 0.5f
        }
        isEnabled = false
    }
}
