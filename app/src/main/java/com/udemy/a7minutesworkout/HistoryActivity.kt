package com.udemy.a7minutesworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udemy.a7minutesworkout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private var _binding: ActivityHistoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarHistoryActivity)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }

        binding.toolbarHistoryActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}