package com.example.teoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnApe = findViewById<Button>(R.id.btnApe)
        btnApe.setOnClickListener {
            val intent = Intent(this, Appetizers::class.java)
            startActivity(intent)
        }

        val btnBackToMain = findViewById<Button>(R.id.btnBackToMenu)
        btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}