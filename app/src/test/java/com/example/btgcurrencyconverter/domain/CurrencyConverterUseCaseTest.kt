package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.QuotesDao
import com.example.btgcurrencyconverter.data.database.QuotesEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.QuotesListResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class CurrencyConverterUseCaseTest {

    @Test
    fun CurrencyConverterUseCase_should_to_converter_currency() {
        runBlocking {

            val quotesRepository = mockk<QuotesRepository>()
            val subject = CurrencyConverterUseCase(
                quotesRepository = quotesRepository
            )

            val source = "USD"
            val target = "BRL"
            val currentValue = "10"
            val resultExpected = BigDecimal("52.50")

            val quotesList = listOf(
                QuotesEntity(code = "USDBRL", value = "5.25")
            )

            coEvery { quotesRepository.getQuotesList() } returns quotesList

            val realResult = subject.invoke(
                source = source,
                target = target,
                currentValue = currentValue
            )

            assertEquals(resultExpected,realResult)

        }
    }

    @Test
    fun CurrencyConverterUseCase_should_return_null_when_quote_not_found() {
        runBlocking {

            val quotesRepository = mockk<QuotesRepository>()
            val subject = CurrencyConverterUseCase(
                quotesRepository = quotesRepository
            )

            val source = "USD"
            val target = "BRL"
            val currentValue = "10"
            val resultExpected = null

            val quotesList = emptyList<QuotesEntity>()

            coEvery { quotesRepository.getQuotesList() } returns quotesList

            val realResult = subject.invoke(
                source = source,
                target = target,
                currentValue = currentValue
            )

            assertEquals(resultExpected,realResult)

        }
    }

        @Test
        fun CurrencyConverterUseCase_should_return_null_when_parameters_not_found() {
            runBlocking {

                val quotesRepository = mockk<QuotesRepository>()
                val subject = CurrencyConverterUseCase(
                    quotesRepository = quotesRepository
                )

                val source = "USD"
                val target = ""
                val currentValue = "10"
                val resultExpected = null

                val quotesList = listOf(
                    QuotesEntity(code = "USDBRL", value = "5.25")
                )

                coEvery { quotesRepository.getQuotesList() } returns quotesList

                val realResult = subject.invoke(
                    source = source,
                    target = target,
                    currentValue = currentValue
                )

                assertEquals(resultExpected,realResult)

            }
    }
}