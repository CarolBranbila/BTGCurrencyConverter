package com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.example.btgcurrencyconverter.domain.CurrencyConverterUseCase
import com.example.btgcurrencyconverter.domain.CurrencyRepository
import com.example.btgcurrencyconverter.domain.GetCurrencyTargetUseCase
import com.example.btgcurrencyconverter.domain.InitializeCurrenciesUseCase
import com.example.btgcurrencyconverter.domain.QuotesRepository
import com.example.btgcurrencyconverter.domain.ValidIfInputIsValidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import java.math.BigDecimal
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val initializeCurrenciesUseCase: InitializeCurrenciesUseCase,
    private val getCurrencyTargetUseCase: GetCurrencyTargetUseCase,
    private val validIfInputIsValidUseCase: ValidIfInputIsValidUseCase,
    private val currencyConverterUseCase: CurrencyConverterUseCase,
) : ViewModel() {
    private val _viewState = MutableStateFlow(CurrencyConverterViewState())
    val viewState = _viewState.asStateFlow()

    init {
        fetchCurrency()
    }

    fun validIfInputIsValid(input: String, oldValue: String): String {
        return validIfInputIsValidUseCase(
            input = input,
            oldValue = oldValue,
        )
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
    ): BigDecimal? {
        return currencyConverterUseCase(
            source = source,
            target = target,
            currentValue = currentValue,
        )
    }

    fun setSelectedCurrency(currencyId: Long) {
        viewModelScope.launch {
            _viewState.update {
                it.copy(
                    target = getCurrencyTargetUseCase(currencyId = currencyId),
                    result = "",

                    )
            }
        }
    }

    private fun fetchCurrency() {
        viewModelScope.launch {
            _viewState.update {
                it.copy(
                    isLoading = true,
                    isError = false,
                    errorMessage = "",
                )
            }

            try {
                initializeCurrenciesUseCase()
            } catch (ex: UnknownHostException) {
                updateError(
                    isError = true,
                    errorMessage = "Parece que você está no modo avião"
                )
            } catch (ex: HttpException) {
                updateError(
                    isError = true,
                    errorMessage = "Tivemos um problema, tente novamente mais tarde."
                )
            } catch (ex: Exception) {
                updateError(
                    isError = true,
                    errorMessage = "Oops algo deu errado :( "
                )
            }

            _viewState.update {
                it.copy(isLoading = false)
            }
        }
    }

    private fun updateError(
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

    fun onTryAgainClick() {
        fetchCurrency()
    }
}