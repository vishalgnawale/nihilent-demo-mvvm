package com.example.nihilentdemo.data.repository.product.datasource

import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.data.modal.ProductList

interface ProductLocalDatasource {
    suspend fun getAllProducts():List<Product>
    suspend fun saveProductsInDb(productList:List<Product>)
    suspend fun getWishListProducts():List<Product>
    suspend fun updateProduct(product: Product)
}