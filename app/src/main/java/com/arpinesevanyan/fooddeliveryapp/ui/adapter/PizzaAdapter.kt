package com.arpinesevanyan.fooddeliveryapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.data.PizzaItem
import com.bumptech.glide.Glide

class PizzaAdapter(private val data: List<PizzaItem>) :
    RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaImageView: AppCompatImageView = itemView.findViewById(R.id.pizzaImageView)
        val pizzaNameTextView: AppCompatTextView = itemView.findViewById(R.id.pizzaNameTextView)
        val pizzaPriceTextView: AppCompatTextView = itemView.findViewById(R.id.pizzaPriceTextView)
        val pizzaDescriptionTextView: AppCompatTextView =
            itemView.findViewById(R.id.pizzaDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.pizza_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        Glide.with(holder.pizzaImageView)
            .load(item.imageUrl)
            .into(holder.pizzaImageView)

        holder.pizzaNameTextView.text = item.namePizza
        holder.pizzaPriceTextView.text = item.price.toString()
        holder.pizzaDescriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
