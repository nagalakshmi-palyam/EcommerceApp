package com.lakshmi.myshoppingapp.Activities.RecycleView

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.Listener.ProductItemClickListener
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.products_item.view.*
import java.text.FieldPosition

class ProductViewHolder(val view:View,val itemClickListener: ProductItemClickListener):RecyclerView.ViewHolder(view) {
    fun setData(product: Products,position:Int){
        view.apply {
            if(product.productImage!=null) {
                Glide.with(context)
                    .load(product.productImage)
                    .into(ivImage)
            } else{
                ivImage.setImageResource(R.drawable.mybangle)
            }
            tvproductName.text=product.productName
            tvproductPrice.text=product.productPrice
            cardView.setOnClickListener {
                itemClickListener.onItemClicked(product,position)
            }
        }
    }
}