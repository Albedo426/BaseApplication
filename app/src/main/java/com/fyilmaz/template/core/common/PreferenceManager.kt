package com.fyilmaz.template.core.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * @user:murat.balci
 */

class PreferenceManager(context: Context) {

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS = "prefs"
    }



}
