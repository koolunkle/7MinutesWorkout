package com.udemy.a7minutesworkout

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.udemy.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var _binding: ActivityExerciseBinding? = null

    private val binding get() = _binding!!

    private var restTimer: CountDownTimer? = null

    private var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null

    private var exerciseProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarExercise)

        if (supportActionBar != null) supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarExercise.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
    }

    override fun onDestroy() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        _binding = null
        super.onDestroy()
    }

    private fun setupRestView() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    private fun setupExerciseView() {
        binding.flProgressBar.visibility = View.INVISIBLE
        binding.tvTitle.text = resources.getString(R.string.exercise_name)
        binding.flExerciseView.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        setExerciseProgressBar()
    }

    private fun setRestProgressBar() {
        binding.progressBar.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 10 - restProgress
                binding.tvTimer.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        binding.progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress = 30 - exerciseProgress
                binding.tvTimerExercise.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    applicationContext,
                    "30 Seconds are over, lets go to the rest view",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.start()
    }

}