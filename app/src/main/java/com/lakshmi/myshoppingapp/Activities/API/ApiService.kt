package com.lakshmi.myshoppingapp.Activities.API

import com.lakshmi.myshoppingapp.Activities.ModelClass.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
@GET("api/ecommerce/v1/allProducts")
fun getProducts():Call<List<ProductResponse>>
}