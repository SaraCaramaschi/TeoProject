package com.example.teoproject.data.model

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.teoproject.R
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.item_todo.view.*
import java.nio.file.attribute.UserDefinedFileAttributeView


class DishesAdapter(
    private val context: Activity,
    private val arrayList: ArrayList<Dishes>):
    ArrayAdapter<Dishes>(context, R.layout.item_dishes, arrayList){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup):View {

            val inflater: LayoutInflater = LayoutInflater.from(context)
            val view: View = inflater.inflate(R.layout.item_dishes, null)

            val imageView: ImageView = view.findViewById(R.id.Pic)  // ids from xml design file
            val name: TextView = view.findViewById(R.id.Name)
            //val ingr: TextView = view.findViewById(R.id.Ingredienti)
            //val howmany: TextView = view.findViewById(R.id.howmany)
            //val toBuy: Boolean = view.findViewById(R.id.t)

            imageView.setImageResource(arrayList[position].imageId)
            name.text = arrayList[position].name.toString()
            //ingr.text = arrayList[position].ingredients
            //howmany.text = arrayList[position].howmany

            return view
        }
    }
















