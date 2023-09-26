package com.example.lab2

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.lab2.databinding.AdditionDialogViewBinding
import java.lang.ClassCastException

class AdditionDialogFragment: DialogFragment() {

    private lateinit var listener: DialogListener

    private val binding by lazy {
        AdditionDialogViewBinding.inflate(layoutInflater)
    }

    interface DialogListener {
        fun onDialogPositiveClick(firstValue: Int, secondValue: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            initViews()
            builder.setView(binding.root)
            builder.setTitle("Add two numbers?")
            builder.setPositiveButton(
                "Add",
                DialogInterface.OnClickListener { _, _ ->
                    val firstNumber = binding.etFirstNumber.text.toString()
                    val secondNumber = binding.etSecondNumber.text.toString()
                    if(firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                        listener.onDialogPositiveClick(
                            firstNumber.toInt(),
                            secondNumber.toInt())
                    }
                })
            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { _, _ ->  }
            )
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null!")
    }

    private fun initViews() {
        binding.addButton.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString()
            val secondNumber = binding.etSecondNumber.text.toString()
            if(firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                listener.onDialogPositiveClick(
                    firstNumber.toInt(),
                    secondNumber.toInt())
                dialog?.cancel()
            }
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener = activity as DialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException("${activity.toString()} must implement DialogListener")
        }
    }
}