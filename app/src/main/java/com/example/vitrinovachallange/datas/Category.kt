package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("children")
    val children: List<Any>,
    @SerializedName("cover")
    val cover: Cover,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("parent_category")
    val parentCategory: Any,
    @SerializedName("parent_id")
    val parentİd: Any
)