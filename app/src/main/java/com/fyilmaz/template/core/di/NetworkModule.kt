package com.fyilmaz.template.core.di

import android.content.Context
import androidx.viewbinding.BuildConfig
import com.fyilmaz.template.core.common.PreferenceManager
import com.fyilmaz.template.core.data.remote.MovieService
import com.fyilmaz.template.core.di.qualifers.DefaultOkHttpClientBuilder
import com.fyilmaz.template.core.di.qualifers.ProjectOkHttpClient
import com.fyilmaz.template.core.di.qualifers.ProjectRetrofit
import com.fyilmaz.template.core.netwok.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideProjectService(
        @ProjectRetrofit projectRetrofit: Retrofit
    ): MovieService = projectRetrofit.create(MovieService::class.java)

    @ProjectRetrofit
    @Provides
    fun provideProjectRetrofit(
        @ProjectOkHttpClient projectOkHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().apply {
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        baseUrl("https://randomuser.me/")
        addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        addConverterFactory(GsonConverterFactory.create(gson))
        client(projectOkHttpClient)
    }.build()

    @ProjectOkHttpClient
    @Provides
    fun provideProjectOkHttpClient(
        @DefaultOkHttpClientBuilder okHttpClientBuilder: OkHttpClient.Builder,
        @ApplicationContext context: Context
    ) = okHttpClientBuilder.apply {
    }.build()

    @Provides
    @DefaultOkHttpClientBuilder
    fun provideDefaultOkHttpBuilder(
        @ApplicationContext context: Context,
        preferenceManager: PreferenceManager
    ): OkHttpClient.Builder {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        return OkHttpClient.Builder()
            /*.addInterceptor {
                val request = it.request()
                val newUrl = request.url.newBuilder().addQueryParameter("api_key", "eccf44245a684bed282abf59a57b77bd").build()
                it.proceed(request.newBuilder().url(newUrl).build())
            }*/
            .addInterceptor(provideLoggingInterceptor())
            .addInterceptor(AuthInterceptor(preferenceManager))
            .addNetworkInterceptor(loggingInterceptor)
            .callTimeout(DEFAULT_CALL_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
    }
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}
