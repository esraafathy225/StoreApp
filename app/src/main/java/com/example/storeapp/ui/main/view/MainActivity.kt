package com.example.storeapp.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityMainBinding
import com.example.storeapp.ui.main.adapter.ProductsAdapter
import com.example.storeapp.ui.main.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    lateinit var binding : ActivityMainBinding
    val mainViewModel : MainViewModel by viewModels()
    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)


        mainViewModel.getProducts()
        mainViewModel.products.observe(this, Observer {
            productsAdapter= ProductsAdapter(it.products)
            binding.rvProducts.adapter=productsAdapter
        })
    }
}
