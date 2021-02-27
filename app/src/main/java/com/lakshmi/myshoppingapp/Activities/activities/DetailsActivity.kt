package com.lakshmi.myshoppingapp.Activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.products_item.view.*

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    /*
     This Activity Represents Details of Particular Product and Supports to add those Products to
     cart
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
    }

    fun initViews(){
        discription.text=intent.getStringExtra("discription")
        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .into(ivProduct)
        addToCart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.addToCart->{
                Toast.makeText(this@DetailsActivity,"Order SuccessFully Placed", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, CartActivity::class.java)
                startActivity(intent)
            }
        }
    }
}