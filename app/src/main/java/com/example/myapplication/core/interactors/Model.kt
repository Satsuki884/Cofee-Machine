package com.example.myapplication.core.interactors

import com.example.myapplication.core.entities.Coffee
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Response

class Model ( private var water: Int = 400,
              private var milk: Int = 540,
              private var cofeeBeans: Int = 120,
              private var cups: Int = 9,
              private var money: Int = 550) {

    private fun calculations(coffee: Coffee) {
        water -= coffee.water
        milk -= coffee.milk
        cofeeBeans -= coffee.coffeeBeans
        money += coffee.cost
        cups -=1
    }

    private fun checkIngr(coffee: Coffee) : String {
        if (water < coffee.water) {
            return ("Sorry, not enough water! \n")
        }else if (milk < coffee.milk) {
            return ("Sorry, not enough milk! \n")
        }else if (cofeeBeans < coffee.coffeeBeans) {
            return ("Sorry, not enough coffee beans! \n")
        }else if (cups <= 0){
            return ("Sorry, not enough cups! \n")
        } else {
            calculations(coffee)
            return ("I have enough resources, making you a coffee! \n")

        }
    }

    fun buy(coffee: OrderCoffee) : Response {
        val cooffee = when (coffee.typeOfCoffee){
            "Espresso" -> Response(checkIngr(Coffee.ESPRESSO) + remaining())
            "Latte" -> Response(checkIngr(Coffee.LATTE) + remaining())
            else -> Response(checkIngr(Coffee.CAPPUCCINO) + remaining())
        }
        return cooffee
    }

    fun take() : Response {
        val temp = money
        money = 0
        return Response("I gave you $temp")
    }

    fun remaining() :String {
        return "The coffee machine has: \n" +
                "$water of water. \n" +
                "$milk of milk. \n" +
                "$cofeeBeans of coffee beans. \n" +
                "$cups of disposable cups. \n" +
                "$money of money."

    }

    fun fill(resources: Resources) : Response {
        water += resources.gotWater
        milk += resources.gotMilk
        cofeeBeans += resources.gotCoffeeBeans
        cups += resources.gotCups

        return Response(remaining())
    }
}


