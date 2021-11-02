package com.example.teoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnApetizzers = findViewById<Button>(R.id.btnApe) // funziona
        btnApetizzers.setOnClickListener {
            val intent = Intent(this, Appetizers::class.java)
            startActivity(intent)
        }

        // bottone LISTA PAZIENTI
        val btnPatients = findViewById<Button>(R.id.btnPatients)
        btnPatients.setOnClickListener {
            val intent = Intent(this, PatientsListActivity::class.java)
            startActivity(intent)
        }

        //val btnMainCourses = findViewById<Button>(R.id.btnMain) // funziona
        //btnMainCourses.setOnClickListener {
        //    val intent = Intent(this, MainCourses::class.java)
        //    startActivity(intent) }


    }
}