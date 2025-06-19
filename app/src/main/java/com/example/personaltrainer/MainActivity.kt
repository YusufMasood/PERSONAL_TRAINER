package com.example.personaltrainer

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var Btnstrt: Button
    private lateinit var vid: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btnstrt = findViewById(R.id.Btnstrt)
        vid = findViewById(R.id.vid)

        val path = "android.resource://" + packageName + "/" + R.raw.bgggrnd
        val uri = Uri.parse(path)

        vid.setVideoURI(uri)
        vid.start()

        vid.setOnPreparedListener(OnPreparedListener { mp: MediaPlayer ->
            mp.isLooping = true
        })



        Btnstrt.setOnClickListener(View.OnClickListener {
            val inext = Intent(
                this@MainActivity,
                Login_Page::class.java
            )
            startActivity(inext)
        })
    }

    override fun onPostResume() {
        vid!!.resume()
        super.onPostResume()
    }

    override fun onRestart() {
        vid!!.start()
        super.onRestart()
    }

    override fun onPause() {
        vid!!.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        vid!!.stopPlayback()
        super.onDestroy()
    }
}