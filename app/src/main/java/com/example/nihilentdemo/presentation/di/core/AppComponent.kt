package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.presentation.di.product.ProductSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
NetworkModule::class,
AppModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UsecaseModule::class,
DatabaseModule::class,
LocalDataModule::class
])
interface AppComponent {
    fun productSubComponent():ProductSubComponent.Factory
}