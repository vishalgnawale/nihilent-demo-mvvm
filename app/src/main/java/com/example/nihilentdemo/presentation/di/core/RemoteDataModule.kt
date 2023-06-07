package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.data.api.ProductService
import com.example.nihilentdemo.data.repository.product.datasource.ProductRemoteDatasource
import com.example.nihilentdemo.data.repository.product.datasourceimpl.ProductRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideProductRemoteDatasource(productService: ProductService):ProductRemoteDatasource{
        return ProductRemoteDatasourceImpl(productService)
    }

}