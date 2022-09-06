package com.fyilmaz.template.core.data.local

import android.content.Context
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import javax.inject.Inject
class LocalData @Inject constructor(val context: Context) {
    fun doLogin(loginRequest: LoginRequest): Result<LoginResponse> {
        if (loginRequest == LoginRequest("Albedo426", "123123")) {
            return Result.Success(
                LoginResponse(
                    "1", "fatih", "Yilmaz", "ahmed@ahmed.ahmed"
                )
            )
        }
        return Result.Error(NullPointerException())
    }
}
