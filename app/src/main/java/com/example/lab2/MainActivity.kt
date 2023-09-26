package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setButtonsListeners()
    }

    private fun setButtonsListeners() {
        binding.bFirst.setOnClickListener {
            startActivity(FirstActivity.newIntent(this))
        }
        binding.bSecond.setOnClickListener {
            startActivity(SecondActivity.newIntent(this))
        }
        binding.bThird.setOnClickListener {
            startActivity(ThirdActivity.newIntent(this))
        }
        binding.bFourth.setOnClickListener {
            startActivity(FourthActivity.newIntent(this))
        }
        binding.bFives.setOnClickListener {
            startActivity(FivesActivity.newIntent(this))
        }
        binding.bSixth.setOnClickListener {
            startActivity(SixthActivity.newIntent(this))
        }
    }
}