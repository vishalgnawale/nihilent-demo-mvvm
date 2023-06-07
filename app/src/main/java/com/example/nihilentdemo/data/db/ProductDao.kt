package com.example.nihilentdemo.data.db

import androidx.room.*
import com.example.nihilentdemo.data.modal.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(movies:List<Product>)

    @Query("DELETE from products")
    suspend fun deleteAllProducts()

    @Query("SELECT * from products")
    suspend fun getAllProducts():List<Product>

    @Query("SELECT * from products WHERE isInWishlist=1")
    suspend fun getWishProducts():List<Product>

    @Update
    suspend fun updateProduct(product: Product)
}