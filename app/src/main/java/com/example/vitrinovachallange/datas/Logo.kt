package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)