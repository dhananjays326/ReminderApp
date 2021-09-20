package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Drug(
    @Json(name = "brandNm")
    val brandNm: String,
    @Json(name = "dosage")
    val dosage: Dosage,
    @Json(name = "genericNm")
    val genericNm: String,
    @Json(name = "qty")
    val qty: Int
)