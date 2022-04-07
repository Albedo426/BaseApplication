package com.fyilmaz.template.core.di

import android.content.Context
import com.fyilmaz.template.core.common.CustomSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalStorageModule {
    @Provides
    @Singleton
    fun provideLocalStorage(@ApplicationContext appContext: Context): CustomSharedPreferences {
        return CustomSharedPreferences(appContext)
    }
}