package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.helpers.DBHelper
import com.example.comp_admin.groceryapp.models.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.app_bar.*


class ProductDetailActivity : AppCompatActivity() {

    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        init()
    }


    private fun init() {

        setupToolbar()

        product = intent.getSerializableExtra(Product.KEY_PRODUCT) as Product
        loadDetails(product)
        button_add_to_cart.setOnClickListener {

            var dbHelper = DBHelper(this)
            // product.quantity=1
            dbHelper.addToCart(product)

            // send product via intent
            var intent = Intent(this, CartActivity::class.java)
            intent.putExtra(Product.KEY_PRODUCT, product)
            startActivity(intent)

        }


    }


    private fun loadDetails(product: Product) {
        product_name.text = product.productName
        product_price.text = "$" + product.price
        product_mrp.text = "$" + product.mrp
        product_mrp.paintFlags = product_mrp.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG


        Picasso.get()
            .load("http://rjtmobile.com/grocery/images/" + product.productImage)
            .into(image_details)
    }

    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "ProductDetail Activity"
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

            }
            android.R.id.home ->{
                finish()
            }
        }
        return true
    }
}
