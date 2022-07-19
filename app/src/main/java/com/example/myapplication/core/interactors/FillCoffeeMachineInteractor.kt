package com.example.myapplication.core.interactors

import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Response
import com.example.myapplication.data.repositories.ActionRepository

class FillCoffeeMachineInteractor(private val machine: ActionRepository) {
    operator fun invoke(resources: Resources): Response{
        return machine.fill(resources)
    }
}