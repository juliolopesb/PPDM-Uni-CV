package com.example.ola_utilizador

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ola_utilizador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoOK.setOnClickListener {
            val nome = binding.editarTexto.text.toString().trim()

            if(nome.isNotEmpty()) {
                Toast.makeText(applicationContext, "Olá ${nome}. Seja Bem vindo!", Toast.LENGTH_LONG).show()
                binding.editarTexto.setText("")
            } else Toast.makeText(applicationContext, "É necessário introduzir o nome", Toast.LENGTH_LONG).show()
        }
    }
}