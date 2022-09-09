package com.fyilmaz.template.core.data.local

import android.content.Context
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.error.ErrorMapper
import com.fyilmaz.template.core.data.dto.login.LoginRequest
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.dto.login.isExist
import javax.inject.Inject

class LocalDataImpl @Inject constructor(val context: Context) : LocalData {
    override fun doLogin(loginRequest: LoginRequest): Result<LoginResponse> {
        if (loginRequest.isExist(LoginRequest("Albedo426", "123123"))) {
            return Result.Success(
                LoginResponse(
                    "1", "fatih", "Yilmaz", "fatikyilmaz@hotmail.com","testtoken"
                )
            )
        }
        return Result.Error(
            ErrorMapper.getError(
                NullPointerException()
            )
        )
    }
}
