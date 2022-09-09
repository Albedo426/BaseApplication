package com.fyilmaz.template.core.extensions

import android.widget.Toast
import com.fyilmaz.template.core.platform.GlobalApplication.Companion.appContext

fun toastMessage(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(appContext.applicationContext, message, duration).show()
}
