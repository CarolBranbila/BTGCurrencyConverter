package com.example.btgcurrencyconverter.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //adicione retrofit atraves do dagger

    @Provides
    fun provideBtgApi(): BTGApi = RetrofitInstance.createBTGApi()

    @Provides
    fun provideRetrofit(): RetrofitInstance = RetrofitInstance
}