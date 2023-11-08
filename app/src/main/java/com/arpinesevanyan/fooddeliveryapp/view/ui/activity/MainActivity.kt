package com.arpinesevanyan.fooddeliveryapp.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.arpinesevanyan.fooddeliveryapp.view.ui.OnPizzaItemClickListener
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem
import com.arpinesevanyan.fooddeliveryapp.view.ui.fragment.OrderFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), OnPizzaItemClickListener {

    private lateinit var navController: NavController
    private var orderFragment: OrderFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        orderFragment = supportFragmentManager.findFragmentById(R.id.orderFragment) as? OrderFragment
    }

    override fun onPizzaItemClicked(pizzaItem: PizzaItem) {
        orderFragment?.onPizzaItemClicked(pizzaItem)
    }
}


