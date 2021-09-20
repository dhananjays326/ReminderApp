package com.d.reminderapp.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Schedule(
    @Json(name = "drug")
    val drug: Drug?,
    @Json(name = "duration")
    val duration: Int,
    @Json(name = "frequency")
    val frequency: Int,
    @Json(name = "scheduleCd")
    val scheduleCd: String,
    @Json(name = "sessionList")
    val sessionList: List<Session>,
    @Json(name = "type")
    val type: String,

    @Json(name = "video")
    val video: Video?
)