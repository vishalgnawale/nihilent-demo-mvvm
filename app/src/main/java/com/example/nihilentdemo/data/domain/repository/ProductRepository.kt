package com.example.nihilentdemo.data.domain.repository

import com.example.nihilentdemo.data.modal.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getWishListProducts(): List<Product>
    suspend fun updateProduct(product: Product)

}