package com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DetailsDao {
    @Insert
    suspend fun insertUserDetails(userDetails: UserDetails)
    @Query("Select * From details where userName= :userName and passWord= :password")
    fun getUserDetails(userName:String,password:String): LiveData<UserDetails>
}