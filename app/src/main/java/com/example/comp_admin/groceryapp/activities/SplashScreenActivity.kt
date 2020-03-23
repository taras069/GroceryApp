package com.example.comp_admin.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.example.comp_admin.groceryapp.R


class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_TIME_OUT : Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        //This method is used so that your splash activity
//can cover the entire screen.
        setContentView(R.layout.activity_splash_screen)
        //this will bind your MainActivity.class file with activity_main.
        Handler().postDelayed(Runnable {
            val i = Intent(
                this,
                LoginActivity::class.java
            )
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
            finish()
            //the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT)
    }
}
