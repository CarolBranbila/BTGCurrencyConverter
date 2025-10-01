package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.CurrencyEntity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class GetCurrencyTargetUseCaseTest {

    @Test
    fun GetCurrencyTargetUseCase_should_return_currency_code_when_finds_currency() {
        runTest {
            val currencyRepository = mockk<CurrencyRepository>()
            val subject = GetCurrencyTargetUseCase(
                currencyRepository = currencyRepository
            )

            val currencyById = 1L
            val code = "USD"
            val currency = CurrencyEntity(
                id = currencyById,
                code = code,
                currencyName = "Dollar"
            )
            val resultExpected = "USD"

            coEvery { currencyRepository.getCurrencyById(currencyById) } returns currency

            val realResult = subject.invoke(currencyById)

            assertEquals(resultExpected, realResult)
        }
    }

    @Test
    fun GetCurrencyTargetUseCase_should_return_currency_code_when_does_not_find_currency() {
        runTest {
            val currencyRepository = mockk<CurrencyRepository>()
            val subject = GetCurrencyTargetUseCase(
                currencyRepository = currencyRepository
            )

            val currencyById = 1L
            val resultExpected = ""

            coEvery { currencyRepository.getCurrencyById(currencyById) } returns null

            val realResult = subject.invoke(currencyById)

            assertEquals(resultExpected, realResult)
        }
    }

}