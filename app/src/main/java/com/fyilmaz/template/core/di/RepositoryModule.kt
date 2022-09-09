package com.fyilmaz.template.core.di

import android.content.Context
import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.local.LocalDataImpl
import com.fyilmaz.template.core.data.remote.MovieService
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

    @Provides
    fun provideNetwork(@ApplicationContext context: Context): Network {
        return Network(context)
    }
    @Provides
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }
    @Provides
    fun provideLocalRepository(@ApplicationContext context: Context): LocalData {
        return LocalDataImpl(context)
    }

    @Provides
    fun provideRemoteRepository(service: MovieService, network: Network): RemoteDataRepository {
        return RemoteDataRepositoryImpl(service, network)
    }
}
