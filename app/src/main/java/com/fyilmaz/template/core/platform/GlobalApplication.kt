package com.fyilmaz.template.core.platform

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.fyilmaz.template.core.common.PreferenceManager
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        injectMultiDex()
    }

    private fun injectMultiDex() {
        MultiDex.install(this)
    }

    companion object {
        lateinit var appContext: Context
        val preferenceManager: PreferenceManager by lazy {
            PreferenceManager(appContext)
        }
        val firebaseAnalytics by lazy {
            FirebaseAnalytics.getInstance(appContext)
        }
    }
}
