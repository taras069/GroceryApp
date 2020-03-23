package com.example.comp_admin.groceryapp.activities

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.comp_admin.groceryapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*



class ResetPasswordActivity : AppCompatActivity() {

/*    private var inputEmail: EditText? = null
    private var btnReset: Button? = null, private
    var btnBack:Button? = null*/
    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        //init()



    }

   /* private fun init() {
        auth = FirebaseAuth.getInstance()
        button_send_email.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val email = inputEmail!!.text.toString().trim { it <= ' ' }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(
                        application,
                        "Enter your registered email id",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@ResetPasswordActivity,
                                "We have sent you instructions to reset your password!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@ResetPasswordActivity,
                                "Failed to send reset email!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
            }
        })
    }*/
}
