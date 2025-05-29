package com.example.btgcurrencyconverter.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency

@Dao
interface CurrencyDao{
    @Insert
    fun insertAll(vararg currency: CurrencyEntity)

    @Delete
    fun delete(currency: CurrencyEntity)

    @Query("SELECT * FROM CurrencyEntity")
    fun getAll(): List<CurrencyEntity>
}