package com.example.nihilentdemo.presentation.di.product

import com.example.nihilentdemo.presentation.product.activity.ProductActivity
import com.example.nihilentdemo.presentation.product.fragment.ProductFragment
import com.example.nihilentdemo.presentation.product.fragment.ProductWishListFragment
import dagger.Subcomponent

@ProductScope
@Subcomponent(modules = [ProductModule::class])
interface ProductSubComponent {
    fun inject(productFragment: ProductFragment)
    fun inject(productWishListFragment: ProductWishListFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():ProductSubComponent
    }
}