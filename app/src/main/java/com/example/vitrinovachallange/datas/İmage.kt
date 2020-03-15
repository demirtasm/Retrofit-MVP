package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class İmage(
    @SerializedName("height")
    val height: Int,
    @SerializedName("medium")
    val medium: MediumXXXXX,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailXXXXX,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)