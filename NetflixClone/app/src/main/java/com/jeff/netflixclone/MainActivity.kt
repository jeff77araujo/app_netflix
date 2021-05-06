package com.jeff.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jeff.netflixclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            openLoginScreen()
        }, 2000)
    }

    private fun openLoginScreen() {
        startActivity(Intent(this, FormLogin::class.java))
        finish()
    }
}

