package com.example.personaltrainer

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.rem


class First_Page : AppCompatActivity() {
    private lateinit var Btnprofile: ImageButton
    private lateinit var drawer: DrawerLayout

    fun makeStatusBarTranslucent() {
        // Tell the system that we are handling the system bars (status/navigation)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Make status bar transparent
        window.statusBarColor = Color.TRANSPARENT

        // Optional: Change status bar icon color (dark or light)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = true  // false if you want white icons
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

        Btnprofile = findViewById(R.id.Btnprofile)
        drawer = findViewById(R.id.drawer)



        Btnprofile.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(GravityCompat.START)
            makeStatusBarTranslucent()
        })



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val items = listOf(
            "Arnold Schwarzenegger",
            "Roni Colmenares",
            "Jay Cutler",
            "Chris Bumstead",
            "Kaigreen"
        )



        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = TextAdapter(items)
        PagerSnapHelper().attachToRecyclerView(recyclerView)

        val startPosition = Int.MAX_VALUE / 2
        recyclerView.scrollToPosition(startPosition - startPosition % items.size)

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








