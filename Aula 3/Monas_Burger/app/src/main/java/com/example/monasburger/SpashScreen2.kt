package com.example.monasburger

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SpashScreen2 : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 5000 // 3 segundo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash_screen2)

        val pedido = intent.getStringExtra("pedido")

        // Use a Handler to delay the transition to the next activity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, PedidosActivity::class.java)
            intent.putExtra("pedido", pedido)
            startActivity(intent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}