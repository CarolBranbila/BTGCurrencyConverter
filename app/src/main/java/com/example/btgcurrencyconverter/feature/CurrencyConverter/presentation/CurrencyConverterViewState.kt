package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency

data class CurrencyConverterViewState(
    val list: List <Tax>,
    val result : String = "",
)

data class Tax(
    val code : String,
    val taxValue:String,
    val data: List<Currency> = emptyList()
)