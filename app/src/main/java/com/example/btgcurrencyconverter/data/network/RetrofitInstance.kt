package com.example.btgcurrencyconverter.data.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://raw.githubusercontent.com")
        .addConverterFactory(
            Json{
                ignoreUnknownKeys = true
            }
                .asConverterFactory(
                    "application/json; charset=UTF8".toMediaType())
        )
        .build()

    fun createBTGApi() = retrofit.create<BTGApi>()
}