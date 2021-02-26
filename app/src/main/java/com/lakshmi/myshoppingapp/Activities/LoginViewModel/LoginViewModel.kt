package com.lakshmi.myshoppingapp.Activities.LoginViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase.DetailsDatabase
import com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase.UserDetails

class LoginViewModel(private val context: Context): ViewModel() {
    fun fetchdataFromDatabse(userName:String,passWord:String): LiveData<UserDetails> {
        return DetailsDatabase.getInstance(context).detailsDao.getUserDetails(userName,passWord)
    }
}