package com.example.btgcurrencyconverter.domain

import com.example.btgcurrencyconverter.data.database.QuotesDao
import com.example.btgcurrencyconverter.data.database.QuotesEntity
import com.example.btgcurrencyconverter.data.network.BTGApi
import com.example.btgcurrencyconverter.data.network.QuotesListResponse
import javax.inject.Inject

class QuotesRepository @Inject constructor (
    private val api: BTGApi,
    private val quotesDao: QuotesDao,
){
    suspend fun fetchQuotesList(){
        val response = api.getQuotesList()

        val entityQuoteList = response.toEntity()

        quotesDao.insertAll(entityQuoteList)
    }

    suspend fun getQuotesList(): List<QuotesEntity> {
        return quotesDao.getAll()
    }
}

fun QuotesListResponse.toEntity(): List<QuotesEntity>{
    return this.quotes.map{
        QuotesEntity(
            code = it.key,
            value = it.value.toString(),
        )
    }
}