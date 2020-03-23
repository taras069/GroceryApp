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
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        button_submit_login.setOnClickListener {
            var email = et_email_login.text.toString()
            var password = et_password_login.text.toString()

            var auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, object: OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if(task.isSuccessful){
                            Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
                        }else{
                            Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
                        }

                    }

                })
        }
        tv_forgot_password.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
        tv_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        button_skip_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
