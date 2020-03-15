package com.example.vitrinovachallange.datas


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("cargo_time")
    val cargoTime: Int,
    @SerializedName("category")
    val category: CategoryX,
    @SerializedName("category_id")
    val categoryİd: Int,
    @SerializedName("code")
    val code: Any,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("commission_rate")
    val commissionRate: Int,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("difference")
    val difference: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: MutableList<İmage>,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_approved")
    val isApproved: Boolean,
    @SerializedName("is_cargo_free")
    val isCargoFree: Boolean,
    @SerializedName("is_editor_choice")
    val isEditorChoice: Boolean,
    @SerializedName("is_liked")
    val isLiked: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("is_owner")
    val isOwner: Boolean,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("max_installment")
    val maxİnstallment: Any,
    @SerializedName("old_price")
    val oldPrice: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("reject_reason")
    val rejectReason: Any,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("shop")
    val shop: Shop,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("title")
    val title: String
)