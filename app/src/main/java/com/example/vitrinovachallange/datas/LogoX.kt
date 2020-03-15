package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class LogoX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)