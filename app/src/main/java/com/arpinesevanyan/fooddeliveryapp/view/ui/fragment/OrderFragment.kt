package com.arpinesevanyan.fooddeliveryapp.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.fooddeliveryapp.view.ui.OnPizzaItemClickListener
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem
import com.arpinesevanyan.fooddeliveryapp.view.adapter.OrderAdapter

class OrderFragment : Fragment(), OnPizzaItemClickListener {

    private val selectedPizzas = mutableListOf<PizzaItem>()
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_order, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.orderRecyclerView)
        orderAdapter = OrderAdapter(selectedPizzas, this)
        recyclerView.adapter = orderAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val toolbar = rootView.findViewById<Toolbar>(R.id.toolbarOrder)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        return rootView
    }

    override fun onPizzaItemClicked(pizzaItem: PizzaItem) {
        selectedPizzas.add(pizzaItem)
        orderAdapter.notifyDataSetChanged()
    }
}




