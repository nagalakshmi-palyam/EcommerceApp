package com.lakshmi.myshoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsandLayouts()
    }

    fun initViewsandLayouts(){
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {

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

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }
}