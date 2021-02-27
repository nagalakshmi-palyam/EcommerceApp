package com.lakshmi.myshoppingapp.Activities.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lakshmi.myshoppingapp.Activities.LoginViewModel.LoginViewModel
import com.lakshmi.myshoppingapp.Activities.LoginViewModel.LoginViewModelFactory
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    /*
     * This Activity Validates the User details and based on Search Query it Fetches the User
      details and Passes them to next Activity Via intent
     */

    private lateinit var loginViewModel: LoginViewModel
    var isChecked=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    fun initViews(){
        loginViewModel=LoginViewModelFactory(this).create(LoginViewModel::class.java)
        tvsignUp.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        /*
        If the User Already Logged In It directly Navigates to Home Activity
         */
        isChecked = checkBox.isChecked
        if(isChecked){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                if (isDataValid()) {
                    loginViewModel.fetchdataFromDatabse(
                        etUserNamelogin.text.toString(),
                        etPasswordlogin.text.toString()
                    ).observe(this, Observer{
                        if(it!=null){
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.putExtra("user",it.userName)
                            intent.putExtra("phone",it.mobileNumber)
                            intent.putExtra("email",it.emailId)
                            intent.putExtra("gender",it.gender)
                            intent.putExtra("photo",it.profileImage)
                            Log.d("Lakshmi", it.gender)
                            startActivity(intent)
                            Toast.makeText(this@LoginActivity,"User LoggedIn !", Toast.LENGTH_SHORT).show()
                        } else{
                            Toast.makeText(this@LoginActivity,"User not found", Toast.LENGTH_SHORT).show()
                        }

                    })

                }
            }

            R.id.tvsignUp -> {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.checkBox->{

            }
        }
    }

    /*
    EditText Fields Validation
     */

    fun isDataValid(): Boolean {
        if (etUserNamelogin.text.toString().isEmpty()) {
            etUserNamelogin.error = "Please Enter UserName"
            return false
        }
        if(etPasswordlogin.text.toString().isEmpty()){
            etPasswordlogin.error="Password Should not be Empty"
            return false
        }
        return true
    }
}