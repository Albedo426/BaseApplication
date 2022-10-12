package com.fyilmaz.template.core.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.fyilmaz.template.core.extensions.get
import com.fyilmaz.template.core.extensions.set


class PreferenceManager(context: Context) {

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS = "prefs"
        private const val ISLOGIN = "fatihylmz.islogin"
        private const val TOKEN = "fatihylmz.token"
    }

    var isLogin: Boolean?
        get() = prefs.get(ISLOGIN)
        set(value) {
            prefs.set(ISLOGIN, value)
        }

    var token: String?
        get() = prefs.get(TOKEN)
        set(value) {
            prefs.set(TOKEN, value)
        }

}
