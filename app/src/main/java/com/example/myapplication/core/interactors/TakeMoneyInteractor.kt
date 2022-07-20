package com.example.myapplication.core.interactors

import com.example.myapplication.core.entities.Response
import com.example.myapplication.data.repositories.ActionRepository

class TakeMoneyInteractor(private val machine: ActionRepository){
    operator fun invoke(): Response{
        return machine.take()
    }
}