package com.fyilmaz.template.core.di.usecase

import com.fyilmaz.template.core.data.local.LocalData
import com.fyilmaz.template.core.data.repository.RemoteDataRepository
import com.fyilmaz.template.core.data.usecase.user.UserUseCase
import com.fyilmaz.template.core.data.usecase.user.UserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {
    @Provides
    fun provideUseCaseLogin(
        remoteRepository: RemoteDataRepository,
        localRepository: LocalData,
        coroutine: CoroutineContext
    ): UserUseCase {
        return UserUseCaseImpl(remoteRepository, localRepository, coroutine)
    }
}
