package com.example.personaltrainer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Food_log : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_log)

        // This is only for padding window insets like status bar, nav bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calProgress)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ THIS is where toggle logic should go
        val progressContainer = findViewById<LinearLayout>(R.id.progressContainer)
        val toggleButton = findViewById<ImageButton>(R.id.toggleButton)
        val scrollMeals = findViewById<ScrollView>(R.id.scrollMeals)
        val addBreakfast = findViewById<ImageButton>(R.id.addBreakfast)
        val addLunch = findViewById<ImageButton>(R.id.addLunch)
        val addSnacks = findViewById<ImageButton>(R.id.addSnacks)
        val addDinner = findViewById<ImageButton>(R.id.addDinner)

        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_up_progress)
        scrollMeals.startAnimation(slideIn)

        val inext = Intent(this, Food_log::class.java)

        toggleButton.setOnClickListener {

            if (progressContainer.visibility == View.GONE) {
                // Slide Down and Show
                val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down_progress)
                progressContainer.visibility = View.VISIBLE
                progressContainer.startAnimation(slideDown)
                // Optional: rotate the arrow
                toggleButton.rotation = 180f
            } else {
                // Slide Up and Hide
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up_progress)
                progressContainer.startAnimation(slideUp)

                slideUp.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {}
                    override fun onAnimationRepeat(animation: Animation?) {}
                    override fun onAnimationEnd(animation: Animation?) {
                        progressContainer.visibility = View.GONE
                    }
                })

                // Optional: reset arrow rotation
                toggleButton.rotation = 0f
            }
        }

        addBreakfast.setOnClickListener {
            startActivity(inext)
        }
        addLunch.setOnClickListener {
            startActivity(inext)
        }
        addSnacks.setOnClickListener {
            startActivity(inext)
        }
        addDinner.setOnClickListener {
            startActivity(inext)
        }
    }
}
