package com.example.nihilentdemo.presentation.di

import com.example.nihilentdemo.presentation.di.product.ProductSubComponent

interface Injector {
    fun createProductSubComponent():ProductSubComponent
}