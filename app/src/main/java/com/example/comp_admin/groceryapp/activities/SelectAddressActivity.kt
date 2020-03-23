package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comp_admin.groceryapp.R
import kotlinx.android.synthetic.main.activity_select_address.*
import kotlinx.android.synthetic.main.app_bar.*

class SelectAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_address)

        init()
    }

    private fun init() {
        setupToolbar()
        button_add_address.setOnClickListener {
            startActivity(Intent(this, AddAddressActivity::class.java))
        }


    }
    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "Select Address"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



}
