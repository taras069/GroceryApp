package com.example.comp_admin.groceryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.adapters.MyFragmentPagerAdapter
import com.example.comp_admin.groceryapp.app.Endpoints
import com.example.comp_admin.groceryapp.models.Category
import com.example.comp_admin.groceryapp.models.CategoryResponse
import com.example.comp_admin.groceryapp.models.SubCategory
import com.example.comp_admin.groceryapp.models.SubCategoryResponse
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_sub_category.*

lateinit var category: Category
lateinit var adapterFragment : MyFragmentPagerAdapter

class SubCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        init()
    }

    private fun init() {
        category = intent.getSerializableExtra(Category.KEY_CATEGORY) as Category
        Toast.makeText(this, category.catId.toString(), Toast.LENGTH_SHORT).show()

        getData(category.catId)
        adapterFragment = MyFragmentPagerAdapter(supportFragmentManager)
    }

    private fun getData(catId: Int) {
        val url = "https://apolis-grocery.herokuapp.com/api/subcategory/" + catId
        var requestQueue = Volley.newRequestQueue(this)

        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener {
                var gson = GsonBuilder().create()
                var subCategoryResponse =
                    gson.fromJson(it.toString(), SubCategoryResponse::class.java)
                Toast.makeText(this, subCategoryResponse.data.size.toString(), Toast.LENGTH_SHORT).show()
                Log.d("data", it.toString())
                var mSubList = subCategoryResponse.data
                for(sub in mSubList){
                    adapterFragment.addFragment(sub)
                }
                my_view_pager.adapter = adapterFragment
                my_tab_layout.setupWithViewPager(my_view_pager)
            },
            Response.ErrorListener {
                Log.e("data", it.message)
            })

        requestQueue.add(stringRequest)
    }
}


