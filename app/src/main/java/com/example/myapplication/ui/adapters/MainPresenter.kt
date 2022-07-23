package com.example.myapplication.ui.adapters

import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Response
import com.example.myapplication.core.entities.Payment
import com.example.myapplication.core.interactors.BuyCoffeeInteractor
import com.example.myapplication.core.interactors.ExchangeCurrencyInteractor
import com.example.myapplication.core.interactors.FillCoffeeMachineInteractor
import com.example.myapplication.core.interactors.TakeMoneyInteractor
import com.example.myapplicationempty.ui.adapters.Contract

class MainPresenter(
    private val buyCoffee: BuyCoffeeInteractor,
    private val takeMoney: TakeMoneyInteractor,
    private val fillCoffeeMachine: FillCoffeeMachineInteractor,
    private val exchangeCurrency: ExchangeCurrencyInteractor
) : Contract.Presenter {

    private var view: Contract.View? = null

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun exchangePayment(payment: Payment): Response {
            return exchangeCurrency(payment)
    }

    fun buy(order: OrderCoffee, payment: Payment) : Response {
        val price = exchangePayment(payment)
        return buyCoffee(order, price)
    }

    fun take() : Response {
        return takeMoney()
    }

    fun fillAll(resources: Resources) : Response {
        return fillCoffeeMachine(resources)
    }
}