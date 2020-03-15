package com.example.vitrinovachallange.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.vitrinovachallange.adapter.ProductsAdapter
import com.example.vitrinovachallange.datas.Vitrinova
import com.example.vitrinovachallange.singleton.ApiClient
import com.example.vitrinovachallange.singleton.ApiInterface
import kotlinx.android.synthetic.main.fragment_products.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vitrinovachallange.R
import com.example.vitrinovachallange.datas.Category
import kotlinx.android.synthetic.main.products_layout.view.*


class ProductsFragment : Fragment() {

    val allDatas: MutableList<Category> = mutableListOf()
    private lateinit var myAdapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.vitrinovachallange.R.layout.fragment_products, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myAdapter = ProductsAdapter(allDatas)


        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.allList()
        apiCall?.enqueue(object : Callback<List<Vitrinova>> {
            override fun onFailure(call: Call<List<Vitrinova>>, t: Throwable) {
                Log.e("MESSAGE:", "unsuccesful")
            }

            override fun onResponse(
                call: Call<List<Vitrinova>>,
                response: Response<List<Vitrinova>>
            ) {

                allDatas.addAll(response?.body()?.get(2)?.categories!!)
                myAdapter.notifyDataSetChanged()
                val staggeredGridLayoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerViewProducts.layoutManager = staggeredGridLayoutManager
                recyclerViewProducts?.adapter = myAdapter

            }

        })
    }

}
