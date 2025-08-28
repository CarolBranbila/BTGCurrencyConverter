package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btgcurrencyconverter.domain.CurrencyRepository
import com.example.btgcurrencyconverter.domain.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val quotesRepository: QuotesRepository,
) : ViewModel() {
    private val _viewState = MutableStateFlow(CurrencyConverterViewState())
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.update {
                it.copy(isLoading = true)
            }

            currencyRepository.fetchCurrencyList()
            quotesRepository.fetchQuotesList()

            _viewState.update {
                it.copy(isLoading = false)
            }
        }
    }


    fun validIfInputIsValid(input: String, oldValue: String): String {

        if (input.isEmpty()) {
            return ""
        }
        return try {
            val bigDecimal = BigDecimal(input.replace(",", "."))
            when {
                bigDecimal < BigDecimal.ZERO -> oldValue
                bigDecimal.scale() > 2 -> oldValue
                else -> input
            }
        } catch (ex: NumberFormatException) {
            oldValue
        }
    }

    fun updateCurrencyValue(input: String) {
        viewModelScope.launch {
            _viewState.update {
                val convertedValue = convert(
                    source = it.source,
                    target = it.target,
                    currentValue = input,
                )

                it.copy(result = convertedValue.toString())
            }
        }
    }


    private suspend fun convert(
        source: String,
        target: String,
        currentValue: String,
    ): BigDecimal {
        return BigDecimal(
            quotesRepository.getQuotesList().first { it.code == "$source$target" }.value
        ).multiply(BigDecimal(currentValue.replace(",", ".")))
    }

    fun setSelectedCurrency(currencyId: Long){
        viewModelScope.launch {
            _viewState.update {
                it.copy(
                    target = currencyRepository.getCurrencyById(currencyId)?.code.orEmpty(),
                    result = "",

                )
            }
        }
    }
}