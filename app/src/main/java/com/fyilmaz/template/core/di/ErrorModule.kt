package com.fyilmaz.template.core.di

import com.fyilmaz.template.core.data.error.mapper.ErrorMapper
import com.fyilmaz.template.core.data.error.mapper.ErrorMapperSource
import com.fyilmaz.template.core.usecase.errors.ErrorManager
import com.fyilmaz.template.core.usecase.errors.ErrorUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorManager: ErrorManager): ErrorUseCase

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper): ErrorMapperSource
}
