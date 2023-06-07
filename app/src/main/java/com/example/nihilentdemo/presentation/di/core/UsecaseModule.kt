package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.data.domain.repository.ProductRepository
import com.example.nihilentdemo.data.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides

@Module
class UsecaseModule {

    @Provides
    fun provideProductUsecase(productRepository: ProductRepository):GetProductsUseCase{
        return GetProductsUseCase(productRepository)
    }
}