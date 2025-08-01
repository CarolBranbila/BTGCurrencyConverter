package com.example.btgcurrencyconverter.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface CurrencyDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(currency: List<CurrencyEntity>)

    @Delete
    suspend fun delete(currency: CurrencyEntity)

    @Query("SELECT * FROM CurrencyEntity")
    suspend fun getAll(): List<CurrencyEntity>

    @Query ("SELECT * FROM CurrencyEntity WHERE id = :id")
    suspend fun getById(id: Long): CurrencyEntity?
}