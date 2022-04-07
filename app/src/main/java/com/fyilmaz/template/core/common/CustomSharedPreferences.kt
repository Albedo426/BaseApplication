package com.fyilmaz.template.core.common

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit
import java.util.*

/**
 * @user:murat.balci
 */

class CustomSharedPreferences {
    companion object {
        private const val PREFERENCES_TIME = "time"
        private var sharedPreferences: SharedPreferences? = null
        @Volatile private var instance: CustomSharedPreferences? = null
        private val lock = Any()
        operator fun invoke(context: Context): CustomSharedPreferences = instance ?: synchronized(lock) {
            instance ?: makeSharedPreferences(context)
        }
        private fun makeSharedPreferences(context: Context): CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(PREFERENCES_TIME, time)
        }
    }
    fun getTime() = sharedPreferences?.getLong(PREFERENCES_TIME, 0)
}
