package com.example.monasburger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.monasburger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoSubtotal.setOnClickListener {
            val qnt_hamburger = binding.qtdHamburger.text.toString().toInt()
            val qnt_cheese = binding.qtdCheeseburger.text.toString().toInt()
            val qnt_batatas = binding.qtdBatatas.text.toString().toInt()
            val qnt_refrigerantes = binding.qtdRefrigerantes.text.toString().toInt()
            val qnt_milkshake = binding.qtdMilkshake.text.toString().toInt()

            val subtotal = qnt_hamburger * 6.5 + qnt_cheese * 7.5 + qnt_batatas * 3.5 + qnt_refrigerantes * 0.70 + qnt_milkshake * 0.80

            binding.mostrarSubtotal.text = "Subtotal: ${subtotal}€"
        }

        binding.botaoSubmeter.setOnClickListener {
            var pedido = ""
            val qnt_hamburger = binding.qtdHamburger.text.toString().toInt()
            val qnt_cheese = binding.qtdCheeseburger.text.toString().toInt()
            val qnt_batatas = binding.qtdBatatas.text.toString().toInt()
            val qnt_refrigerantes = binding.qtdRefrigerantes.text.toString().toInt()
            val qnt_milkshake = binding.qtdMilkshake.text.toString().toInt()

            if (!qnt_hamburger.equals(0)) {
                pedido += "Hamburger: ${qnt_hamburger}\n"
            }

            if(!qnt_cheese.equals(0)) {
                pedido += "CheeseBurger: ${qnt_cheese}\n"
            }

            if(!qnt_batatas.equals(0)) {
                pedido += "Batatas Fritas: ${qnt_batatas}\n"
            }

            if(!qnt_refrigerantes.equals(0)) {
                pedido += "Refrigerantes: ${qnt_refrigerantes}\n"
            }
            if(!qnt_milkshake.equals(0)) {
                pedido += "Milkshake: ${qnt_milkshake}\n"
            }

            val intent = Intent(this, SpashScreen2::class.java)
            intent.putExtra("pedido", pedido)
            startActivity(intent)

            binding.qtdHamburger.setText("0")
            binding.qtdCheeseburger.setText("0")
            binding.qtdBatatas.setText("0")
            binding.qtdRefrigerantes.setText("0")
            binding.qtdMilkshake.setText("0")
            binding.mostrarSubtotal.text = ""
        }
    }
}