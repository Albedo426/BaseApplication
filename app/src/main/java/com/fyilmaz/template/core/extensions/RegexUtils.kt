package com.fyilmaz.template.core.extensions

import java.util.regex.Pattern

object RegexUtils {
    val EMAIL_ADDRESS: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
    )
}
fun String.isValidEmail(): Boolean {
    return RegexUtils.EMAIL_ADDRESS.matcher(this).matches()
}
