package com.arpinesevanyan.fooddeliveryapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.fooddeliveryapp.view.ui.OnPizzaItemClickListener
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem
import com.bumptech.glide.Glide

class PizzaAdapter(
    private var data: List<PizzaItem>,
    private val pizzaSelectedListener: OnPizzaItemClickListener
) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaImageView: AppCompatImageView = itemView.findViewById(R.id.pizzaImageView)
        val pizzaNameTextView: AppCompatTextView = itemView.findViewById(R.id.pizzaNameTextView)
        val pizzaPriceButton: AppCompatButton = itemView.findViewById(R.id.pizzaPriceButton)
        val pizzaDescriptionTextView: AppCompatTextView =
            itemView.findViewById(R.id.pizzaDescriptionTextView)
    }

    fun updateData(newData: List<PizzaItem>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.pizza_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.pizzaPriceButton.setOnClickListener {
            pizzaSelectedListener.onPizzaItemClicked(item)
        }

        Glide.with(holder.pizzaImageView)
            .load(item.imageUrl)
            .into(holder.pizzaImageView)

        holder.pizzaNameTextView.text = item.namePizza
        holder.pizzaPriceButton.text = "от ${item.price} руб"
        holder.pizzaDescriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
