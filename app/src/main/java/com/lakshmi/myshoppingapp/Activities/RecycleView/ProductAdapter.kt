package com.lakshmi.myshoppingapp.Activities.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.Listener.ProductItemClickListener
import com.lakshmi.myshoppingapp.R

class ProductAdapter(private var productList:List<Products>,val itemClickListener: ProductItemClickListener):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.products_item,parent,false)
        return ProductViewHolder(view,itemClickListener)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data=productList[position]
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
       return productList.size;
    }
    fun updateProducts(productList: List<Products>){
        this.productList=productList
        notifyDataSetChanged()
    }
}