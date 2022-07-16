package com.example.myapplication

class Controller() {

    val model = Model()

    fun buy(order: OrderCoffee) : Response {
        return model.buy(order)
    }

    /**
     * Public function take - responsible for the interaction of Model and user choice
     * @return ordering - a string in which we record the received data after collecting money
     */
    fun take() : Response {
        return model.take()
    }

    /**
     * Public function fillAll - responsible for filling the coffee machine with ingredients
     * @param choice - variable that stores the user's choice
     * @return infoAboutCoffee - a string in which we record the received data after processing the event
     */
    fun fillAll(resources: Resources) : Response {
        return model.fill(resources)
    }


}