package com.example.btgcurrencyconverter.domain

import javax.inject.Inject

class InitializeCurrenciesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val quotesRepository: QuotesRepository,
) {
    suspend operator fun invoke() {
        currencyRepository.fetchCurrencyList()
        quotesRepository.fetchQuotesList()
    }
}