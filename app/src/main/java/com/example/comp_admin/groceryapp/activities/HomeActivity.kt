package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comp_admin.groceryapp.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {
        button_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        button_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}
