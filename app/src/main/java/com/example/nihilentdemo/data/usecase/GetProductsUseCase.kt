package com.example.nihilentdemo.data.usecase

import com.example.nihilentdemo.data.domain.repository.ProductRepository
import com.example.nihilentdemo.data.modal.Product

class GetProductsUseCase(private val productRepository: ProductRepository) {
    suspend fun getProductList():List<Product>?=productRepository.getProducts()
    suspend fun getWishListProducts():List<Product>?=productRepository.getWishListProducts()
    suspend fun updateProduct(product: Product)=productRepository.updateProduct(product)
}