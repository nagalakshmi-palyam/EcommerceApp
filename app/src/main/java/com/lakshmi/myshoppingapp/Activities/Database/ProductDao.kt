package com.lakshmi.myshoppingapp.Activities.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insertProducts(products: Products)
    @Query(" Select * From products")
    fun getProducts(): LiveData<List<Products>>
    @Query(" Select * From products where productName= :productName")
    fun getSearchProducts(productName:String): LiveData<List<Products>>

}