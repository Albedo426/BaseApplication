package com.fyilmaz.template.core.di.room

import android.content.Context
import androidx.room.Room
import com.fyilmaz.template.core.data.room.AppDatabase
import com.fyilmaz.template.core.data.room.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "base"
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.UserDao()

}