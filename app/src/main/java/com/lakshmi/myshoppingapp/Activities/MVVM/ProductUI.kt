package com.lakshmi.myshoppingapp.Activities.MVVM

import com.lakshmi.myshoppingapp.Activities.ModelClass.ProductResponse

sealed  class ProductUI {
    data class Success(val productList:List<ProductResponse>):ProductUI()
    data class Failure(val error:String):ProductUI()
}