package com.example.nihilentdemo.data.repository.product.datasourceimpl

import com.example.nihilentdemo.data.api.ProductService
import com.example.nihilentdemo.data.modal.ProductList
import com.example.nihilentdemo.data.repository.product.datasource.ProductRemoteDatasource
import retrofit2.Response

class ProductRemoteDatasourceImpl(private val productService: ProductService) :ProductRemoteDatasource{
    override suspend fun getProductList(): Response<ProductList> {
        return productService.getProductList()
    }

}