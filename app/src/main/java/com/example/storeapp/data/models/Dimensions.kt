package com.example.storeapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
)