package com.lakshmi.myshoppingapp.Activities.MVVM

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myshoppingapp.Activities.Database.ProductDatabase
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.ModelClass.ProductResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(val context: Context,private val owner: LifecycleOwner):ViewModel(),Callback<List<ProductResponse>> {
private val productRepository= ProductRepository(this)
private val mutableList=MutableLiveData<ProductUI>()
val liveData:LiveData<ProductUI> = mutableList
    fun getdataFromAPI(){
     ProductDatabase.getInstance(context).productDao.getProducts().observe(owner,{
         if(it.isNullOrEmpty()) {
             productRepository.getProductList()
         }
     })
    }

    override fun onResponse(
        call: Call<List<ProductResponse>>,
        response: Response<List<ProductResponse>>
    ) {

        response.body()?.let{
         CoroutineScope(IO).launch {

                 for(i in 0 until it.size){
                  val products= Products(productName = it[i].name.toString(),productPrice = it[i].price.toString(),
                      productImage = it[i].photoUrl.toString(),productDiscription = it[i].description.toString())
                  ProductDatabase.getInstance(context).productDao.insertProducts(products)
                 }

         }

        }

    }

    override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {

    }

    fun fetchFromDatabse() : LiveData<List<Products>> {
     return ProductDatabase.getInstance(context).productDao.getProducts()

    }

}