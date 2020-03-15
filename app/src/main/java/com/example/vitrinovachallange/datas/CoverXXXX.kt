package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class CoverXXXX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXXXXXXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXXXXXXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)