package com.example.vitrinovachallange.view

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.contract.MainActivityContract
import com.example.vitrinovachallange.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreenActivity : AppCompatActivity(){


    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var imageLogo: ImageView
    private lateinit var tvSplash: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)




        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        imageLogo = findViewById(R.id.imgLogo)
        tvSplash = findViewById(R.id.tvSplashScreen)

        imageLogo.startAnimation(topAnimation)
        tvSplash.startAnimation(bottomAnimation)

        Handler().postDelayed({
          val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}
