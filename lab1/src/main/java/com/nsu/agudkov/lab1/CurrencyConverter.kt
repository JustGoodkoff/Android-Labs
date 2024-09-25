package com.nsu.agudkov.lab1

import com.google.gson.annotations.SerializedName


data class CurrencyConverter(
    @SerializedName("Date") val date: String,
    @SerializedName("PreviousDate") val previousDate: String,
    @SerializedName("PreviousURL") val previousURL: String,
    @SerializedName("Timestamp") val timestamp: String,
    @SerializedName("Valute") val valute: Map<String, Currency>
)