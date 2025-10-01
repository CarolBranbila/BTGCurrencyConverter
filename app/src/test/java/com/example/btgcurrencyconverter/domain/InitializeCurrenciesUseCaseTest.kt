package com.example.btgcurrencyconverter.domain

import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class InitializeCurrenciesUseCaseTest {

    private val currencyRepository = mockk<CurrencyRepository>()
    private val quotesRepository = mockk<QuotesRepository>()

    private val subject = InitializeCurrenciesUseCase(
        currencyRepository = currencyRepository,
        quotesRepository = quotesRepository
    )

    @Test
    fun invoke_SHOULD_call_fetch_methods_on_both_repositories(){
        runTest {
            coEvery { currencyRepository.fetchCurrencyList() } just Runs
            coEvery { quotesRepository.fetchQuotesList() } just Runs

            subject.invoke()

            coVerify(exactly = 1) { currencyRepository.fetchCurrencyList() }
            coVerify(exactly = 1) { quotesRepository.fetchQuotesList() }
        }
    }

    @Test
    fun invoke_SHOULD_call_fetch_methods_in_order(){
        runTest {
            coEvery { currencyRepository.fetchCurrencyList() } just Runs
            coEvery { quotesRepository.fetchQuotesList() } just Runs

            subject.invoke()

            coVerifySequence {
                currencyRepository.fetchCurrencyList()
                quotesRepository.fetchQuotesList()
            }
        }
    }


}