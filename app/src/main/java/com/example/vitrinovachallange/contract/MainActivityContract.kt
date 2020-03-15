package com.example.vitrinovachallange.contract

interface MainActivityContract {
    interface View{
        fun bindView()

        fun initOnClick()

        fun setNavigation()

    }
    interface Presenter{
        fun setView(view: View)

        fun created()
    }
}