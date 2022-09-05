package com.fyilmaz.template.core.usecase.errors

import com.fyilmaz.template.core.data.error.mapper.ErrorMapper
import com.fyilmaz.template.core.data.error.Error
import javax.inject.Inject

/**
 * Created by AhmedEltaher
 */

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
