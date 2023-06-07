package com.example.nihilentdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.nihilentdemo.data.db.ProductDao
import com.example.nihilentdemo.data.db.ProductDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideProductDatabase(context: Context):ProductDatabase{
        return Room.databaseBuilder(context,ProductDatabase::class.java,"productdatabase").build()
    }

    @Singleton
    @Provides
    fun provideProductDao(productDatabase: ProductDatabase):ProductDao{
        return productDatabase.productDao()
    }

}