package com.example.btgcurrencyconverter.data.network

import retrofit2.http.GET

interface BTGApi {
    @GET("Banking-iOS/mock-interview/main/api/list.json")
    suspend fun getCurrencyNameList() : CurrencyResponse

    @GET("Banking-iOS/mock-interview/main/api/live.json")
    suspend fun getQuotesList(): QuotesListResponse
}