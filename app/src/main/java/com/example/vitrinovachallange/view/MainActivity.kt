package com.example.vitrinovachallange.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.contract.MainActivityContract
import com.example.vitrinovachallange.presenter.MainActivityPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var productsFragment: ProductsFragment
    private lateinit var notificationFragment: NotificationFragment
    private lateinit var exploreFragment: ExploreFragment
    private lateinit var mPresenter: MainActivityPresenter
    //var allProduct = MutableLis<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mPresenter = MainActivityPresenter()

        this.mPresenter.setView(this)

        this.mPresenter.created()


    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.products -> {
                productsFragment = ProductsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, productsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.explore -> {
                exploreFragment = ExploreFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, exploreFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.notification -> {
                notificationFragment = NotificationFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, notificationFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }

        true
    }

    override fun bindView() {
       //bindler
    }

    override fun initOnClick() {
        //clickler
    }

    override fun setNavigation() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemSelectedListener(navListener)
        productsFragment = ProductsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, productsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }


}
