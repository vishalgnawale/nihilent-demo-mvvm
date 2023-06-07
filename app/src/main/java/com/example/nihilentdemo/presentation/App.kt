package com.example.nihilentdemo.presentation

import android.app.Application
import com.example.nihilentdemo.presentation.di.Injector
import com.example.nihilentdemo.presentation.di.core.*
import com.example.nihilentdemo.presentation.di.product.ProductSubComponent

class App : Application(),Injector{
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule("https://run.mocky.io/"))
            .remoteDataModule(RemoteDataModule())
            .build()
    }
    override fun createProductSubComponent(): ProductSubComponent {
        return appComponent.productSubComponent().create()
    }
}