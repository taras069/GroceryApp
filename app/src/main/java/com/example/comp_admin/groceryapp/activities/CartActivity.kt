package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.adapters.CartAdapter
import com.example.comp_admin.groceryapp.helpers.DBHelper
import com.example.comp_admin.groceryapp.models.Product
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.app_bar.*

class CartActivity : AppCompatActivity(), CartAdapter.myCustomInterface {
    lateinit var mList: ArrayList<Product>
    lateinit var mAdapter: CartAdapter
    lateinit var myDb: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        init()
    }

    private fun init() {
        setupToolbar()
        myDb = DBHelper(this)
        mList = myDb.readProduct()

        mAdapter = CartAdapter(this, mList)
        mAdapter.setMyCustomInterface(this)
        my_rv_cart.adapter = mAdapter
        my_rv_cart.layoutManager = LinearLayoutManager(this)

        button_cart_checkout.setOnClickListener {
            startActivity(Intent(this,SelectAddressActivity::class.java))
        }
    }

    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "Cart Activity"
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
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    override fun onItemClicked(position: Int, view: View) {
        mAdapter.notifyDataSetChanged()
        var product = mList.get(position)
        when (view.id) {
            R.id.icon_delete -> {

                myDb.deleteProduct(product)
                mList.removeAt(position)
                if (mList.isEmpty()) {
                    Toast.makeText(this, "Cart Is Empty", Toast.LENGTH_SHORT).show()
                    tv_empty_cart.visibility = View.VISIBLE
                    button_cart_checkout.visibility = View.GONE
                }
            }
            R.id.button_plus -> {
                product.quantity++
                myDb.updateQuantity(product)
            }
            R.id.button_minus -> {
                product.quantity--
                myDb.updateQuantity(product)
            }

        }
    }
}
