package com.example.nihilentdemo.data.repository.product.datasource

import com.example.nihilentdemo.data.modal.ProductList
import retrofit2.Response

interface ProductRemoteDatasource {
    suspend fun getProductList():Response<ProductList>
}