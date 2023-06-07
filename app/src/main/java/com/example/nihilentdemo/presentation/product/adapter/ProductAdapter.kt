package com.example.nihilentdemo.presentation.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nihilentdemo.R
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.databinding.ProductItemsBinding

 class ProductAdapter(
     private val clickListener:(Product)->Unit,
     private val addInWishlist:(Product)->Unit
 ):RecyclerView.Adapter<ProductViewHolder> (){

    private val productList=ArrayList<Product>()

    fun setList(products:List<Product>){
        productList.clear()
        productList.addAll(products)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater:LayoutInflater =LayoutInflater.from(parent.context)
        val binding : ProductItemsBinding =DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_items,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position],clickListener,addInWishlist)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

class ProductViewHolder(private val binding: ProductItemsBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(
        product: Product,
        clickListener:(Product)->Unit,
        addInWishlist:(Product)->Unit
    ){
        binding.productName.text=product.title
        binding.price.text= product.saleUnitPrice.toString()
        val posterURL = product.imageURL
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

        binding.listItemLayout.setOnClickListener {
            clickListener(product)
        }

        binding.addInWishlist.setOnClickListener {
            addInWishlist(product)
        }
    }
}