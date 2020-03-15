package com.example.vitrinovachallange.singleton

import android.telecom.Call
import com.example.vitrinovachallange.datas.Product
import com.example.vitrinovachallange.datas.Vitrinova
import com.example.vitrinovachallange.model.ProductModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v2/discover")
    fun allList():retrofit2.Call<List<Vitrinova>>
}