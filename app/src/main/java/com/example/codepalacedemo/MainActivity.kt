package com.example.codepalacedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.codepalacedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvTextView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBooleanText.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText() {
        binding.btnButton.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}