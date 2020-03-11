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
import com.example.comp_admin.groceryapp.models.CategoryResponse
import com.google.gson.GsonBuilder

class SubCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        init()
    }

    private fun init() {
        var catId = intent.getIntExtra("id", 0)
        Toast.makeText(this, catId.toString(), Toast.LENGTH_SHORT).show()

        getData(catId)
    }
    private fun getData( catId:Int) {
        val url = "https://apolis-grocery.herokuapp.com/api/subcategory/"+ catId
        var requestQueue = Volley.newRequestQueue(this)

        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener {/*
                var gson = GsonBuilder().create()
                var categoryResponse = gson.fromJson(it.toString(), CategoryResponse::class.java)
                mList = categoryResponse.data
                Toast.makeText(this, mList.size.toString(), Toast.LENGTH_SHORT).show()
                mCategoryAdapter.setData(mList)
                Log.d("data", it.toString())*/
            },
            Response.ErrorListener {
                Log.e("data", it.message)
            })

        requestQueue.add(stringRequest)
    }
}


