package com.fyilmaz.template.core.di

import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.core.data.usecase.login.UseCaseLogin
import com.fyilmaz.template.core.data.usecase.login.UseCaseLoginImpl
import com.fyilmaz.template.core.data.usecase.movie.UseCaseRandomUser
import com.fyilmaz.template.core.data.usecase.movie.UseCaseRandomUserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCaseLogin(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): UseCaseLogin {
        return UseCaseLoginImpl(remoteRepository, localRepository, coroutine)
    }
    @Provides
    fun provideUseCaseMovie(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): UseCaseRandomUser {
        return UseCaseRandomUserImpl(remoteRepository, localRepository, coroutine)
    }
}
