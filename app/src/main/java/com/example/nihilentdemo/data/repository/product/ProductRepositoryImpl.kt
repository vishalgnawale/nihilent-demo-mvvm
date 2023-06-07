package com.example.nihilentdemo.data.repository.product

import android.util.Log
import com.example.nihilentdemo.data.domain.repository.ProductRepository
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.data.repository.product.datasource.ProductLocalDatasource
import com.example.nihilentdemo.data.repository.product.datasource.ProductRemoteDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProductRepositoryImpl(
    private val productRemoteDatasource: ProductRemoteDatasource,
    private val productLocalDatasource: ProductLocalDatasource
    ) :ProductRepository{
    override suspend fun getProducts(): List<Product> {
        return getProductsFromDb()
    }

    override suspend fun getWishListProducts(): List<Product> {
        return productLocalDatasource.getWishListProducts()
    }

    override suspend fun updateProduct(product: Product) {
        productLocalDatasource.updateProduct(product)
    }

    suspend fun getProductFromAPI():List<Product>{
        lateinit var productList:List<Product>
        try {
            val response=productRemoteDatasource.getProductList()
            val body=response.body()
            if(body!=null){
                productList=body.products
            }
        }catch (e:Exception){
            Log.d("MYTAG",e.message.toString())
        }
        return productList
    }

    suspend fun getProductsFromDb():List<Product>{
        lateinit var productList:List<Product>
        try {
            productList=productLocalDatasource.getAllProducts()
        }catch (e:Exception){
            Log.d("MYTAG",e.message.toString())
        }
        if(productList.size>0){
            return productList
        }else{
            productList=getProductFromAPI()
            productLocalDatasource.saveProductsInDb(productList)
        }
        return productList
    }

}