package com.example.myapplication.core.entities

data class Payment(
    val id: Long? = null,
    val amount: Float,
    val currency: String
)
