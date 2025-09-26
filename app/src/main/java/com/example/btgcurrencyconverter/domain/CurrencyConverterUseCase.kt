package com.example.btgcurrencyconverter.domain

import java.math.BigDecimal
import javax.inject.Inject

class CurrencyConverterUseCase @Inject constructor(
    private val quotesRepository: QuotesRepository,
) {
    suspend operator fun invoke(
        source: String,
        target: String,
        currentValue: String,
    ): BigDecimal? {
        val currentQuote =
            quotesRepository.getQuotesList().firstOrNull { it.code == "$source$target" }?.value

        return currentQuote?.let {
            BigDecimal(it)
                .multiply(BigDecimal(currentValue.replace(",", ".")))
        }
    }
}