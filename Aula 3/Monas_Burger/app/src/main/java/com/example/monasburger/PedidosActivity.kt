package com.example.monasburger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.monasburger.databinding.ActivityPedidosBinding

class PedidosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pedido = intent.getStringExtra("pedido")

        binding.textoPedido.text = "${pedido}"

        binding.botaoVoltar.setOnClickListener {
            finish()
        }
    }
}