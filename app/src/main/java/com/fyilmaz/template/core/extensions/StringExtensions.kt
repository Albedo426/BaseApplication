package com.fyilmaz.template.core.extensions

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

private const val emailRegex =
    "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"

private const val vphoneRegex =
    "(05|5)[0-9][0-9][1-9]([0-9]){6}"

fun String?.phoneRegex(): Boolean {
    val p = Pattern.compile(vphoneRegex)
    val m: Matcher = p.matcher(this.toString())
    return m.matches()
}

fun String?.emailRegex(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this.toString().trim()).matches()
}
