package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.comp_admin.groceryapp.R
import kotlinx.android.synthetic.main.app_bar.*

class AddAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)

        setupToolbar()
    }

    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "Add Address"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
