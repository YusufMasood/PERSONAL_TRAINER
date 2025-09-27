package com.example.personaltrainer


import com.google.gson.reflect.TypeToken
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.personaltrainer.utils.loadJSONFromAsset
import com.example.personaltrainer.data.FoodDatabase
import com.example.personaltrainer.data.FoodItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {
    private lateinit var Btnstrt: Button
    private lateinit var vid: VideoView

    lateinit var database : FoodDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodList = listOf(
            FoodItem(name = "Banana", quantity = 2f, calories = 200, protein = 2f, carbs = 45f, fat = 0.5f, category = "Fruit"),
            FoodItem(name = "Oats", quantity = 1f, calories = 350, protein = 12f, carbs = 60f, fat = 6f, category = "Grain"))

        database = Room.databaseBuilder(applicationContext, FoodDatabase::class.java,"FoodDb").build()

        GlobalScope.launch{
          // database.foodDao().insertAll( foodList)
            //database.foodDao().clearAll()
        }



        Btnstrt = findViewById(R.id.Btnstrt)
        vid = findViewById(R.id.vid)

        val path = "android.resource://" + packageName + "/" + R.raw.bgggrnd
        val uri = Uri.parse(path)

        vid.setVideoURI(uri)

        vid.setOnPreparedListener { mp ->
            mp.isLooping = true

            val videoWidth = mp.videoWidth
            val videoHeight = mp.videoHeight
            val videoProportion = videoWidth.toFloat() / videoHeight.toFloat()

            // Example: You want video width to match parent (full screen width)
            val screenWidth = resources.displayMetrics.widthPixels
            val newHeight = (screenWidth / videoProportion).toInt()

            val layoutParams = vid.layoutParams
            layoutParams.width = screenWidth
            layoutParams.height = newHeight
            vid.layoutParams = layoutParams

            vid.start()

        }

        Btnstrt.setOnClickListener {
            val intent = Intent(this@MainActivity, Login_Page::class.java)
            startActivity(intent)
        }
    }


        override fun onPostResume() {
        vid.resume()
        super.onPostResume()
    }

    override fun onRestart() {
        vid.start()
        super.onRestart()
    }

    override fun onPause() {
        vid.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        vid.stopPlayback()
        super.onDestroy()
    }
}


