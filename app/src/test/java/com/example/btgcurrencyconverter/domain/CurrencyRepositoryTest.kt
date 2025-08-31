package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.CurrencyDao
import com.example.btgcurrencyconverter.data.database.CurrencyEntity
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
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
        coEvery {currencyDao.getById(13)} returns expected

        val result = subject.getCurrencyById(13)


        assertEquals(expected,result)

    }

}