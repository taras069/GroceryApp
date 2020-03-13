package com.example.comp_admin.groceryapp.models

import java.io.Serializable

data class Category(
    var catImage: String,
    var catId: Int,
    var catName: String
) : Serializable {
    companion object {
        const val KEY_CATEGORY = "category"
    }
}