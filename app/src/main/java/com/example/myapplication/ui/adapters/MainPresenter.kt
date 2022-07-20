package com.example.myapplication.ui.adapters

import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Response
import com.example.myapplication.core.interactors.BuyCoffeeInteractor
import com.example.myapplication.core.interactors.FillCoffeeMachineInteractor
import com.example.myapplication.core.interactors.TakeMoneyInteractor
import com.example.myapplicationempty.ui.adapters.Contract

class MainPresenter(
    private val buyCoffee: BuyCoffeeInteractor,
    private val takeMoney: TakeMoneyInteractor,
    private val fillCoffeeMachine: FillCoffeeMachineInteractor
) : Contract.Presenter {

    private var view: Contract.View? = null

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun buy(order: OrderCoffee) : Response {
        return buyCoffee(order)
    }

    fun take() : Response {
        return takeMoney()
    }

    fun fillAll(resources: Resources) : Response {
        return fillCoffeeMachine(resources)
    }
}