package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

data class CurrencyConverterViewState(
    val source: String = "USD",
    val target: String = "BRL",
    val result: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
)
