package com.example.remover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.remover.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val valorRecebido = intent.getStringExtra("USERNAME")
        binding.textoBoasvindas.setText("Olá, Seja Bem-vindo ${valorRecebido}")

        binding.botaoVoltar.setOnClickListener {
            finish()
        }

    }
}