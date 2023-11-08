package com.arpinesevanyan.fooddeliveryapp.model.data

enum class PizzaItem(
    val namePizza: String,
    val imageUrl: String,
    val description: String,
    val price: Int
) {
    MARGHERITA(
        "Margherita",
        "https://www.blossmangas.com/wp-content/uploads/2021/05/Margherita-pizza-2.jpg",
        "Classic tomato and mozzarella cheese pizza.",
        230
    ),
    PEPPERONI(
        "Pepperoni",
        "https://toppng.com/uploads/preview/epperoni-pizza-png-pizza-pepperoni-11563248691ecls6qyxtd.png",
        "Classic pepperoni pizza with tomato sauce and cheese.",
        320
    ),
    MUSHROOM(
        "Mushroom",
        "https://www.allrecipes.com/thmb/3qkooqf4vsQ3DjzjIZy0s6ZSwC0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/36107allies-mushroom-pizzafabeveryday4x3-005f809371b147378094d60f28daf212.jpg",
        "Pizza with mushrooms, tomato sauce, and cheese.",
        330
    ),
    HAWAIIAN(
        "Hawaiian",
        "https://static01.nyt.com/images/2023/03/29/multimedia/23HAMREX2-pineapple-ham-pizza-qwct/HAMREX2-pineapple-ham-pizza-qwct-superJumbo.jpg",
        "Ham and pineapple pizza with tomato sauce and cheese.",
        330
    ),
    SUPREME(
        "Supreme",
        "https://goodcheapeats.com/wp-content/uploads/2023/10/Supreme-pizza-prep-8.jpg",
        "A loaded pizza with various toppings and extra cheese.",
        290
    )
}

