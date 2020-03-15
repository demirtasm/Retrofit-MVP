package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Shop(
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("cover")
    val cover: CoverXXX,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("follower_count")
    val followerCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_editor_choice")
    val isEditorChoice: Boolean,
    @SerializedName("is_following")
    val isFollowing: Boolean,
    @SerializedName("logo")
    val logo: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_updateable")
    val nameUpdateable: Boolean,
    @SerializedName("product_count")
    val productCount: Int,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("shop_payment_id")
    val shopPaymentİd: Int,
    @SerializedName("shop_rate")
    val shopRate: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("vacation_mode")
    val vacationMode: Int
)