package com.example.storeapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)