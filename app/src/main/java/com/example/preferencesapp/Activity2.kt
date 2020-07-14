package com.example.preferencesapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sp = getSharedPreferences("MyPref", Activity.MODE_PRIVATE)
        setContentView(R.layout.activity_2)
        window.decorView.setBackgroundColor(sp.getInt("background_color", -1))
    }
}
