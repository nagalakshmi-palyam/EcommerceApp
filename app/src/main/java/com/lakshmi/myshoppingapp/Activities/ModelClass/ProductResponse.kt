package com.lakshmi.myshoppingapp.Activities.ModelClass
import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class ProductResponse(

	@field:SerializedName("price")
	val price: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("photo_url")
	val photoUrl: String? = null,

	@field:SerializedName("isOnSale")
	val isOnSale: Boolean? = null
)