package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Video(
    @Json(name = "hlsUrl")
    val hlsUrl: String?,
    @Json(name = "thumbnail")
    val thumbnail: String?,
    @Json(name = "title")
    val title: String?
)