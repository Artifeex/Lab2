package com.example.lab2

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab2.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFourthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvSquare.setOnClickListener {
            playAnimation()
        }
    }

    private fun playAnimation() {
        val animRotation = createObjectAnimation(binding.tvSquare, "rotation", 0f, 45f)
        val animScale = createObjectAnimation(binding.tvSquare, "scaleX", 0.5f)
        AnimatorSet().apply {
            playTogether(animRotation, animScale)
            start()
        }
    }

    private fun createObjectAnimation(view: View, property: String, vararg values: Float): ObjectAnimator {
        val objAnimator = ObjectAnimator.ofFloat(view, property, *values)
        objAnimator.repeatMode = ObjectAnimator.REVERSE
        objAnimator.repeatCount = 1
        objAnimator.duration = 1750
        return objAnimator
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FourthActivity::class.java)
    }


}