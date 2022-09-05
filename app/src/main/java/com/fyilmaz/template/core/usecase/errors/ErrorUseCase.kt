package com.fyilmaz.template.core.usecase.errors

import com.fyilmaz.template.core.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
