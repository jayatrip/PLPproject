package com.mealsonwheels.data

import com.mealsonwheels.R
import com.mealsonwheels.model.Restaurants
import com.mealsonwheels.model.FoodItem


class DataSource {

    companion object {

        val cartItems: ArrayList<FoodItem> = ArrayList()

        fun getFoodCategories(): ArrayList<Restaurants> {
            val list = ArrayList<Restaurants>()
            list.add(Restaurants("1", "Kurry Kingdom", R.drawable.restaurant1))
            list.add(Restaurants("2", "Indian Masala", R.drawable.restaurant2))
            list.add(Restaurants("1", "SpiceUp", R.drawable.restaurant3))
            list.add(Restaurants("1", "Bawarchi Hyderabad", R.drawable.restaurant4))
            return list
        }

        fun getFoodItem(): ArrayList<FoodItem> {
            val list = ArrayList<FoodItem>()
            list.add(FoodItem("1", "Mini Burger", R.drawable.burger,"100 Rs",1,""))
            list.add(FoodItem("2", "Chicken Fry", R.drawable.chickenfry,"1000 Rs",1,""))
            list.add(FoodItem("1", "Sub Sandwich", R.drawable.subsandwich,"100Rs",1,""))
            list.add(FoodItem("2", "Fried Rice", R.drawable.friedrice,"1000Rs",1,""))
            list.add(FoodItem("1", "Prawn Fry", R.drawable.prawnfry,"100Rs",1,""))
            list.add(FoodItem("2", "Prawn Grill", R.drawable.prawngrill,"1000Rs",1,""))

            return list
        }

        fun addToCart(foodItem: FoodItem) {
            cartItems.add(foodItem)
        }

        fun removeFromCart(foodItem: FoodItem) {
            cartItems.remove(foodItem)
        }





    }
}