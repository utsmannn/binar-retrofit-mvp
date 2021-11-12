package com.utsman.reduxblog

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Long? = null,
    val title: String? = null,
    @SerializedName("categories")
    val categoriesanuan: String? = null
)
