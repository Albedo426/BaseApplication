package com.fyilmaz.template.core.common

import java.util.*
import javax.inject.Inject

class LocaleDefault @Inject constructor() {
    val languageName: String?
        get() {
            val language: String = Locale.getDefault().language // tr, en, ...
            return if ((language == "tr")) "tr" else "en-US"
        }
}
