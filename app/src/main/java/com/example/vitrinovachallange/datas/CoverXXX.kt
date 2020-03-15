package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class CoverXXX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXXXXXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXXXXXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)