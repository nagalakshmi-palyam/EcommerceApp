package com.lakshmi.myshoppingapp.Activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    fun initViews(){
        loginViewModel=LoginViewModelFactory(this).create(LoginViewModel::class.java)
        btnLogin.setOnClickListener(this)
        tvsignUp.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                if (isDataValid()) {
                    loginViewModel.fetchdataFromDatabse(
                        etPasswordlogin.text.toString(),
                        etPasswordlogin.text.toString()
                    ).observe(this, Observer{
                        if(it!=null){
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }

                    })

                }
            }

            R.id.tvsignUp -> {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun isDataValid(): Boolean {
        if (etUserNamelogin.text.toString().isEmpty()) {
            etUserNamelogin.error = "Please Enter Mobile Number"
            return false
        }
        if(etPasswordlogin.text.toString().isEmpty()){
            etPasswordlogin.error="Password Should not be Empty"
            return false
        }
        return true
    }
}