package com.arpinesevanyan.fooddeliveryapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.arpinesevanyan.fooddeliveryapp.ui.adapter.PizzaAdapter
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.ui.adapter.ViewPagerAdapter
import com.arpinesevanyan.fooddeliveryapp.data.PizzaItem
import com.arpinesevanyan.fooddeliveryapp.data.SliderData

class MenuFragment : Fragment() {

    private val viewPagerData = listOf(
        SliderData.SLIDER1,
        SliderData.SLIDER2,
        SliderData.SLIDER3
    )
    private val recyclerViewData = listOf(
        PizzaItem.MARGHERITA,
        PizzaItem.PEPPERONI,
        PizzaItem.MUSHROOM,
        PizzaItem.HAWAIIAN,
        PizzaItem.SUPREME
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)

        val cityDropdownImageView = rootView.findViewById<ImageView>(R.id.cityDropdown)
        val cityName = rootView.findViewById<TextView>(R.id.cityName) // Объявляем cityName здесь

        cityDropdownImageView.setOnClickListener { view ->
            showCityPopupMenu(view, cityName)
        }

        val viewPager = rootView.findViewById<ViewPager>(R.id.bannerSlider)

        val viewPagerAdapter = ViewPagerAdapter(viewPagerData, requireContext())
        viewPager.adapter = viewPagerAdapter

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.pizzaRecyclerView)

        val recyclerViewAdapter = PizzaAdapter(recyclerViewData)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView

    }

    private fun showCityPopupMenu(view: View, cityName: TextView) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.city_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.city_moscow -> {
                    cityName.text = "Москва"
                    true
                }
                R.id.city_new_york -> {
                    cityName.text = "Нью-Йорк"
                    true
                }
                R.id.city_tbilisi -> {
                    cityName.text = "Тбилиси"
                    true
                }
                R.id.city_yerevan -> {
                    cityName.text = "Ереван"
                    true
                }
                R.id.city_paris -> {
                    cityName.text = "Париж"
                    true
                }
                R.id.city_piter -> {
                    cityName.text = "Санкт-Петербург"
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}