package com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myshoppingapp.Activities.RecycleView.ProductViewHolder
import com.lakshmi.myshoppingapp.R

class CategoryAdapter(var categoryList:List<Category>):RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.category_items,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       val data=categoryList[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}