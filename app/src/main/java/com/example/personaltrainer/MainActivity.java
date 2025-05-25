package com.example.personaltrainer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    Button Btnstrt;
    VideoView vid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btnstrt = findViewById(R.id.Btnstrt);
        vid = findViewById(R.id.vid);

        String path = "android.resource://" +  getPackageName() + "/" + R.raw.bgggrnd;
        Uri uri = Uri.parse(path);

        vid.setVideoURI(uri);
        vid.start();

        vid.setOnPreparedListener(mp ->{
            mp.setLooping(true);
        });



        Btnstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext = new Intent(MainActivity.this,Login_Page.class);
                startActivity(inext);


            }
        });


    }
    @Override
    protected void onPostResume() {
        vid.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        vid.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        vid.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        vid.stopPlayback();
        super.onDestroy();
    }
}