package com.example.nihilentdemo.presentation.product.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.nihilentdemo.R
import com.example.nihilentdemo.databinding.ActivityProductBinding
import com.example.nihilentdemo.presentation.product.fragment.ProductFragment
import com.example.nihilentdemo.presentation.product.fragment.ProductWishListFragment


class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
   /* private lateinit var productViewModal: ProductViewModal
    @Inject
    lateinit var productViewModalFactory: ProductViewModalFactory*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_product)
        //(application as Injector).createProductSubComponent().inject(this)
        //productViewModal=ViewModelProvider(this,productViewModalFactory).get(ProductViewModal::class.java)
        //displayProduct()
       val actionbar = supportActionBar
       //set actionbar title
       actionbar?.hide()
        loadFragment(ProductFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(ProductFragment())
                    true
                }
                R.id.fourite -> {
                    loadFragment(ProductWishListFragment())
                    true
                }
                else -> {
                    loadFragment(ProductFragment())
                    true
                }
            }
        }
    }

   /* private fun displayProduct(){
        val responseLivedata=productViewModal.getProducts()
        responseLivedata.observe(this) {
            Log.d("MYTAG", "displayProduct: " + it?.get(0)?.title)
        }
    }*/
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment,fragment)
        transaction.commit()
    }
}