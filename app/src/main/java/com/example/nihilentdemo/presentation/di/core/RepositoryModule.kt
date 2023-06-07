package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.data.domain.repository.ProductRepository
import com.example.nihilentdemo.data.repository.product.ProductRepositoryImpl
import com.example.nihilentdemo.data.repository.product.datasource.ProductLocalDatasource
import com.example.nihilentdemo.data.repository.product.datasource.ProductRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productRemoteDatasource: ProductRemoteDatasource,
        productLocalDatasource: ProductLocalDatasource
    ):ProductRepository{
        return ProductRepositoryImpl(productRemoteDatasource,productLocalDatasource)
    }
}