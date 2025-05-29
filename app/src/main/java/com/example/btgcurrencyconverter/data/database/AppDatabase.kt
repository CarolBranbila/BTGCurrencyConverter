package com.example.btgcurrencyconverter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

class AppDatabase {
    @Database(entities = [CurrencyEntity::class], version = 1)
    abstract class AppDataBase: RoomDatabase(){
        abstract fun currencyDao(): CurrencyDao
    }
}