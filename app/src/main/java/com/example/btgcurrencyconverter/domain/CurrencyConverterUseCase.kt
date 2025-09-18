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
        ) : BigDecimal{
        return BigDecimal(
            quotesRepository.getQuotesList().first { it.code == "$source$target" }.value
        ).multiply(BigDecimal(currentValue.replace(",", ".")))
    }

}