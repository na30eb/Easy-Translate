package com.example.easytranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static  int splashScreen_timeout=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HomeScreen = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(HomeScreen);
                finish();
            }
        },splashScreen_timeout);
    }
}