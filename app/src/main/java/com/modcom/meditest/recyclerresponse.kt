package com.modcom.meditest

import com.google.gson.annotations.SerializedName
data class recyclerresponse(
    @SerializedName("albumId")
    var albumId: kotlin.Int,
    @SerializedName("id")
    var id: kotlin.Int,
    @SerializedName("test_name")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("image_path")
    val thumbnailUrl: String)