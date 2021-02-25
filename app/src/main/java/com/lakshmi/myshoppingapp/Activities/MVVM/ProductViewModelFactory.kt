package com.lakshmi.myshoppingapp.Activities.MVVM

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductViewModelFactory(private val context: Context,private val owner: LifecycleOwner):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProductViewModel::class.java)){
            return ProductViewModel(context,owner) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}