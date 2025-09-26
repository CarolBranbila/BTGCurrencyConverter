package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.QuotesDao
import com.example.btgcurrencyconverter.data.database.QuotesEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.QuotesListResponse
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class QuotesRepositoryTest {

    @Test
    fun getQuotesList_return_correct() = runBlocking {
        val quotesDao = mockk<QuotesDao>()
        val subject = QuotesRepository(
            api = mockk(),
            quotesDao = quotesDao,
        )
        val expected = listOf(
            QuotesEntity(
                id = 13,
                code = "USD",
                value = "Dollar"
            )
        )
        coEvery { quotesDao.getAll() } returns expected

        val result = subject.getQuotesList()

        assertEquals(expected, result)

    }

    @Test
    fun fetchQuotesList_should_fetch_and_save_quotes_successfully() = runBlocking {
        val quotesDao = mockk<QuotesDao>()
        val api = mockk<BTGApi>()
        val subject = QuotesRepository(
            api = api,
            quotesDao = quotesDao
        )
        val quotesListResponse = QuotesListResponse(
            success = true,
            quotes = mapOf("USDBRL" to 5.25),
        )
        val expected = listOf(
            QuotesEntity(code = "USDBRL", value = "5.25")
        )

        coEvery { api.getQuotesList() } returns quotesListResponse
        coEvery { quotesDao.insertAll(any()) } just Runs

        subject.fetchQuotesList()

        coVerify(exactly = 1) { quotesDao.insertAll(expected) }
        coVerify(exactly = 1) { api.getQuotesList() }
    }
}