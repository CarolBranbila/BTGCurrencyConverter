package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import androidx.lifecycle.ViewModel
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.CurrencyListViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CurrencyConverterViewModel: ViewModel() {
    private val _viewState = MutableStateFlow(CurrencyConverterViewState(emptyList()))
    val viewState = _viewState.asStateFlow()
}