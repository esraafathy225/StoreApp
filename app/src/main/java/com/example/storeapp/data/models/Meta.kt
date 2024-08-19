package com.example.storeapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    val barcode: String,
    val createdAt: String,
    val qrCode: String,
    val updatedAt: String
)