package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class CoverX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)