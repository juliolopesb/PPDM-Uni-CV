package com.example.aula3

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.aula3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoSubmeter.setOnClickListener {
            val texto = binding.editarTexto.text.toString()
            if (texto.isNotEmpty()) {
                binding.mostrarTexto.text = texto
            } else {
                binding.mostrarTexto.text = ""
                Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
            }
        }

        binding.negrito.setOnCheckedChangeListener { buttonView, isChecked ->
            val texto = binding.editarTexto.text.toString()
            if (texto.isNotEmpty()) {
                if (isChecked) {
                    if (binding.italico.isChecked) {
                        binding.italico.toggle()
                    } else if(binding.maiusculas.isChecked) binding.maiusculas.toggle()
                    binding.mostrarTexto.setTypeface(null, Typeface.BOLD)
                } else binding.mostrarTexto.setTypeface(null, Typeface.NORMAL)
            } else {
                buttonView.toggle()
                Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
            }
        }

        binding.italico.setOnCheckedChangeListener { buttonView, isChecked ->
            val texto = binding.editarTexto.text.toString()
            if (texto.isNotEmpty()) {
                if (isChecked) {
                    if (binding.negrito.isChecked) {
                        binding.negrito.toggle()
                    } else if(binding.maiusculas.isChecked) binding.maiusculas.toggle()
                    binding.mostrarTexto.setTypeface(null, Typeface.ITALIC)
                } else binding.mostrarTexto.setTypeface(null, Typeface.NORMAL)
            } else {
                buttonView.toggle()
                Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
            }
        }

        binding.maiusculas.setOnCheckedChangeListener { buttonView, isChecked ->
            val texto = binding.editarTexto.text.toString()
            if (texto.isNotEmpty()) {
                if (isChecked) {
                    if (binding.italico.isChecked) {
                        binding.italico.toggle()
                    } else if(binding.negrito.isChecked) binding.negrito.toggle()
                    binding.mostrarTexto.text = texto.uppercase()
                } else binding.mostrarTexto.text = texto
            } else {
                buttonView.toggle()
                Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
            }
        }

        binding.grupoCores.setOnCheckedChangeListener { _, checkedId ->
            val texto = binding.editarTexto.text.toString()
            if (texto.isNotEmpty()) {
                when (checkedId) {
                    R.id.cor_azul -> {
                        binding.mostrarTexto.setTextColor(
                            ContextCompat.getColor(
                                this,
                                R.color.blue
                            )
                        )
                    }

                    R.id.cor_verde -> binding.mostrarTexto.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.green
                        )
                    )

                    R.id.cor_vermelha -> binding.mostrarTexto.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.red
                        )
                    )
                }
            } else {
                binding.corAzul.isChecked = false
                binding.corVerde.isChecked = false
                binding.corVermelha.isChecked = false
                Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
            }
        }

        binding.tamanhoLetra.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // This method is called when the progress changes
                val texto = binding.editarTexto.text.toString()
                if (texto.isNotEmpty()) {
                    binding.textoTamanho.text = "${progress}sp"
                } else {
                    binding.textoTamanho.text = "0sp"
                    binding.mostrarTexto.text = ""
                    Toast.makeText(applicationContext, "É necessário introduzir o texto", Toast.LENGTH_LONG).show()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // This method is called when the user starts touching the SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // This method is called when the user stops touching the SeekBar
                val texto = binding.editarTexto.text.toString()
                if (texto.isNotEmpty()) {
                    binding.mostrarTexto.textSize = seekBar.progress.toFloat()
                }
            }
        })

    }
}