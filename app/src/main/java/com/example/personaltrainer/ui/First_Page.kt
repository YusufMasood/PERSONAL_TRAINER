package com.example.personaltrainer.ui

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.personaltrainer.Food_log
import com.example.personaltrainer.R
import com.example.personaltrainer.ui.Tools
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.personaltrainer.utils.AppPermissions





class First_Page : AppCompatActivity() {
    private lateinit var Btnprofile: ImageButton
    private lateinit var drawer: DrawerLayout

    private lateinit var btnFoodLog: ConstraintLayout

    private val cameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                openCamera()
            } else {
                Toast.makeText(this, "Camera permission required!!", Toast.LENGTH_SHORT).show()
            }
        }





    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()

        setContentView(R.layout.activity_first_page)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.drawer)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNaviagtionView)
        val btnFoodLog = findViewById<ConstraintLayout>(R.id.btnFoodLog)
        bottomNav.setOnItemSelectedListener { item ->

             when (item.itemId) {
                R.id.home -> {
                    true
                }

                R.id.notification -> {
                    true
                }

                R.id.scan -> {
                    if (AppPermissions.isCameraPermissionGranted(this)) {
                        openCamera()
                    } else {
                        AppPermissions.requestCameraPermission(cameraPermissionLauncher)
                    }
                    true
                }

                R.id.tools -> {
                    val intent = Intent(this, Tools::class.java)
                    startActivity(intent)
                    true
                }

                R.id.setting -> {
                    true
                }

                else -> false
            }
        }


        btnFoodLog.setOnClickListener(View.OnClickListener {

            val iNext = Intent(this, Food_log::class.java)
            startActivity(iNext)

        })

        Btnprofile = findViewById(R.id.Btnprofile)
        drawer = findViewById(R.id.drawer)




        Btnprofile.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.START)

        })



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val items = listOf(
            "Arnold Schwarzenegger",
            "Roni Colmenares",
            "Jay Cutler",
            "Chris Bumstead",
            "Kaigreen",
            "Hadi Choopan"
        )



        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = TextAdapter(items)
        PagerSnapHelper().attachToRecyclerView(recyclerView)

        val startPosition = Int.MAX_VALUE / 2
        recyclerView.scrollToPosition(startPosition - startPosition % items.size)



    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }

}


// Class for my recycler (horizontal scroll)

class TextAdapter(private val items: List<String>) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val arnold: TextView = itemView.findViewById(R.id.arnold)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_scroll, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val actualPosition = position % items.size
        holder.arnold.text = items[actualPosition]

    }

    override fun getItemCount(): Int = Int.MAX_VALUE
}













