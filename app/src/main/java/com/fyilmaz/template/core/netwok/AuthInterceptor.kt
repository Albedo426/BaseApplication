package com.fyilmaz.template.core.netwok

import com.fyilmaz.template.core.common.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Content-Type", "application/json")

        //token vb header

        //builder.addHeader("Authorization", "Bearer ${preferenceManager.token?.token?.token}")

        return chain.proceed(builder.build())
    }


}
