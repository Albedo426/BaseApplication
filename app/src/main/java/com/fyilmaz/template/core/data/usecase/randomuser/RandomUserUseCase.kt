package com.fyilmaz.template.core.data.usecase.randomuser

import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import kotlinx.coroutines.flow.Flow

interface RandomUserUseCase {
    suspend fun fetchData(): Flow<Result<RandomUsers>>
}
