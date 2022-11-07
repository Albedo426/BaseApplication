package com.fyilmaz.template.core.di.usecase

import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.core.data.usecase.randomuser.RandomUserUseCase
import com.fyilmaz.template.core.data.usecase.randomuser.RandomUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object RandomUserUseCaseModule {
    @Provides
    fun provideUseCaseMovie(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): RandomUserUseCase {
        return RandomUserUseCaseImpl(remoteRepository, localRepository, coroutine)
    }
}
