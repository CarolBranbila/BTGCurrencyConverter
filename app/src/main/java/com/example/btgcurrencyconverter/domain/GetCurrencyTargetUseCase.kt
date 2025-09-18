package com.example.btgcurrencyconverter.domain

import javax.inject.Inject
import kotlin.code

class GetCurrencyTargetUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository,
) {
    suspend operator fun invoke(currencyId: Long): String {
        return currencyRepository.getCurrencyById(currencyId)?.code.orEmpty()
    }
}