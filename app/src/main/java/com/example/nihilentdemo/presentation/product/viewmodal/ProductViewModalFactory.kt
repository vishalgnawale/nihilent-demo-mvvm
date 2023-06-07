package com.example.nihilentdemo.presentation.product.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nihilentdemo.data.usecase.GetProductsUseCase

class ProductViewModalFactory(private val getProductsUseCase: GetProductsUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModal(getProductsUseCase) as T
    }
}