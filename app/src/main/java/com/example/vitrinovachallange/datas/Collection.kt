package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("cover")
    val cover: CoverX,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("end")
    val end: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: LogoX,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("title")
    val title: String
)