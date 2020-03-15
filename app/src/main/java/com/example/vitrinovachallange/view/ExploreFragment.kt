package com.example.vitrinovachallange.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.adapter.ExploreAdapterCategorys
import com.example.vitrinovachallange.adapter.ExploreAdapterFeatured
import com.example.vitrinovachallange.adapter.ExploreAdapterProducts
import com.example.vitrinovachallange.datas.Category

import com.example.vitrinovachallange.datas.Featured
import com.example.vitrinovachallange.datas.Product
import com.example.vitrinovachallange.datas.Vitrinova
import com.example.vitrinovachallange.singleton.ApiClient
import com.example.vitrinovachallange.singleton.ApiInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_explore.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ExploreFragment : Fragment() {

    val allFeaturedDatas: MutableList<Featured> = mutableListOf()
    val allProductsDatas: MutableList<Product> = mutableListOf()
    val allProductsCategories : MutableList<Category> = mutableListOf()

    private lateinit var myAdapter: ExploreAdapterFeatured
    private lateinit var myProductsAdapter: ExploreAdapterProducts
    private lateinit var myProductsCategory: ExploreAdapterCategorys

    lateinit var dotsLayout: LinearLayout
    lateinit var mPager: ViewPager

    var path: Array<Int> = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.images3)

    lateinit var dots: Array<ImageView>

    var currentPage: Int = 0
    lateinit var timer: Timer
    val DELAY_MS: Long = 5000
    val PERIOD_MS: Long = 5000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = ExploreAdapterFeatured(allFeaturedDatas)
        myProductsAdapter = ExploreAdapterProducts(allProductsDatas)
        myProductsCategory = ExploreAdapterCategorys(allProductsCategories)

        dotsLayout = activity?.findViewById(R.id.dotsLayout) as LinearLayout
        mPager = activity?.findViewById(R.id.viewPager) as ViewPager


        var imgCollection = activity?.findViewById<ImageView>(R.id.imgCollections) as ImageView
        var tvCollectionTitle = activity?.findViewById<TextView>(R.id.tvGiftSuggestions) as TextView

        setupIndicators() //TO MAKE IMAGE POINTS
        setCurrentIndicator(0)

        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
                Log.e("MESSAGE:", "position: "+position)
            }

        })

        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.allList()
        apiCall?.enqueue(object : Callback<List<Vitrinova>> {
            override fun onFailure(call: Call<List<Vitrinova>>, t: Throwable) {
                Toast.makeText(context, "ERROR:", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Vitrinova>>,
                response: Response<List<Vitrinova>>
            ) {
                allFeaturedDatas.addAll(response?.body()?.get(0)?.featured!!)
                myAdapter.notifyDataSetChanged()
                val linearLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                recyclerViewExplore.layoutManager = linearLayoutManager
                recyclerViewExplore?.adapter = myAdapter


                allProductsDatas.addAll(response?.body()?.get(1)?.products!!)
                myProductsAdapter.notifyDataSetChanged()
                val linearLayoutManagerExplore = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                recyclerViewExploreProducts.layoutManager = linearLayoutManagerExplore
                recyclerViewExploreProducts?.adapter = myProductsAdapter


                allProductsCategories.addAll(response?.body()?.get(2)?.categories!!)
                myProductsCategory.notifyDataSetChanged()
                val linearLayoutManagerCategory = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                recyclerViewCategories.layoutManager = linearLayoutManagerCategory
                recyclerViewCategories?.adapter = myProductsCategory

                Picasso.get().load(response?.body()?.get(3)?.collections?.get(0)?.cover?.url).into(imgCollection)
                tvCollectionTitle.text = response?.body()?.get(3)?.collections?.get(0)?.title
            }

        })

    }

    private fun setupIndicators() {
        if (dotsLayout != null) {
            dotsLayout.removeAllViews()
        }
        dots = Array(path.size, { i -> ImageView(activity) })
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(4, 0, 4, 0)
        for (i in 0..path.size - 1) {
            dots[i] = ImageView(activity)
            dots[i].setImageDrawable(
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.indicator_selector
                )
            )
            dotsLayout.addView(dots[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = dotsLayout.childCount
        for (i in 0 until childCount) {
            val imageView = dotsLayout[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.selector_indicator
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.indicator_selector
                    )
                )
            }
        }
    }
}
