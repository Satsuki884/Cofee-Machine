package com.example.myapplication.ui.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Payment
import com.example.myapplication.core.entities.Resources
import com.example.myapplication.core.interactors.BuyCoffeeInteractor
import com.example.myapplication.core.interactors.ExchangeCurrencyInteractor
import com.example.myapplication.core.interactors.FillCoffeeMachineInteractor
import com.example.myapplication.core.interactors.TakeMoneyInteractor
import com.example.myapplication.data.repositories.FakeMachineRepository
import com.example.myapplication.ui.adapters.MainPresenter
import com.example.myapplicationempty.ui.adapters.Contract

class MainActivity : AppCompatActivity(), Contract.View{



    private val presenter = MainPresenter(
        BuyCoffeeInteractor(FakeMachineRepository()),
        TakeMoneyInteractor(FakeMachineRepository()),
        FillCoffeeMachineInteractor(FakeMachineRepository()),
        ExchangeCurrencyInteractor(FakeMachineRepository())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val info: TextView = findViewById(R.id.textView5)
        presenter.attach(this)



        val espresso: Button = findViewById(R.id.button)
        espresso.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Espresso")
            val gotMoney: EditText = findViewById(R.id.editText5)
            val idMoney = gotMoney.text
            val money = idMoney.toString().toFloat()
            val gotCurrency: EditText = findViewById(R.id.editText6)
            val idCurrency = gotCurrency.text
            val currency = idCurrency.toString()
            val paymentInfo = Payment(amount = money, currency = currency)
            val information = presenter.buy(informationAboutCoffee, paymentInfo)
            info.text = information.response
        }

        val latte: Button = findViewById(R.id.button2)
        latte.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Latte")
            val gotMoney: EditText = findViewById(R.id.editText5)
            val idMoney = gotMoney.text
            val money = idMoney.toString().toFloat()
            val gotCurrency: EditText = findViewById(R.id.editText6)
            val idCurrency = gotCurrency.text
            val currency = idCurrency.toString()
            val paymentInfo = Payment(amount = money, currency = currency)
            val information = presenter.buy(informationAboutCoffee, paymentInfo)
            info.text = information.response
        }

        val cappuccino: Button = findViewById(R.id.button3)
        cappuccino.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Cappuccino")
            val gotMoney: EditText = findViewById(R.id.editText5)
            val idMoney = gotMoney.text
            val money = idMoney.toString().toFloat()
            val gotCurrency: EditText = findViewById(R.id.editText6)
            val idCurrency = gotCurrency.text
            val currency = idCurrency.toString()
            val paymentInfo = Payment(amount = money, currency = currency)
            val information = presenter.buy(informationAboutCoffee, paymentInfo)
            info.text = information.response
        }

        val fill: Button = findViewById(R.id.button4)
        fill.setOnClickListener {
            val gotWater: EditText  = findViewById(R.id.editText)
            val idWater  = gotWater.text
            val water = idWater.toString().toInt()
            val gotMilk: EditText  = findViewById(R.id.editText2)
            val idMilk  = gotMilk.text
            val milk  = idMilk.toString().toInt()
            val gotCoffee: EditText  = findViewById(R.id.editText3)
            val idCoffee  = gotCoffee.text
            val coffeeBeans  = idCoffee.toString().toInt()
            val gotCups: EditText  = findViewById(R.id.editText4)
            val idCups = gotCups.text
            val cups  = idCups.toString().toInt()
            val resources = Resources(water, milk, coffeeBeans, cups)
            val information = presenter.fillAll(resources)
            info.text = information.response
        }

        val takeMoney: Button = findViewById(R.id.button5)
        takeMoney.setOnClickListener {
            val information = presenter.take()
            info.text = information.response
        }

    }
}
