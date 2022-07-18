package com.example.myapplication;


data class OrderCoffee(var typeOfCoffee: String)

data class Response(var somethingString: String)

data class Resources(var gotWater : Int, var gotMilk : Int,
                     var gotCoffeeBeans : Int, var gotCups : Int)

enum class Coffee(val water: Int,
                  val milk: Int,
                  val coffeeBeans: Int,
                  val cost: Int) {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6)

}

/**
 * Model class - describes the components and methods of the coffee machine
 */

class Model(private var water: Int = 400,
            private var milk: Int = 540,
            private var cofeeBeans: Int = 120,
            private var cups: Int = 9,
            private var money: Int = 550) {


    /**
     * Private function calculations - calculations are being made
     * of what we have left after the purchase
     * @param coffee - responsible for a certain type of coffee
     */
    private fun calculations(coffee: Coffee) {
        water -= coffee.water
        milk -= coffee.milk
        cofeeBeans -= coffee.coffeeBeans
        money += coffee.cost
        cups -=1
    }

    /**
     * Private function checkIngr - checking if we have enough ingredients
     * @param coffee - responsible for a certain type of coffee
     * @return string - information about ingredients
     */
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

    /**
     * Private function buy - determining the type of coffee for further processing
     * @param coffee - responsible for a certain type of coffee
     * @return string - information about purchased coffee
     */

    fun buy(coffee: OrderCoffee) : Response {
        val cooffee = when (coffee.typeOfCoffee){
            "Espresso" -> Response(checkIngr(Coffee.ESPRESSO) + remaining())
            "Latte" -> Response(checkIngr(Coffee.LATTE) + remaining())
            else -> Response(checkIngr(Coffee.CAPPUCCINO) + remaining())
        }
        return cooffee
    }

    /**
     * Private function take - determining how much money we take from the coffee machine
     * @return string - information about money in coffee machine
     */
    fun take() : Response {
        val temp = money
        money = 0
        return Response("I gave you $temp")
    }

    /**
     * Public function remaining - information about ingredients in the machine
     * @return string - information about ingredients in coffee machine
     */
    fun remaining() :String {
        return "The coffee machine has: \n" +
                "$water of water. \n" +
                "$milk of milk. \n" +
                "$cofeeBeans of coffee beans. \n" +
                "$cups of disposable cups. \n" +
                "$money of money."

    }

    /**
     * Public function fill - function of filling the coffee machine with ingredients
     * @param gotWater - how much water we got
     * @param gotMilk - how much milk we got
     * @param gotCoffeeBeans - how much coffeeBeans we got
     * @param gotCups - how many cups we got
     * @return string - information about ingredients in coffee machine
     */
    fun fill(resources: Resources) : Response {
        water += resources.gotWater
        milk += resources.gotMilk
        cofeeBeans += resources.gotCoffeeBeans
        cups += resources.gotCups

        return Response(remaining())
    }



}