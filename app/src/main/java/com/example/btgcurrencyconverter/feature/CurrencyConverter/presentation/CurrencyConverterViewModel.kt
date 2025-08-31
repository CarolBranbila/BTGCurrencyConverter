package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.example.btgcurrencyconverter.domain.CurrencyRepository
import com.example.btgcurrencyconverter.domain.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import java.math.BigDecimal
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val quotesRepository: QuotesRepository,
) : ViewModel() {
    private val _viewState = MutableStateFlow(CurrencyConverterViewState())
    val viewState = _viewState.asStateFlow()

    init {
        FetchCurrency()
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
            if (input.isNotEmpty()) {
                _viewState.update {
                    val convertedValue = convert(
                        source = it.source,
                        target = it.target,
                        currentValue = input,
                    )

                    it.copy(result = convertedValue.toString())
                }
            } else {
                _viewState.update {
                    it.copy(result = "0")
                }
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

    fun setSelectedCurrency(currencyId: Long) {
        viewModelScope.launch {
            _viewState.update {
                it.copy(
                    target = currencyRepository.getCurrencyById(currencyId)?.code.orEmpty(),
                    result = "",

                    )
            }
        }
    }

    private fun FetchCurrency(){
        viewModelScope.launch {
            _viewState.update {
                it.copy(
                    isLoading = true,
                    isError = false,
                    errorMessage = "",
                )
            }

            try {
                currencyRepository.fetchCurrencyList()
                quotesRepository.fetchQuotesList()
            } catch (ex: ConnectException) {
                UpdateError(
                    isError = true,
                    errorMessage = "Parece que você está no modo avião"
                )
            } catch (ex: HttpException) {
                UpdateError(
                    isError = true,
                    errorMessage = "Tivemos um problema, tente novamente mais tarde."
                )
            } catch (ex: Exception) {
                UpdateError(
                    isError = true,
                    errorMessage = "Oops algo deu errado :( "
                )
            }

            _viewState.update {
                it.copy(isLoading = false)
            }
        }
    }

    private fun UpdateError(
        isError: Boolean,
        errorMessage: String,
    ) {
        _viewState.update {
            it.copy(
                isError = isError,
                errorMessage = errorMessage,
            )
        }
    }

    fun OnTryAgainClick() {
        FetchCurrency()
    }
}