package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class CoverXX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXXXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXXXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)