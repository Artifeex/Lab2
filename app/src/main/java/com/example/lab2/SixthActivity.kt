package com.example.lab2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.lab2.databinding.ActivitySixthBinding

class SixthActivity : AppCompatActivity(), AdditionDialogFragment.DialogListener {

    private val binding by lazy {
        ActivitySixthBinding.inflate(layoutInflater)
    }

    override fun onDialogPositiveClick(firstValue: Int, secondValue: Int) {
        val sum = firstValue + secondValue
        binding.textView.text = getString(R.string.addition_result, sum)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView.text = getString(R.string.addition_result, 0)
        binding.root.setOnClickListener {
            val dialog = AdditionDialogFragment()
            dialog.show(supportFragmentManager, null)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, SixthActivity::class.java)
    }
}