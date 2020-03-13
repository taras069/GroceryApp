package com.example.comp_admin.groceryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.adapters.CategoryAdapter
import com.example.comp_admin.groceryapp.models.Category
import com.example.comp_admin.groceryapp.models.CategoryResponse
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var mList = ArrayList<Category>()
    lateinit var mCategoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        getData()

        mCategoryAdapter =  CategoryAdapter(this,mList)
        my_rv.adapter = mCategoryAdapter
        my_rv.layoutManager = GridLayoutManager(this,2)
    }

    private fun getData() {
        val url = "https://apolis-grocery.herokuapp.com/api/category"
        var requestQueue = Volley.newRequestQueue(this)

        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener {
                var gson = GsonBuilder().create()
                var categoryResponse = gson.fromJson(it.toString(), CategoryResponse::class.java)
                mList = categoryResponse.data
                Toast.makeText(this, mList.size.toString(), Toast.LENGTH_SHORT).show()
                mCategoryAdapter.setData(mList)
                Log.d("data", it.toString())
            },
            Response.ErrorListener {
                Log.e("data", it.message)
            })

        requestQueue.add(stringRequest)
    }
}
