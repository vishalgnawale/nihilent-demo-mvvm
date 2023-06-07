package com.example.nihilentdemo.presentation.di.core

import android.content.Context
import com.example.nihilentdemo.presentation.di.product.ProductSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ProductSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}
