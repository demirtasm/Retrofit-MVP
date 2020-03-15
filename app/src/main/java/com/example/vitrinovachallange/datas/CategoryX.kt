package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class CategoryX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("parent_category")
    val parentCategory: ParentCategory,
    @SerializedName("parent_id")
    val parentİd: Int
)