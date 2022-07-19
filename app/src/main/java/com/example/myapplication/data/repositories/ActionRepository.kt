package com.example.myapplication.data.repositories

import com.example.myapplication.core.entities.Response
import com.example.myapplication.core.entities.Coffee
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources

interface ActionRepository {

    fun take() : Response

    fun checkIngr(coffee: Coffee) : String

    fun calculations(coffee: Coffee)

    fun remaining() : String

    fun fill(resources: Resources) : Response

    fun buy(coffee: OrderCoffee) : Response

}
