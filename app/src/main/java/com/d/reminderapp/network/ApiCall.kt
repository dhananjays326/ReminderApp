package com.d.reminderapp.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {

    @GET("/dev/remind/schedule")
    suspend fun getResponse():ApiResponse
}