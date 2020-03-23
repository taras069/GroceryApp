package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.adapters.CategoryAdapter
import com.example.comp_admin.groceryapp.models.Category
import com.example.comp_admin.groceryapp.models.CategoryResponse
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var mList = ArrayList<Category>()
    lateinit var mCategoryAdapter: CategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageSlider = findViewById<ImageSlider>(R.id.image_slider) // init imageSlider

        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel(R.drawable.groceries_1))
        imageList.add(SlideModel(R.drawable.groceries_2))
        imageList.add(SlideModel(R.drawable.groceries_3))

        imageSlider.setImageList(imageList)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
            }
        })

        init()
    }

    private fun init() {
        setupToolbar()

        getData()

        mCategoryAdapter = CategoryAdapter(this, mList)
        my_rv.adapter = mCategoryAdapter
        my_rv.layoutManager = GridLayoutManager(this, 2)
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

                mCategoryAdapter.setData(mList)
                Log.d("data", it.toString())
            },
            Response.ErrorListener {
                Log.e("data", it?.message)
            })

        requestQueue.add(stringRequest)
    }

    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "Category"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_cart -> {
                Toast.makeText(this, "Cart Icon Clicked", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,CartActivity::class.java))

            }
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }
}
