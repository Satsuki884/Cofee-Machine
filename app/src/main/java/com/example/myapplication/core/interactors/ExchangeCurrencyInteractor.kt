package com.example.myapplication.core.interactors

import com.example.myapplication.core.entities.Payment
import com.example.myapplication.core.entities.Response
import com.example.myapplication.data.repositories.ActionRepository

class ExchangeCurrencyInteractor(private val repository: ActionRepository) {

    operator fun invoke(payment: Payment): Response {
        val exchangedPayment = if (payment.currency != "USD") {
            repository.makeNetworkExchange(payment)
        } else {
            payment
        }

        return Response(exchangedPayment.currency)
    }
}
