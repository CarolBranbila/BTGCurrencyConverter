package com.example.btgcurrencyconverter.domain

import java.math.BigDecimal
import javax.inject.Inject

class ValidIfInputIsValidUseCase @Inject constructor() {
    operator fun invoke(oldValue: String, input: String): String {
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
}