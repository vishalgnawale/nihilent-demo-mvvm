package com.example.nihilentdemo.presentation.product.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nihilentdemo.R
import com.example.nihilentdemo.data.modal.Product
import com.example.nihilentdemo.databinding.FragmentProductBinding
import com.example.nihilentdemo.presentation.di.Injector
import com.example.nihilentdemo.presentation.product.activity.ProductDetailsActivity
import com.example.nihilentdemo.presentation.product.adapter.ProductAdapter
import com.example.nihilentdemo.presentation.product.viewmodal.ProductViewModal
import com.example.nihilentdemo.presentation.product.viewmodal.ProductViewModalFactory
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private lateinit var productViewModal: ProductViewModal
    @Inject
    lateinit var productViewModalFactory: ProductViewModalFactory
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as Injector).createProductSubComponent().inject(this)
        productViewModal=ViewModelProvider(this,productViewModalFactory).get(ProductViewModal::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.productsProgressBar.visibility=View.VISIBLE
        binding.productRecyclerView.layoutManager= LinearLayoutManager(activity)
        productAdapter=ProductAdapter({selectedItem:Product->listItemClicked(selectedItem)},{selectedItem:Product->addInWishList(selectedItem)})
        binding.productRecyclerView.adapter=productAdapter
        displayProduct()
    }
    private fun displayProduct(){
        val responseLiveData=productViewModal.getProducts()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                productAdapter.setList(it)
                productAdapter.notifyDataSetChanged()
                binding.productsProgressBar.visibility=View.GONE
            }else{
                binding.productsProgressBar.visibility=View.GONE
            }
        })

    }

    private fun openDetailsProduct(product: Product){
        val intent = Intent(activity, ProductDetailsActivity::class.java)
        intent.putExtra("product",Gson().toJson(product) )
        startActivity(intent)

    }
    private fun listItemClicked(product: Product){
        //Toast.makeText(this,"Subscriber name "+subscriber.name,Toast.LENGTH_LONG).show()
        productViewModal.sendMessage(product)
        openDetailsProduct(product)
    }

    private fun addInWishList(product: Product){

        product.apply {
            this.isInWishlist=true
        }
        CoroutineScope(Dispatchers.Main).async {
            productViewModal.updateProduct(product)
            Toast.makeText(activity,"Product added successfully in Wishlist! "+product.title,Toast.LENGTH_LONG).show()
        }
    }
}