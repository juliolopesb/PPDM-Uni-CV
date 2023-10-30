package com.example.conversortemperatura

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoSubmeter.setOnClickListener {
            val valor = binding.temperatura.text.toString().toDouble()
            val converter = (9/5) * valor + 32
            binding.textView2.text = "${valor}ºC equivale a ${converter}ºF"

            Toast.makeText(applicationContext, "${valor}ºC equivale a ${converter}ºF", Toast.LENGTH_LONG).show()
        }
    }
}