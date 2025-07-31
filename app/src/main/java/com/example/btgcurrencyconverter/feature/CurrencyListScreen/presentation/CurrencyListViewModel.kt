package com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btgcurrencyconverter.data.network.RetrofitInstance
import com.example.btgcurrencyconverter.domain.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    currencyRepository: CurrencyRepository,
): ViewModel() {

    private val _viewState = MutableStateFlow(CurrencyListViewState(emptyList()))
    val viewState = _viewState.asStateFlow()


    init {
        viewModelScope.launch {
            val entity = currencyRepository.getCurrencyList() // converter a currency entity para a currency da viewState : D
            val mapped = entity.map {
                Currency(
                    name = it.code + " " + it.currencyName ,
                    isSelected = false
                )
            }

            _viewState.value = _viewState.value.copy(list = mapped)
        }
    }

}