package com.example.btgcurrencyconverter.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuotesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val code: String,
    val value: String,
)