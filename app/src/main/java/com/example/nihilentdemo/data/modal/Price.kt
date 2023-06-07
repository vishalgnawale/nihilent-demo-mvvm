package com.example.nihilentdemo.data.modal


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("isOfferPrice")
    val isOfferPrice: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("value")
    val value: Double
)