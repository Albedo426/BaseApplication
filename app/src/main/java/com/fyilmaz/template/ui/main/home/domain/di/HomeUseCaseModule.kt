package com.fyilmaz.template.ui.main.home.domain.di

import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.ui.main.home.domain.usecase.UseCaseRandomUser
import com.fyilmaz.template.ui.main.home.domain.usecase.UseCaseRandomUserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object HomeUseCaseModule {
    @Provides
    fun provideUseCaseMovie(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): UseCaseRandomUser {
        return UseCaseRandomUserImpl(remoteRepository, localRepository, coroutine)
    }
}
