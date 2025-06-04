package com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation

data class CurrencyListViewState(
    val list: List <Currency>,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)

data class Currency(
    val name : String,
    val isSelected:Boolean
)