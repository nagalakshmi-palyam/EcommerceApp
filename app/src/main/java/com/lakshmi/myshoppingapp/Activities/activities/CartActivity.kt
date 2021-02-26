package com.lakshmi.myshoppingapp.Activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.Listener.ProductItemClickListener
import com.lakshmi.myshoppingapp.Activities.MVVM.ProductViewModel
import com.lakshmi.myshoppingapp.Activities.MVVM.ProductViewModelFactory
import com.lakshmi.myshoppingapp.Activities.RecycleView.ProductAdapter
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.fragment_all_products.*

class CartActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        initViews()
    }

    fun initViews(){
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit->{
                val intent= Intent(this@CartActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}