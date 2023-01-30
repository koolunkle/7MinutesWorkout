package com.udemy.a7minutesworkout

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flStartButton: FrameLayout = findViewById(R.id.fl_start)
        flStartButton.setOnClickListener {
            Toast.makeText(this, "Here we will start the exercise", Toast.LENGTH_SHORT).show()
        }
    }
}