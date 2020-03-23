package com.example.comp_admin.groceryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.helpers.SessionManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        button_submit.setOnClickListener {

            var email = et_email.text.toString()
            var password = et_password.text.toString()

            var auth = FirebaseAuth.getInstance()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext,
                                "user registered successfully", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        } else {
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                })

        }
    }
}
