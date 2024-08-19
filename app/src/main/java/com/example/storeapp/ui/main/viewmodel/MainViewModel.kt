package com.example.storeapp.ui.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.storeapp.data.models.ProductsResponse
import com.example.storeapp.data.remote.ProductService
import com.example.storeapp.data.remote.RetrofitClient
import com.example.storeapp.data.remote.RetrofitClient.Companion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (val app:Application) : AndroidViewModel(app) {

    private var _products: MutableLiveData<ProductsResponse> = MutableLiveData()
    val products: LiveData<ProductsResponse> = _products


    fun getProducts() {
        viewModelScope.launch (Dispatchers.IO){
            val retrofit = RetrofitClient.getInstance(app.applicationContext)
            val productService = retrofit!!.create(ProductService::class.java)
            val result = productService.getProducts()
            _products.postValue(result)
        }
    }

}