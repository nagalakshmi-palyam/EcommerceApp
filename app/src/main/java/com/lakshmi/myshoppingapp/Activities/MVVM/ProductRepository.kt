package com.lakshmi.myshoppingapp.Activities.MVVM

import com.lakshmi.myshoppingapp.Activities.API.ApiService
import com.lakshmi.myshoppingapp.Activities.API.Network
import com.lakshmi.myshoppingapp.Activities.ModelClass.ProductResponse
import retrofit2.Callback

class ProductRepository(private val callback:Callback<List<ProductResponse>>) {
    fun getProductList(){
     val apiclient=Network.getInstance().create(ApiService::class.java)
     val call=apiclient.getProducts()
     call.enqueue(callback)
    }

}