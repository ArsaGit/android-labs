package com.example.lab1.api

import com.example.lab1.model.SealedCard
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("new_text.json")
    suspend fun getCards(): Response<MutableList<SealedCard.CardInfo>>
}

@Module
object NetworkModule {
    private const val BASE_URL = "https://develtop.ru/study/"

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }
}