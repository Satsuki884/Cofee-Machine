package com.example.myapplication.data.mappers

import com.example.myapplication.core.entities.Payment
import com.example.myapplication.data.network.NetworkPayment


class NetworkPaymentToPaymentMapper {

    fun toDomain(networkPayment: () -> NetworkPayment): Payment = with(networkPayment) {
        Payment(
                currency = targetCurrency,
                amount = conversionResult.toFloat()
            )
        }
}
