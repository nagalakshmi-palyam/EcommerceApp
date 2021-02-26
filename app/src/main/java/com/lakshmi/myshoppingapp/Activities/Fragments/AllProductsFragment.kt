package com.lakshmi.myshoppingapp.Activities.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myshoppingapp.Activities.Database.Products
import com.lakshmi.myshoppingapp.Activities.Listener.ProductItemClickListener
import com.lakshmi.myshoppingapp.Activities.MVVM.ProductViewModel
import com.lakshmi.myshoppingapp.Activities.MVVM.ProductViewModelFactory
import com.lakshmi.myshoppingapp.Activities.RecycleView.ProductAdapter
import com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories.Category
import com.lakshmi.myshoppingapp.Activities.RecyclerViewForCategories.CategoryAdapter
import com.lakshmi.myshoppingapp.Activities.activities.DetailsActivity
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.fragment_all_products.*

class AllProductsFragment : Fragment(),ProductItemClickListener {


    private var categoryList: MutableList<Category> = mutableListOf()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productViewModel:ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private var productList = emptyList<Products>()

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
        productViewModel=ProductViewModelFactory(this.requireContext(),requireActivity()).create(ProductViewModel::class.java)
        setProductlistAdapterandLayout()
        productViewModel.getdataFromAPI()
        fetchProductListFromDatabase()
    }

    private fun buildproductList(){
        categoryList.add(Category("Jeans"))
        categoryList.add(Category("Socks"))
        categoryList.add(Category("Dresses"))
        categoryList.add(Category("Watches"))
        categoryList.add(Category("Bangles"))
        categoryList.add(Category("Sports"))
        categoryList.add(Category("Uniforms"))
        categoryList.add(Category("Sarees"))
    }

    fun setCategoryLayoutanAdapter(){
     val laymanagerhorizontal=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
       categoryAdapter=CategoryAdapter(categoryList)
      categoryRecyclerview.apply{
          layoutManager=laymanagerhorizontal
          adapter=categoryAdapter
      }

    }

    fun setProductlistAdapterandLayout(){
        val linearLayoutmanager=GridLayoutManager(context,2)
         productAdapter=ProductAdapter(productList,this)
        productRecyclerView.apply{
            layoutManager=linearLayoutmanager
            adapter=productAdapter
        }
    }

    fun fetchProductListFromDatabase(){
        productViewModel.fetchFromDatabse().observe(this, {
            it.let{
             this.productList=it
             productAdapter.updateProducts(productList)
             progressbar.visibility=View.GONE
            }

        })
    }

    override fun onItemClicked(product: Products, position: Int) {
      val intent=Intent(requireContext(),DetailsActivity::class.java)
        intent.putExtra("image",product.productImage)
        intent.putExtra("discription",product.productDiscription)
       startActivity(intent)

    }


}