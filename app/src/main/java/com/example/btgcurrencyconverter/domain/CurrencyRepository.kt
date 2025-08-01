package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.CurrencyDao
import com.example.btgcurrencyconverter.data.database.CurrencyEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.CurrencyResponse
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val api: BTGApi,
    private val currencyDao: CurrencyDao,
) {

    /**
     * Download currencies
     * Convert them to database entities
     * Save them on database
     */
    suspend fun fetchCurrencyList() {
        val response = api.getCurrencyNameList()

        val entityList = response.toEntity()

        currencyDao.insertAll(entityList)
    }

    suspend fun getCurrencyList(): List<CurrencyEntity> {
        return currencyDao.getAll()
    }

    //getCurrencyByID
}

private fun CurrencyResponse.toEntity(): List<CurrencyEntity> {
    return this.currencies.map {
        CurrencyEntity(
            code = it.key,
            currencyName = it.value,
        )
    }
}