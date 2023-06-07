package com.example.nihilentdemo.data.repository.product.datasourceimpl

import com.example.nihilentdemo.data.db.ProductDao
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.data.repository.product.datasource.ProductLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductLocalDatasourceImpl(private val productDao: ProductDao):ProductLocalDatasource {
    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

    override suspend fun saveProductsInDb(productList: List<Product>) {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.saveProducts(productList)
        }
    }

    override suspend fun getWishListProducts(): List<Product> {
       return productDao.getWishProducts()
    }

    override suspend fun updateProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            productDao.updateProduct(product)
        }
    }
}