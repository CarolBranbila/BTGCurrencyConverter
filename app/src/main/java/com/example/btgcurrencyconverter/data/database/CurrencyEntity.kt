package com.example.btgcurrencyconverter.data.database

import androidx.room.Entity

@Entity
data class CurrencyEntity(
    val code: String,
    val currencyName: String,
)
