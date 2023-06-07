package com.example.nihilentdemo.data.modal


import com.google.gson.annotations.SerializedName

data class PurchaseType(
    @SerializedName("cartQty")
    val cartQty: Int,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("maxQtyLimit")
    val maxQtyLimit: Int,
    @SerializedName("minQtyLimit")
    val minQtyLimit: Int,
    @SerializedName("purchaseType")
    val purchaseType: String,
    @SerializedName("unitPrice")
    val unitPrice: Double
)