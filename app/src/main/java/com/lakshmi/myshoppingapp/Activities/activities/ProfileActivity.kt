package com.lakshmi.myshoppingapp.Activities.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    /*
    This Activity Displyas User Profile Details
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initviews()
    }

    fun initviews(){
        tvMyname.text = intent.getStringExtra("name")
        tvMyemail.text=intent.getStringExtra("emailId")
        tvMyphoneNumber.text=intent.getStringExtra("phoneNumber")
        tvMygender.text=intent.getStringExtra("genderF")
        ivProfilepic.setImageURI(Uri.parse(intent.getStringExtra("profilePhoto")))
    }
}