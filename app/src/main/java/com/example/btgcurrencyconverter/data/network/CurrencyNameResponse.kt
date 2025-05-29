package com.example.btgcurrencyconverter.data.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("currencies")
    val currencies: Map<String, String>
)
