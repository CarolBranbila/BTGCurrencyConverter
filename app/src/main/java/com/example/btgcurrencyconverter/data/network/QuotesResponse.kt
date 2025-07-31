package com.example.btgcurrencyconverter.data.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuotesListResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("quotes")
    val quotes: Map<String, Double>
)