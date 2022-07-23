package com.example.myapplication.data.repositories

import com.example.myapplication.core.entities.*
import com.example.myapplication.data.network.*
import com.example.myapplication.data.mappers.*

class FakeMachineRepository: ActionRepository {

    object coffeeMachine{
        var water: Int = 400
        var milk: Int = 540
        var cofeeBeans: Int = 120
        var cups: Int = 9
        var money: Int = 550
    }

    override fun take() : Response {
        val temp = coffeeMachine.money
        coffeeMachine.money = 0
        return Response("I gave you $temp")
    }

    fun checkIngr(coffee: Coffee, price: Int) : String {
        var remainder = 0f
        var yourChange = "Your change: $remainder"
        if (coffeeMachine.water < coffee.water) {
            return ("Sorry, not enough water! \n")
        }else if (coffeeMachine.milk < coffee.milk) {
            return ("Sorry, not enough milk! \n")
        }else if (coffeeMachine.cofeeBeans < coffee.coffeeBeans) {
            return ("Sorry, not enough coffee beans! \n")
        }else if (coffeeMachine.cups <= 0){
            return ("Sorry, not enough cups! \n")
        } else if(coffee.cost > price) {
            return ("Sorry, not enough money")
        } else {
            if(price > coffee.cost){
                remainder = (coffee.cost - price).toFloat()
                calculations(coffee)
                return ("I have enough resources, making you a coffee! \n$yourChange")
            } else{
                calculations(coffee)
                return ("I have enough resources, making you a coffee! \n")
            }
        }
    }

    fun calculations(coffee: Coffee) {
        coffeeMachine.water -= coffee.water
        coffeeMachine.milk -= coffee.milk
        coffeeMachine.cofeeBeans -= coffee.coffeeBeans
        coffeeMachine.money += coffee.cost
        coffeeMachine.cups -=1
    }

    override fun remaining() :String {
        return "The coffee machine has: \n" +
                "${coffeeMachine.water} of water. \n" +
                "${coffeeMachine.milk} of milk. \n" +
                "${coffeeMachine.cofeeBeans} of coffee beans. \n" +
                "${coffeeMachine.cups} of disposable cups. \n" +
                "${coffeeMachine.money} of money."

    }

    override fun fill(resources: Resources) : Response {
        coffeeMachine.water += resources.gotWater
        coffeeMachine.milk += resources.gotMilk
        coffeeMachine.cofeeBeans += resources.gotCoffeeBeans
        coffeeMachine.cups += resources.gotCups

        return Response(remaining())
    }

    override fun buy(coffee: OrderCoffee, price: Response) : Response {
        val cooffee = when (coffee.orderCoffee){
            "Espresso" -> Response(checkIngr(Coffee.ESPRESSO, price.response.toInt()) + remaining())
            "Latte" -> Response(checkIngr(Coffee.LATTE, price.response.toInt()) + remaining())
            else -> Response(checkIngr(Coffee.CAPPUCCINO, price.response.toInt()) + remaining())
        }
        return cooffee
    }

    override fun makeNetworkExchange(payment: Payment): Payment {
        TODO("Not yet implemented")
    }


}