package com.example.lab1.api

import com.example.lab1.model.SealedCard
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("new_text.json")
    suspend fun getCards(): Response<MutableList<SealedCard.CardInfo>>
}

object RetrofitManager {
    private const val BASE_URL = "https://develtop.ru/study/"
    val apiService: ApiService

    init {

        val client = OkHttpClient.Builder().build()

        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }


}