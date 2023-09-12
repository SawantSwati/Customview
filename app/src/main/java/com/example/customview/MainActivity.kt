package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.databinding.ActivityMainBinding
import kotlin.math.absoluteValue
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.graphViewMarks.values =
            arrayOf(90, 60, 70, 80, 50)

        binding.btnRefresh.setOnClickListener {
            var size = Random.nextInt().absoluteValue % 11
            if(size == 0) {
                size = 5
            }

            val arr = Array<Int>(size, {index -> 0})

            for(index  in 0..size-1) {
                arr[index] = Random.nextInt().absoluteValue % 101
            }

            binding.graphViewMarks.values = arr

        }
    }
}