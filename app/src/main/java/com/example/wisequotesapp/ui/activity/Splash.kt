package com.example.wisequotesapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.wisequotesapp.databinding.ActivitySplashActBinding

class Splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashActBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(
                    this,
                    AuthActivity::class.java
                )
            )
        }, 2000)


    }
}