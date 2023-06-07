package com.example.nihilentdemo.data.modal


import com.example.nihilentdemo.data.modal.Product
import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("products")
    val products: List<Product>
)