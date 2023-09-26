package com.example.lab2

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab2.databinding.ActivityFivesBinding

class FivesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFivesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.root.setOnClickListener {
            playAnimation()
        }
    }

    private fun playAnimation() {
        val parentCenterY = binding.root.y + binding.root.height / 2
        val scalesTimesUp = 5f
        val animTranslation = createObjectAnimation(binding.tvSquare, "translationY", parentCenterY)
        val animScaleX = createObjectAnimation(binding.tvSquare, "scaleX", scalesTimesUp)
        val animScaleY = createObjectAnimation(binding.tvSquare, "scaleY", scalesTimesUp)
        AnimatorSet().apply {
            playTogether(animTranslation, animScaleX, animScaleY)
            start()
        }
    }

    private fun createObjectAnimation(view: View, property: String, vararg values: Float): ObjectAnimator {
        val objAnimator = ObjectAnimator.ofFloat(view, property, *values)
        objAnimator.repeatMode = ObjectAnimator.REVERSE
        objAnimator.repeatCount = 1
        objAnimator.duration = 2000
        return objAnimator
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FivesActivity::class.java)
    }
}