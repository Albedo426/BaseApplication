package com.fyilmaz.template.core.di.repo

import android.content.Context
import com.fyilmaz.template.core.common.PreferenceManager
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.local.LocalDataImpl
import com.fyilmaz.template.core.data.room.dao.UserDao
import com.fyilmaz.template.core.data.remote.AppService
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.core.data.repository.RemoteDataRepositoryImpl
import com.fyilmaz.template.core.netwok.Network
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNetwork(@ApplicationContext context: Context): Network {
        return Network(context)
    }
    @Singleton
    @Provides
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManager(context)
    }
    @Singleton
    @Provides
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }
    @Singleton
    @Provides
    fun provideLocalRepository(@ApplicationContext context: Context, userDao: UserDao): LocalData {
        return LocalDataImpl(context, userDao)
    }
    @Singleton
    @Provides
    fun provideRemoteRepository(service: AppService, network: Network): RemoteDataRepository {
        return RemoteDataRepositoryImpl(service, network)
    }
}
