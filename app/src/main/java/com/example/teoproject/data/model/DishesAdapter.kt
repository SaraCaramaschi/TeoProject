package com.example.teoproject.data.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teoproject.R
import com.example.teoproject.Todo
import com.example.teoproject.TodoAdaptor
import kotlinx.android.synthetic.main.item_todo.view.*

class DishesAdapter(
    private val context: Context,
    private val dataset: List<Dishes>):

    RecyclerView.Adapter<DishesAdapter.DishesViewHolder>()  {

    class DishesViewHolder( private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dishes, parent, false)
        return DishesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}
