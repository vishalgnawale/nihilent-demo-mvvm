package com.example.nihilentdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nihilentdemo.data.modal.Product

@Database(entities =[Product::class]
    , version = 1,
    exportSchema = false)
abstract class ProductDatabase():RoomDatabase() {
    abstract fun productDao():ProductDao
}