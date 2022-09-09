package com.fyilmaz.template.core.extensions

import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter

@BindingAdapter("app:customAlpha")
fun AppCompatButton.setAlpha(enabled: Boolean) {
    if (enabled) {
        this.alpha = 1.0f
    } else {
        this.alpha = 0.5f
    }
}
@BindingAdapter("app:customAlphaEnabled")
fun AppCompatButton.setAlphaEn(enabled: Boolean) {
    if (enabled) {
        this.alpha = 1.0f
        this.isEnabled = true
    } else {
        this.alpha = 0.5f
        this.isEnabled = false
    }
}

