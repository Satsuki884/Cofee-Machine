package com.example.myapplication.adapters

//import com.example.myapplication.Model
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.entities.Response
import com.example.myapplication.core.interactors.Model

class MainPresenter( private val model : Model): Contract.Presenter {

    private var view: Contract.View? = null

    override fun attach(view: Contract.View){
        this.view = view
    }

    override fun detach(){
        this.view = null
    }

    //val model = Model()

    fun buy(order: OrderCoffee) : Response {
        return model.buy(order)
    }

    fun take() : Response {
        return model.take()
    }

    fun fillAll(resources: Resources) : Response {
        return model.fill(resources)
    }


}