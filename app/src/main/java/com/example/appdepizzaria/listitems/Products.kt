package com.example.appdepizzaria.listitems

import com.example.appdepizzaria.R
import com.example.appdepizzaria.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Cheese Pizza",
                price = "18.50"

            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Classic Pizza",
                price = "25.00"

            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                name = "Mixed Pizza",
                price = "28.00"

            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                name = "Salmon Pizza",
                price = "30.50"

            ),
            Product(
                imgProduct = R.drawable.kebab_vegetarian,
                name = "Kebab Vegetarian",
                price = "38.00"

            ),
            Product(
                imgProduct = R.drawable.kebab_chicken,
                name = "Kebab Chicken",
                price = "15.00"

            ),
            Product(
                imgProduct = R.drawable.kebab_beef,
                name = "Kebab Beef",
                price = "17.00"

            ),
            Product(
                imgProduct = R.drawable.chicken,
                name = "Chicken",
                price = "27.00"

            ),
            Product(
                imgProduct = R.drawable.cheddar,
                name = "Pizza Cheddar",
                price = "20.00"

            ),
            Product(
                imgProduct = R.drawable.beef_and_cheese,
                name = "Pizza Beef and Cheese",
                price = "38.00"

            ),
            Product(
                imgProduct = R.drawable.pizza_chocolate,
                name = "Pizza chocolate",
                price = "25.00"

            ),
            Product(
                imgProduct = R.drawable.pizza_margarita,
                name = "Pizza Margarita",
                price = "20.00"

            ),
            Product(
                imgProduct = R.drawable.pizza_pepperoni,
                name = "Pizza Pepperoni",
                price = "27.00"

            ),

        )
        _productList.value = productList
        return productListFlow

    }
}