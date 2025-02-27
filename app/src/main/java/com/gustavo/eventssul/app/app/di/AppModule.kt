package com.gustavo.eventssul.app.app.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    companion object {
        private const val SERVER_URL = "http://5b840ba5db24a100142dcd8c.mockapi.io/"
    }

    @Provides
    @Singleton
    fun retrofit() = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SERVER_URL)
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .build()
}