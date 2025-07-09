package com.example.btgcurrencyconverter.data.database

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): AppDataBase = createRoomDatabaseInstance(context)

    @Provides
    fun provideCurrencyDao(
        appDataBase: AppDataBase
    ): CurrencyDao = appDataBase.currencyDao()
}