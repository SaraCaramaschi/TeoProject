package com.example.teoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.teoproject.data.model.Datasource
import com.example.teoproject.data.model.DishesAdapter

class Appetizers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appetizers)

        val myDataset = Datasource().loadDishes()
        val recyclerView = findViewById<RecyclerView>(R.id.MenuView)

        recyclerView.adapter = DishesAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)

        val btnBack= findViewById<Button>(R.id.btnGoBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

    }
}