package com.example.nihilentdemo.presentation.di.product

import com.example.nihilentdemo.data.usecase.GetProductsUseCase
import com.example.nihilentdemo.presentation.product.viewmodal.ProductViewModalFactory
import dagger.Module
import dagger.Provides

@Module
class ProductModule {
    @ProductScope
    @Provides
    fun provideProductViewModalFactory(getProductsUseCase: GetProductsUseCase): ProductViewModalFactory {
        return ProductViewModalFactory(getProductsUseCase)
    }
}