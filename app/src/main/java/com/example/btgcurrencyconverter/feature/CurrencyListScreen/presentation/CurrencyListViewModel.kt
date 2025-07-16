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

    private val api = RetrofitInstance.createBTGApi()

    init {
        loadCurrencyList()
    }

    fun loadCurrencyList() {
        viewModelScope.launch {
            _viewState.update {
                try {
                    val actualList = _viewState.value.list
                    _viewState.value = _viewState.value.copy(
                        actualList,
                        isLoading = actualList.isEmpty(),
                        isError = false
                    )
                    val newList = fetchCurrencyList()

                    _viewState.value.copy(
                        list = actualList + newList,
                        isLoading = false,
                        isError = false
                    )
                } catch (ex: Exception) {
                    _viewState.value.copy(isLoading = false, isError = true)
                }
            }
        }
    }

    private suspend fun fetchCurrencyList(): List<Currency> {
        return api.getCurrencyNameList().currencies.map {
            Currency(
                name = it.key,
                isSelected = false,
            )
        }
    }
}