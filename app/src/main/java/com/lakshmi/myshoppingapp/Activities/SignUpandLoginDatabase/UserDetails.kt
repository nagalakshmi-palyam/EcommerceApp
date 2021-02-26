package com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
data class UserDetails (
    @PrimaryKey(autoGenerate = true)
    var userid: Int = 0,
    @ColumnInfo(name = "userName")
    val userName: String,
    @ColumnInfo(name= "mobileNumber")
    val mobileNumber:String,
    @ColumnInfo(name="emailId")
    val emailId:String,
    @ColumnInfo(name="gender")
    val gender:String,
    @ColumnInfo(name="passWord")
    val passWord:String,
    @ColumnInfo(name = "profileImage")
    val profileImage:String
    )