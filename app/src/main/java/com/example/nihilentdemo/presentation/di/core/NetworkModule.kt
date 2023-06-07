package com.example.nihilentdemo.presentation.di.core

import com.example.nihilentdemo.data.api.ProductService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule (private val baseUrl:String){

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit):ProductService{
        return retrofit.create(ProductService::class.java)
    }
}