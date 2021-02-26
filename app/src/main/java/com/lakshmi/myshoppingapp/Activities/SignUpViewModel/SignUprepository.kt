package com.lakshmi.myshoppingapp.Activities.SignUpViewModel

import android.content.Context
import com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase.DetailsDatabase
import com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase.UserDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUprepository{
    fun insertDetailstoRepository(userName:String,mobileNumber:String,emailId:String,passWord:String,gender:String,profileImage:String,context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val userDetails = UserDetails(userName = userName,mobileNumber = mobileNumber,emailId = emailId,passWord = passWord,gender = gender,profileImage = profileImage)
            DetailsDatabase.getInstance(context).detailsDao.insertUserDetails(userDetails)
        }
    }
}