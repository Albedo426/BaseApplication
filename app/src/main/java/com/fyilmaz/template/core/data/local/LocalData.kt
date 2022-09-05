package com.fyilmaz.data.local

import android.content.Context
import com.fyilmaz.data.Resource
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.error.PASS_WORD_ERROR
import javax.inject.Inject

class LocalData @Inject constructor(val context: Context) {

    fun doLogin(loginRequest: LoginRequest): Resource<LoginResponse> {
        if (loginRequest == LoginRequest("Albedo426", "123123")) {
            return Resource.Success(
                LoginResponse(
                    "1", "fatih", "Yilmaz","ahmed@ahmed.ahmed"
                )
            )
        }
        return Resource.DataError(PASS_WORD_ERROR)
    }
}