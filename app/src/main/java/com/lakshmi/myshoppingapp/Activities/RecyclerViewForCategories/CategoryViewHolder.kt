package com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_items.view.*

class CategoryViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun setData(category:Category){
        view.apply{
            tvCategory.text=category.category
        }
    }
}