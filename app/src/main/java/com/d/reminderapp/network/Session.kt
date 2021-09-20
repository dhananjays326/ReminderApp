package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Session(
    @Json(name = "foodContext")
    val foodContext: String,
    @Json(name = "session")
    val session: String
)