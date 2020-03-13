package com.example.comp_admin.groceryapp.models

data class ProductResponse(
    var error: Boolean,
    var count: Int,
    var data: ArrayList<Product>
)