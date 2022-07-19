package com.example.myapplicationempty.ui.adapters


interface Contract {

    interface View

    interface Presenter {

        fun attach(view: View)

        fun detach()
    }
}
