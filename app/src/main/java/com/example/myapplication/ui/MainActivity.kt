package com.example.myapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.adapters.Contract
import com.example.myapplication.adapters.MainPresenter
import com.example.myapplication.core.interactors.Model
import com.example.myapplication.core.entities.OrderCoffee
import com.example.myapplication.core.entities.Resources

class MainActivity : AppCompatActivity(), Contract.View{

    private val presenter = MainPresenter(Model())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)

        val info: TextView = findViewById(R.id.textView5)

        val espresso: Button = findViewById(R.id.button)
        espresso.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Espresso")
            val information = presenter.buy(informationAboutCoffee)
            info.text = information.somethingString
        }

        val latte: Button = findViewById(R.id.button2)
        latte.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Latte")
            val information = presenter.buy(informationAboutCoffee)
            info.text = information.somethingString
        }

        val cappuccino: Button = findViewById(R.id.button3)
        cappuccino.setOnClickListener {
            val informationAboutCoffee = OrderCoffee("Cappuccino")
            val information = presenter.buy(informationAboutCoffee)
            info.text = information.somethingString
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
            info.text = information.somethingString
        }

        val takeMoney: Button = findViewById(R.id.button5)
        takeMoney.setOnClickListener {
            val information = presenter.take()
            info.text = information.somethingString
        }

    }

}
