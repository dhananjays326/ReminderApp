package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "scheduleList")
    val scheduleList: List<Schedule>
)