package com.lakshmi.myshoppingapp.Activities.SignUpViewModel

import android.content.Context
import androidx.lifecycle.ViewModel

class SignUpViewModel(private val context: Context) :ViewModel() {
    private val repository= SignUprepository()

    fun insertDetailstodatabase(userName:String,mobileNumber:String,emailId:String,passWord:String,gender:String,profileImage:String){
        repository.insertDetailstoRepository(
            userName,mobileNumber, emailId, passWord, gender, profileImage, context
        )
    }
}