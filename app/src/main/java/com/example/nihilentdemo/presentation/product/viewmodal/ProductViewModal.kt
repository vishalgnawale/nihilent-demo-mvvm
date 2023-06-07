package com.example.nihilentdemo.presentation.product.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.data.usecase.GetProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProductViewModal(private val getProductsUseCase: GetProductsUseCase): ViewModel() {

    val message = MutableLiveData<Product>()

    fun getProducts()= liveData {
        val products=getProductsUseCase.getProductList()
        emit(products)
    }

    fun getWishListProducts()= liveData {
        val productsList=getProductsUseCase.getWishListProducts()
        emit(productsList)
    }
    fun sendMessage(product: Product) {
        message.value = product
    }

    suspend fun updateProduct(product: Product){
        getProductsUseCase.updateProduct(product)
    }


}