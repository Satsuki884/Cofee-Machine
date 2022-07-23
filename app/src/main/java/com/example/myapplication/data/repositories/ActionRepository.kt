package com.example.myapplication.data.repositories

import com.example.myapplication.core.entities.Response
import com.example.myapplication.core.entities.Coffee
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Payment

interface ActionRepository {

    fun take() : Response

    fun remaining() : String

    fun fill(resources: Resources) : Response

    fun buy(coffee: OrderCoffee, price: Response) : Response


    fun makeNetworkExchange(payment: Payment): Payment

}
