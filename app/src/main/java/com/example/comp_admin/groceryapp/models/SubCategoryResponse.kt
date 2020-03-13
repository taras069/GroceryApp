package com.example.comp_admin.groceryapp.models

data class SubCategoryResponse(
    var error: Boolean,
    var count: Int,
    var data: ArrayList<SubCategory>
)