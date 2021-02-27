package com.lakshmi.myshoppingapp.Activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.lakshmi.myshoppingapp.Activities.Fragments.AllProductsFragment
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    This Activity Having Navigation Drawer along with inflating a view of Coordinator layout for
    Toolbar Actions
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsandLayouts()
    }

    fun initViewsandLayouts(){
        val userName=intent.getStringExtra("user")
        val phoneNumber=intent.getStringExtra("phone")
        val emaiId=intent.getStringExtra("email")
        val gender=intent.getStringExtra("gender")
        val profilePic=intent.getStringExtra("photo")
       // Log.d("Lakshmi", intent.getStringExtra("user")+"")

        /*
        Navigation Drawer Items Action
         */
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    launchFramentAllProducts()
                }
                R.id.profile -> {
                    val intent =Intent(this@MainActivity,ProfileActivity::class.java)
                    intent.putExtra("name",userName)
                    intent.putExtra("phoneNumber",phoneNumber)
                    intent.putExtra("emailId",emaiId)
                    intent.putExtra("genderF",gender)
                    intent.putExtra("profilePhoto",profilePic)
                    startActivity(intent)
                }
                R.id.cart->{
                    val intent =Intent(this@MainActivity,CartActivity::class.java)
                    startActivity(intent)
                }
            }
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_homedrawer)
        }
        launchFramentAllProducts()
    }

    /*
     Toolbar Items Action
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.actionCart) {
            Log.d("daniel", "going to cart")
            startActivity(Intent(this, CartActivity::class.java))
            return true
        }
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    fun launchFramentAllProducts(){
        val fragment=AllProductsFragment()
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout,fragment,"Product Fragment").addToBackStack("ProductFragment").commit()
    }
}