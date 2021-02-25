package com.lakshmi.myshoppingapp.Activities.Listener

import com.lakshmi.myshoppingapp.Activities.Database.Products

interface ProductItemClickListener {
    fun onItemClicked(product: Products, position:Int)
}