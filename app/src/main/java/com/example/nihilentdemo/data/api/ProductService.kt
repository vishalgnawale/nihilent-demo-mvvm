package com.example.nihilentdemo.data.api

import com.example.nihilentdemo.data.modal.ProductList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("v3/2f06b453-8375-43cf-861a-06e95a951328")
    suspend fun getProductList(
    ):Response<ProductList>
}