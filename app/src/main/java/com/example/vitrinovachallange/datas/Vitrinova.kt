package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Vitrinova(
    @SerializedName("categories")
    val categories: MutableList<Category>,
    @SerializedName("collections")
    val collections: MutableList<Collection>,
    @SerializedName("featured")
    val featured: MutableList<Featured>,
    @SerializedName("products")
    val products: MutableList<Product>,
    @SerializedName("shops")
    val shops: MutableList<ShopX>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)