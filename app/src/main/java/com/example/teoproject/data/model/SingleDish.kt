package com.example.teoproject.data.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teoproject.R
import com.example.teoproject.databinding.ActivitySingleDishBinding

class SingleDish : AppCompatActivity() {
    private lateinit var binding: ActivitySingleDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleDishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val imageId = intent.getIntExtra("imageId",R.drawable.sara)

        binding.nameProfile.text = name
        binding.imageView.setImageResource(imageId)

    }
}
