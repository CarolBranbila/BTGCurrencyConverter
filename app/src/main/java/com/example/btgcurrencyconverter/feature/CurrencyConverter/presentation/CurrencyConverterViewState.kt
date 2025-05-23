package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

data class CurrencyConverterViewState(
    val list: List <Tax>
)

data class Tax(
    val code : String,
    val taxValue:String,
)