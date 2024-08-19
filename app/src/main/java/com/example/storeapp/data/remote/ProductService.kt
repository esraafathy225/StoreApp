package com.example.storeapp.data.remote

import com.example.storeapp.data.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse

}