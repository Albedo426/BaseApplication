package com.fyilmaz.template.core.views.base

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.fyilmaz.template.databinding.LayoutTestLivedataBinding

class CustomTestLiveData(
    context: Context,
    attrs: AttributeSet
) : LinearLayout(context, attrs) {

    val binding =
        LayoutTestLivedataBinding.inflate(LayoutInflater.from(context), this, true)

    init {
    }
}
object Test {
    @BindingAdapter(value = ["realValueAttrChanged"])
    @JvmStatic
    fun setListener(editText: CustomTestLiveData, listener: InverseBindingListener?) {
        if (listener != null) {
            editText.binding.nameEditText.addTextChangedListener(object : TextWatcher {
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

    @BindingAdapter("realValue")
    @JvmStatic
    fun setRealValue(view: CustomTestLiveData, value: String) {
        if (view.binding.nameEditText.text.toString() != value) {
            view.binding.nameEditText.setText(value)
        }
    }

    @InverseBindingAdapter(attribute = "realValue")
    @JvmStatic
    fun getRealValue(editText: CustomTestLiveData): String {
        return editText.binding.nameEditText.text.toString()
    }
}
