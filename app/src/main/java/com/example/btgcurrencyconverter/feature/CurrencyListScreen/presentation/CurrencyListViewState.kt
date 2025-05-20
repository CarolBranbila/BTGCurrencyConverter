package com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation

data class CurrencyListViewState(
    val list: List <Currency>
)

data class Currency(
    val name : String,
    val isSelected:Boolean
)