package com.example.nihilentdemo.data.modal


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("pid")
    val pid: Int?,
    @SerializedName("addToCartButtonText")
    val addToCartButtonText: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("citrusId")
    val citrusId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("imageURL")
    val imageURL: String?,
    @SerializedName("isAddToCartEnable")
    val isAddToCartEnable: Boolean?,
    @SerializedName("isDeliveryOnly")
    val isDeliveryOnly: Boolean?,
    @SerializedName("isDirectFromSupplier")
    val isDirectFromSupplier: Boolean?,
    @SerializedName("isFindMeEnable")
    val isFindMeEnable: Boolean?,
    @SerializedName("isInTrolley")
    val isInTrolley: Boolean?,
    @SerializedName("isInWishlist")
    var isInWishlist: Boolean?,
    @SerializedName("ratingCount")
    val ratingCount: Double?,
    @SerializedName("saleUnitPrice")
    val saleUnitPrice: Double?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("totalReviewCount")
    val totalReviewCount: Int?
)