package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btgcurrencyconverter.data.network.RetrofitInstance
import com.example.btgcurrencyconverter.domain.CurrencyRepository
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    currencyRepository: CurrencyRepository,
) : ViewModel() {
    private val _viewState = MutableStateFlow(CurrencyConverterViewState(emptyList()))
    val viewState = _viewState.asStateFlow()


    init {
        viewModelScope.launch {
            currencyRepository.fetchCurrencyList()
        }
    }
    /*private suspend fun fetchCurrencyList(): List<Currency> {
        return api.getQuotesList().currencies.map {
            Tax(
                code = it.key,
                taxValue = it.value,
            )
        }
*/
}