package com.example.myapplication.core.interactors

import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Response
import com.example.myapplication.data.repositories.ActionRepository

class BuyCoffeeInteractor(private val machine: ActionRepository){
    operator fun invoke(coffee: OrderCoffee, price: Response): Response{
        return machine.buy(coffee, price)
    }

}