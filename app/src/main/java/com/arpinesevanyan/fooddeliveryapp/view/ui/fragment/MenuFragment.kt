package com.arpinesevanyan.fooddeliveryapp.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.arpinesevanyan.fooddeliveryapp.view.ui.OnPizzaItemClickListener
import com.arpinesevanyan.fooddeliveryapp.view.adapter.PizzaAdapter
import com.arpinesevanyan.fooddeliveryapp.R
import com.arpinesevanyan.fooddeliveryapp.view.adapter.ViewPagerAdapter
import com.arpinesevanyan.fooddeliveryapp.model.data.PizzaItem
import com.arpinesevanyan.fooddeliveryapp.model.data.SliderData
import com.arpinesevanyan.fooddeliveryapp.viewmodel.MenuViewModel

class MenuFragment : Fragment() {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var recyclerViewAdapter: PizzaAdapter

    private val viewPagerData = listOf(
        SliderData.SLIDER1,
        SliderData.SLIDER2,
        SliderData.SLIDER3
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        menuViewModel = ViewModelProvider(requireActivity()).get(MenuViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityDropdownImageView = view.findViewById<ImageView>(R.id.cityDropdown)
        val cityName = view.findViewById<TextView>(R.id.cityName)

        val viewPager = view.findViewById<ViewPager>(R.id.bannerSlider)
        val recyclerView = view.findViewById<RecyclerView>(R.id.pizzaRecyclerView)

        val viewPagerAdapter = ViewPagerAdapter(viewPagerData, requireContext())
        recyclerViewAdapter = PizzaAdapter(emptyList(), object : OnPizzaItemClickListener {
            override fun onPizzaItemClicked(pizzaItem: PizzaItem) {
                val orderFragment =
                    childFragmentManager.findFragmentByTag("orderFragment") as OrderFragment?
                orderFragment?.onPizzaItemClicked(pizzaItem)
            }
        })

        viewPager.adapter = viewPagerAdapter
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        menuViewModel.selectedCity.observe(viewLifecycleOwner) { city ->
            cityName.text = city
        }

        menuViewModel.pizzas.observe(viewLifecycleOwner) { pizzas ->
            recyclerViewAdapter.updateData(pizzas)
        }

        cityDropdownImageView.setOnClickListener { view ->
            showCityPopupMenu(view)
        }
    }

    private fun showCityPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.city_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.city_moscow -> {
                    menuViewModel.setCity("Москва")
                    true
                }
                R.id.city_new_york -> {
                    menuViewModel.setCity("Нью-Йорк")
                    true
                }
                R.id.city_tbilisi -> {
                    menuViewModel.setCity("Тбилиси")
                    true
                }
                R.id.city_yerevan -> {
                    menuViewModel.setCity("Ереван")
                    true
                }
                R.id.city_paris -> {
                    menuViewModel.setCity("Париж")
                    true
                }
                R.id.city_piter -> {
                    menuViewModel.setCity("Санкт-Петербург")
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

}
