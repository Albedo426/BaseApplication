package com.fyilmaz.template.core.views.component.login

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.fyilmaz.template.R
import com.fyilmaz.template.databinding.ComponentLoginBinding

class CustomLoginComponent(
    context: Context,
    attrs: AttributeSet
) : LinearLayout(context, attrs) {
    var mySetOnTouchListener: (() -> Unit)? = null
    var defaultInterval: Int = 1000
    var buttonBackgroundInActive: Drawable? = null
    var buttonBackGroundDefault: Drawable? = null
    var buttonBackGroundPress: Drawable? = null
    var textBackgroundNormal: Drawable? = null
    var textBackgroundError: Drawable? = null
    var textBackgroundFocus: Drawable? = null
    var logoImage: Drawable? = null
    var logoText: String? = null
    var isSafeClick: Boolean = false
    val binding =
        ComponentLoginBinding.inflate(LayoutInflater.from(context), this, true)
    init {
        val customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.CustomLoginComponent, 0, 0)
        buttonBackGroundDefault = customAttributesStyle.getDrawable(R.styleable.CustomLoginComponent_ComponentLoginButtonBackgroundNormal)
        buttonBackgroundInActive = customAttributesStyle.getDrawable(R.styleable.CustomLoginComponent_ComponentLoginButtonBackgroundInActive)
        buttonBackGroundPress = customAttributesStyle.getDrawable(R.styleable.CustomLoginComponent_ComponentLoginButtonBackgroundPress)
        isSafeClick = customAttributesStyle.getBoolean(R.styleable.CustomLoginComponent_ComponentLoginIsSafeClick, false)
        logoImage = customAttributesStyle.getDrawable(R.styleable.CustomLoginComponent_ComponentLoginLogo)
        logoText = customAttributesStyle.getString(R.styleable.CustomLoginComponent_ComponentLoginLogoText)
        defaultInterval = customAttributesStyle.getInt(R.styleable.CustomLoginComponent_ComponentLoginDefaultInterval, 0)
        binding.button.changeBackground(buttonBackGroundDefault)
        // button sets
        binding.button.backGroundDefault = buttonBackGroundDefault
        binding.button.backgroundInActive = buttonBackgroundInActive
        binding.button.backGroundPress = buttonBackGroundPress
        binding.button.defaultInterval = defaultInterval
        binding.button.isSafeClick = isSafeClick

        // textName sets
        binding.nameEditText.backgroundNormal = textBackgroundNormal
        binding.nameEditText.backgroundError = textBackgroundError
        binding.nameEditText.backgroundFocus = textBackgroundFocus
        binding.nameEditText.changeBackground(textBackgroundNormal)

        // textPassword sets
        binding.passwordEditText.backgroundNormal = textBackgroundNormal
        binding.passwordEditText.backgroundError = textBackgroundError
        binding.passwordEditText.backgroundFocus = textBackgroundFocus
        binding.passwordEditText.changeBackground(textBackgroundNormal)

        // logo sets
        logoImage?.let {
            binding.logo.background=logoImage
            binding.logo.visibility= View.VISIBLE

        }
        logoText?.let {
            binding.pageTitle.text=logoText
            binding.pageTitle.visibility= View.VISIBLE
        }


        binding.button.mySetOnTouchListener = {
            mySetOnTouchListener?.invoke()
        }
    }
    fun runAllError(@StringRes message: Int) {
        binding.nameEditText.runError(message)
        binding.passwordEditText.runError(message)
    }
    fun runNameError(@StringRes message: Int) {
        binding.nameEditText.runError(message)
    }
    fun runPasswordError(@StringRes message: Int) {
        binding.passwordEditText.runError(message)
    }
}
object LoginComponentBinding {
    // button
    @BindingAdapter("app:customAlphaEn")
    @JvmStatic
    fun CustomLoginComponent.setAlphaEn(enabled: Boolean?) {
        binding.let {
            if (enabled == true) {
                buttonBackgroundInActive?.let {
                    binding.button.changeBackground(buttonBackGroundDefault)
                } ?: run {
                    binding.button.alpha = 1.0f
                }
                binding.button.isEnabled = true
            } else {
                buttonBackgroundInActive?.let {
                    binding.button.changeBackground(buttonBackgroundInActive)
                } ?: run {
                    binding.button.alpha = 0.5f
                }
                binding.button.isEnabled = false
            }
        }
    }

    // name
    @BindingAdapter(value = ["nameValueAttrChanged"])
    @JvmStatic
    fun setListener(editText: CustomLoginComponent?, listener: InverseBindingListener?) {
        if (listener != null) {
            editText?.binding?.nameEditText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }
                override fun onTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                    listener.onChange()
                }
                override fun afterTextChanged(editable: Editable) {
                }
            })
        }
    }

    @BindingAdapter("nameValue")
    @JvmStatic
    fun setNameValue(view: CustomLoginComponent, value: String?) {
        if (!view.binding.nameEditText.text.isNullOrEmpty()) {
            if (view.binding.nameEditText.text.toString() != value) {
                view.binding.nameEditText.setText(value)
            }
        }
    }

    @InverseBindingAdapter(attribute = "nameValue")
    @JvmStatic
    fun getNameValue(editText: CustomLoginComponent): String {
        if (editText.binding.nameEditText.text.isNullOrEmpty()) {
            return ""
        }
        return editText.binding.nameEditText.text.toString()
    }

    // password
    @BindingAdapter(value = ["passwordValueAttrChanged"])
    @JvmStatic
    fun setPasswordListener(editText: CustomLoginComponent?, listener: InverseBindingListener?) {
        if (listener != null) {
            editText?.binding?.passwordEditText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }
                override fun onTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                    listener.onChange()
                }
                override fun afterTextChanged(editable: Editable) {
                }
            })
        }
    }

    @BindingAdapter("passwordValue")
    @JvmStatic
    fun setPasswordValue(view: CustomLoginComponent, value: String?) {
        if (!view.binding.passwordEditText.text.isNullOrEmpty()) {
            if (view.binding.passwordEditText.text.toString() != value) {
                view.binding.passwordEditText.setText(value)
            }
        }
    }

    @InverseBindingAdapter(attribute = "passwordValue")
    @JvmStatic
    fun getPasswordValue(editText: CustomLoginComponent): String {
        if (editText.binding.passwordEditText.text.isNullOrEmpty()) {
            return ""
        }
        return editText.binding.passwordEditText.text.toString()
    }
}
