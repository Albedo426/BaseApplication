package com.fyilmaz.template.ui.auth.login.domain.di

import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.ui.auth.login.domain.usecase.UseCaseLogin
import com.fyilmaz.template.ui.auth.login.domain.usecase.UseCaseLoginImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object LoginUseCaseModule {
    @Provides
    fun provideUseCaseLogin(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): UseCaseLogin {
        return UseCaseLoginImpl(remoteRepository, localRepository, coroutine)
    }
}
