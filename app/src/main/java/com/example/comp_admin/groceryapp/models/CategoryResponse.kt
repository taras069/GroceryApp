package com.example.comp_admin.groceryapp.models

data class CategoryResponse(
    var error: Boolean,
    var count: Int,
    var data: ArrayList<Category>
)