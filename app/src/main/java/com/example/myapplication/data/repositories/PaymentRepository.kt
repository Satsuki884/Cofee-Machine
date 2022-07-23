package com.example.myapplication.data.repositories

import com.example.myapplication.core.entities.*
import com.example.myapplication.data.network.ExchangeServiceAPI
import com.example.myapplication.data.mappers.NetworkPaymentToPaymentMapper

class PaymentRepositoryImplementation(
    private val exchangeServiceApi: ExchangeServiceAPI,
    private val networkPaymentToPaymentMapper: NetworkPaymentToPaymentMapper
): ActionRepository {
    override fun take(): Response {
        TODO("Not yet implemented")
    }

    override fun checkIngr(coffee: Coffee): String {
        TODO("Not yet implemented")
    }

    override fun calculations(coffee: Coffee) {
        TODO("Not yet implemented")
    }

    override fun remaining(): String {
        TODO("Not yet implemented")
    }

    override fun fill(resources: Resources): Response {
        TODO("Not yet implemented")
    }

    override fun buy(coffee: OrderCoffee): Response {
        TODO("Not yet implemented")
    }

    override fun makeNetworkExchange(payment: Payment): Payment {
        val networkPayment = {
            exchangeServiceApi.exchangeCurrency(
                "USD/${payment.currency}/${payment.amount}"
            )
        }
        return networkPaymentToPaymentMapper.toDomain(networkPayment)
    }

}