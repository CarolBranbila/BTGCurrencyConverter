package com.example.btgcurrencyconverter.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface QuotesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(currency: List<QuotesEntity>)

    @Delete
    suspend fun delete(currency: QuotesEntity)

    @Query("SELECT * FROM QuotesEntity")
    suspend fun getAll(): List<QuotesEntity>
}