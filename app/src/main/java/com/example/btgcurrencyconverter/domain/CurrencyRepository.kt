package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.CurrencyDao
import com.example.btgcurrencyconverter.data.database.CurrencyEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.CurrencyResponse
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency
import javax.inject.Inject
import kotlin.text.isEmpty

class CurrencyRepository @Inject constructor(
    private val api: BTGApi,
    private val currencyDao: CurrencyDao,
) {

    suspend fun fetchCurrencyList() {
        if (currencyDao.getAll().isEmpty()){
            val response = api.getCurrencyNameList()

            val entityList = response.toEntity()

            currencyDao.insertAll(entityList)
        }

    }

    suspend fun getCurrencyList(): List<CurrencyEntity> {
        return currencyDao.getAll()
    }

    suspend fun getCurrencyById(id: Long): CurrencyEntity? {
        return currencyDao.getById(id)
    }
}

private fun CurrencyResponse.toEntity(): List<CurrencyEntity> {
    return this.currencies.map {
        CurrencyEntity(
            code = it.key,
            currencyName = it.value,
        )
    }
}