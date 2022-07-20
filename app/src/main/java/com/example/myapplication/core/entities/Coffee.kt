package com.example.myapplication.core.entities

enum class Coffee(val water: Int,
                  val milk: Int,
                  val coffeeBeans: Int,
                  val cost: Int) {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6)

}