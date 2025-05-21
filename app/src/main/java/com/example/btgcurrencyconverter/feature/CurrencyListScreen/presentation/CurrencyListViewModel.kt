package com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CurrencyListViewModel : ViewModel () {

    private val _viewState = MutableStateFlow(CurrencyListViewState(emptyList()))
    val viewState = _viewState.asStateFlow()
}