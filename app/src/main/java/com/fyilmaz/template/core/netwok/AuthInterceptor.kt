package com.fyilmaz.template.core.netwok

import com.fyilmaz.template.core.common.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    preferenceManager: PreferenceManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Content-Type", "application/json")

        /*
        builder.addHeader("lang", preferenceManager.lang ?: "tr")
        if (preferenceManager.isLogin) {
            builder.addHeader("token", preferenceManager.token.toString())
        }
        val token = preferenceManager.token?.token ?: return chain.proceed(builder.build())
        if (token.isExpired() && tokenRef) {
            preferenceManager.token = refreshToken(token.token)
        }

        builder.addHeader("Authorization", "Bearer ${preferenceManager.token}")


        */

        // builder.addHeader("Authorization", "Bearer ${preferenceManager.token?.token?.token}")

        return chain.proceed(builder.build())
    }
    /*
    private fun refreshToken(refreshToken: String?): TokenResponse? {
        val client = refreshToken?.let { NetworkClient.provideClient(it) }
        val service = client?.let { NetworkClient.provideService(it) }
        return try {
            service?.refreshToken()?.execute()?.body()
        } catch (e: IOException) {
            null
        }
    }    */
}
