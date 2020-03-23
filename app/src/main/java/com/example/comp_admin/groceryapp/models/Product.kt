package com.example.comp_admin.groceryapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(
    var productName: String,
    @SerializedName("image")
    var productImage: String,
    var price: String,
    var mrp: String,
    var _id: String,
    var quantity: Int = 0
) : Serializable {
    companion object {
        const val KEY_PRODUCT = "key"
    }
}