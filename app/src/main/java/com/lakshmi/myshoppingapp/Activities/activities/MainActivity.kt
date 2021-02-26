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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsandLayouts()
    }

    fun initViewsandLayouts(){
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    launchFramentAllProducts()
                }
                R.id.settings -> {

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