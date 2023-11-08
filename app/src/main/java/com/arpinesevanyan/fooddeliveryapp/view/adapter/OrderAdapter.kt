package com.arpinesevanyan.fooddeliveryapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.fooddeliveryapp.view.ui.OnPizzaItemClickListener
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem

class OrderAdapter(
    private val data: List<PizzaItem>,
    private val pizzaItemClickListener: OnPizzaItemClickListener
) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaNameTextView: TextView = itemView.findViewById(R.id.pizzaNameTextView)
        val pizzaPriceButton: Button = itemView.findViewById(R.id.pizzaPriceButton)

        init {
            pizzaPriceButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = data[position]
                    pizzaItemClickListener.onPizzaItemClicked(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.pizza_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.pizzaNameTextView.text = item.namePizza
        holder.pizzaPriceButton.text = String.format("%.2f руб.", item.price)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

