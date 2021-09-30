package com.example.teoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.teoproject.data.model.Dishes
import com.example.teoproject.data.model.DishesAdapter
import com.example.teoproject.databinding.ActivityAppetizersBinding
import com.example.teoproject.databinding.ActivityMainBinding

class Appetizers : AppCompatActivity() {

    private lateinit var binding: ActivityAppetizersBinding
    public var dishesArrayList = arrayListOf<Dishes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppetizersBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_appetizers)
        setContentView(binding.root)

        val imageId = intArrayOf(R.drawable.sara,R.drawable.sara)
        val name = arrayOf("Cocktail Gamberi","Involtini")


        for (i in name.indices){
            val dish = Dishes(name[i] ,imageId[i])
            dishesArrayList.add(dish)
        }

        binding.ListItem.isClickable = true
        binding.ListItem.adapter = DishesAdapter(this, dishesArrayList)
        binding.ListItem.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val image = imageId[position]
            val i = Intent(this, Dishes::class.java)
            i.putExtra("name",name)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }
        //val myDataset = Datasource().loadDishes()
        //val recyclerView = findViewById<RecyclerView>(R.id.MenuView)

        //recyclerView.adapter = DishesAdapter(this, myDataset)
        //recyclerView.setHasFixedSize(true)

        val btnBack= findViewById<Button>(R.id.btnGoBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
          }

    }


    }
