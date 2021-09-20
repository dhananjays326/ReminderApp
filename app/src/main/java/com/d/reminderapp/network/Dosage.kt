package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dosage(
    @Json(name = "dose")
    val dose: Int,
    @Json(name = "unit")
    val unit: String
)