package com.example.nihilentdemo.data.modal


import com.google.gson.annotations.SerializedName

data class Messages(
    @SerializedName("promotionalMessage")
    val promotionalMessage: String,
    @SerializedName("sash")
    val sash: Sash,
    @SerializedName("secondaryMessage")
    val secondaryMessage: String
)