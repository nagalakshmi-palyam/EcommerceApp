package com.lakshmi.myshoppingapp.Activities.MVVM

import android.content.Context
import androidx.lifecycle.LiveData
import com.lakshmi.myshoppingapp.Activities.API.ApiService
import com.lakshmi.myshoppingapp.Activities.API.Network
import com.lakshmi.myshoppingapp.Activities.Database.ProductDatabase
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.ModelClass.ProductResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Callback

class ProductRepository(private val callback:Callback<List<ProductResponse>>) {
    fun getProductList(){
     val apiclient=Network.getInstance().create(ApiService::class.java)
     val call=apiclient.getProducts()
     call.enqueue(callback)
    }

    fun fetchProductsFromDatabse(context: Context): LiveData<List<Products>> {
            return ProductDatabase.getInstance(context)
                .productDao.getProducts()

    }
    fun searchProductsFromDatabse(productName:String,context: Context): LiveData<List<Products>> {
        return ProductDatabase.getInstance(context)
            .productDao.getSearchProducts(productName)
    }
}