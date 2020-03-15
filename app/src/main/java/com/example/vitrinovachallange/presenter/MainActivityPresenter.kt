package com.example.vitrinovachallange.presenter

import com.example.vitrinovachallange.contract.MainActivityContract

class MainActivityPresenter : MainActivityContract.Presenter {

    private lateinit var mView: MainActivityContract.View

    override fun setView(view: MainActivityContract.View) {
        this.mView = view
    }

    override fun created() {
        this.mView.bindView()

        this.mView.initOnClick()

        this.mView.setNavigation()



    }
}