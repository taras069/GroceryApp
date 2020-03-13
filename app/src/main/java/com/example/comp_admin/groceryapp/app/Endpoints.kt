package com.example.comp_admin.groceryapp.app

class Endpoints {
    companion object {
        const val URL_CATEGORY = "category"
        const val URL_SUB_CATEGORY = "subcategory/"
        const val URL_PRODUCT = "products"

        fun getCategory(): String {
            return Config.Base_URL + URL_CATEGORY
        }
        fun getSubcategory(): String {
            return Config.Base_URL + URL_SUB_CATEGORY
        }
        fun getProduct(): String {
            return Config.Base_URL + URL_PRODUCT
        }
    }
}