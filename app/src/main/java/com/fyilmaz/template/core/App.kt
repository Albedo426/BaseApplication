package com.fyilmaz.template.core

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.multidex.MultiDex
import com.fyilmaz.data.repository.ApiRepository
import com.fyilmaz.template.core.common.CustomSharedPreferences
import com.fyilmaz.template.core.network.NetworkUnavailableException
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var apiRepository: ApiRepository

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        injectMultiDex()
        Timber.plant(Timber.DebugTree())
    }

    private fun injectMultiDex() {
        MultiDex.install(this)
    }

    companion object {
        lateinit var appContext: Context
        val preferenceManager: CustomSharedPreferences by lazy {
            CustomSharedPreferences(appContext)
        }

        val networkStatusObservable: MutableLiveData<NetworkUnavailableException> by lazy {
            MutableLiveData()
        }
    }
}
