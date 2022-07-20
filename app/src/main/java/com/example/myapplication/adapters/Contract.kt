package com.example.myapplication.adapters

interface Contract {

    interface View {
    }

    interface Presenter{
        fun attach(view: View)

        fun detach()
    }
}