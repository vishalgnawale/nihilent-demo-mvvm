package com.example.nihilentdemo.presentation.product.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.nihilentdemo.R
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.databinding.ActivityProductDetailsBinding
import com.google.gson.Gson

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_details)
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Product Details"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        val productObj=intent.getStringExtra("product")
        val product=Gson().fromJson(productObj,Product::class.java)
        displayProductDetails(product)
    }
    private fun displayProductDetails(product: Product){
        if(product!=null) {
            Glide.with(binding.productImage.context)
                .load(product.imageURL)
                .into(binding.productImage)

            binding.productTitle.text = product.title
            binding.productPrice.text = product.saleUnitPrice.toString()
            binding.ratingBar.rating= (product.ratingCount?.toFloat() ?:0) as Float

            if(product.isInWishlist == true){
                binding.fouriteIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_24))
            }else{
                binding.fouriteIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_border_24))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}