package com.udemy.a7minutesworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udemy.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var _binding: ActivityExerciseBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarExercise)

        if (supportActionBar != null) supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarExercise.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}