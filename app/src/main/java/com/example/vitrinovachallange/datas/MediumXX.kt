package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class MediumXX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)