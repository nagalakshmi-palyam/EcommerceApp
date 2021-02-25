package com.lakshmi.myshoppingapp.Activities.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories.Category
import com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories.CategoryAdapter
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.fragment_all_products.*

class AllProductsFragment : Fragment() {
    private var categoryList: MutableList<Category> = mutableListOf()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewsandLayouts()
    }

    fun initViewsandLayouts(){
        buildproductList()
        setCategoryLayoutanAdapter()
    }

    private fun buildproductList(){
        categoryList.add(Category("Jeans"))
        categoryList.add(Category("Socks"))
        categoryList.add(Category("Dresses"))
        categoryList.add(Category("Watches"))
        categoryList.add(Category("Arnaments"))
        categoryList.add(Category("Sports"))
        categoryList.add(Category("Uniforms"))
        categoryList.add(Category("Sarees"))
    }

    fun setCategoryLayoutanAdapter(){
     val laymanagerhorizontal=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
      val categoryAdapter=CategoryAdapter(categoryList)
      categoryRecyclerview.apply{
          layoutManager=laymanagerhorizontal
          adapter=categoryAdapter
      }

    }


}