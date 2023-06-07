package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.data.db.ProductDao
import com.example.nihilentdemo.data.repository.product.datasource.ProductLocalDatasource
import com.example.nihilentdemo.data.repository.product.datasourceimpl.ProductLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideProductLocalDataSource(productDao: ProductDao):ProductLocalDatasource{
        return ProductLocalDatasourceImpl(productDao)
    }

}