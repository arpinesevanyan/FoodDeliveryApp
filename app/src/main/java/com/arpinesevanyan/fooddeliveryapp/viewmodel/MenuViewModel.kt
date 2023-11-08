package com.arpinesevanyan.fooddeliveryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem

class MenuViewModel : ViewModel() {
    private val _selectedCity = MutableLiveData<String>()
    val selectedCity: LiveData<String> get() = _selectedCity

    private val _pizzas = MutableLiveData<List<PizzaItem>>()
    val pizzas: LiveData<List<PizzaItem>> get() = _pizzas

    init {
        loadPizzas()
    }

    fun setCity(city: String) {
        _selectedCity.value = city
    }

    private fun loadPizzas() {
        val pizzaList = listOf(
            PizzaItem.MARGHERITA,
            PizzaItem.PEPPERONI,
            PizzaItem.MUSHROOM,
            PizzaItem.HAWAIIAN,
            PizzaItem.SUPREME
        )
        _pizzas.value = pizzaList
    }
}
