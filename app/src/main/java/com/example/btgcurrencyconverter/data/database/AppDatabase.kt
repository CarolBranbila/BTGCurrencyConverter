package com.example.btgcurrencyconverter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        CurrencyEntity::class,
        QuotesEntity::class
               ],
    version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun quotesDao(): QuotesDao
}