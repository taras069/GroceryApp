package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comp_admin.groceryapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar.*

class HomeActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        init()
        setupToolbar()
    }

    private fun init() {

        if (auth.currentUser == null) {
            tv_greetning.text = R.string.welcome_to_our_app.toString()
        }else tv_greetning.text = "Welcome Taras"

        button_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        button_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        button_forgot_password.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java
            ))
        }
        button_skip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setupToolbar() {
        var toolbar = my_toolbar
        toolbar.title = "Home Activity"
        setSupportActionBar(toolbar)

    }
}
