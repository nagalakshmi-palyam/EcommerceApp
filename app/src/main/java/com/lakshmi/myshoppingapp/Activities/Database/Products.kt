package com.lakshmi.myshoppingapp.Activities.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products (
    @PrimaryKey(autoGenerate = true)
    var productId:Int=0,
    @ColumnInfo(name="productName")
    val productName:String,
    @ColumnInfo(name = "productPrice")
    val productPrice:String,
    @ColumnInfo(name = "productImage")
    val productImage:String
)