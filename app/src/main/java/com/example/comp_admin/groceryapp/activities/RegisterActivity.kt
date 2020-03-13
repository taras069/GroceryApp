package com.example.comp_admin.groceryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comp_admin.groceryapp.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        button_submit.setOnClickListener {
            var name = et_name.text.toString()
            var email = et_email.text.toString()
            var password = et_password.text.toString()

            var sharedPreferences = getSharedPreferences("my key", Context.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.commit()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
