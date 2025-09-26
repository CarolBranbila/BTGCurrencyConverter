package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.CurrencyDao
import com.example.btgcurrencyconverter.data.database.CurrencyEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.CurrencyResponse
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import kotlin.test.Test

class CurrencyRepositoryTest {

    @Test
    fun getCurrencyById_return_correct() = runBlocking {
        val currencyDao = mockk<CurrencyDao>()
        val subject = CurrencyRepository(
            api = mockk(),
            currencyDao = currencyDao,
        )
        val expected = CurrencyEntity(
            id = 13,
            code = "USD",
            currencyName = "Dollar"
        )
        coEvery { currencyDao.getById(13) } returns expected

        val result = subject.getCurrencyById(13)


        assertEquals(expected, result)

    }

    @Test
    fun getCurrencyList_return_correct() = runBlocking {
        val currencyDao = mockk<CurrencyDao>()
        val subject = CurrencyRepository(
            api = mockk(),
            currencyDao = currencyDao,
        )
        val expected = listOf(
            CurrencyEntity(
                id = 13,
                code = "USD",
                currencyName = "Dollar"
            )
        )
        coEvery { currencyDao.getAll() } returns expected

        val result = subject.getCurrencyList()

        assertEquals(expected, result)

    }

    @Test
    fun fetCurrencyList_and_currency_empty_should_fetch_currencies() = runBlocking {
        val currencyDao = mockk<CurrencyDao>()
        val api = mockk<BTGApi>()
        val subject = CurrencyRepository(
            api = api,
            currencyDao = currencyDao,
        )
        val expected = listOf(
            CurrencyEntity(
                id = 0,
                code = "USD",
                currencyName = "Dollar"
            )
        )
        coEvery { currencyDao.getAll() } returns emptyList()
        coEvery { currencyDao.insertAll(any()) } just Runs

        val currencyResponse = CurrencyResponse(
            success = true,
            currencies = mapOf("USD" to "Dollar")
        )
        coEvery { api.getCurrencyNameList() } returns currencyResponse

        subject.fetchCurrencyList()

        coVerify(exactly = 1) { currencyDao.insertAll(expected) }
    }

    @Test
    fun fetCurrencyList_and_currency_not_empty_should__not_fetch_currencies() = runBlocking {
        val currencyDao = mockk<CurrencyDao>()
        val api = mockk<BTGApi>()
        val subject = CurrencyRepository(
            api = api,
            currencyDao = currencyDao,
        )
        val currencyContent = listOf(
            CurrencyEntity(
                id = 0,
                code = "USD",
                currencyName = "Dollar"
            )
        )
        coEvery { currencyDao.getAll() } returns currencyContent
        coEvery { currencyDao.insertAll(any()) } just Runs

        val currencyResponse = CurrencyResponse(
            success = true,
            currencies = mapOf("USD" to "Dollar")
        )
        coEvery { api.getCurrencyNameList() } returns currencyResponse

        subject.fetchCurrencyList()

        coVerify(exactly = 0) { currencyDao.insertAll(any()) }
    }

}