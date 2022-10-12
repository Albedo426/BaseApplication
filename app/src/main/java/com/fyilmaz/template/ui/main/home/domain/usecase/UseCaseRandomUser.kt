package com.fyilmaz.template.ui.main.home.domain.usecase

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import kotlinx.coroutines.flow.Flow

interface UseCaseRandomUser {
    suspend fun fetchData(): Flow<Result<RandomUsers>>
}
