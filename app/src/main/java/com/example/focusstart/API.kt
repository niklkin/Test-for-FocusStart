package com.example.focusstart

import com.example.focusstart.model.Q
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("/{Id}")
    fun getQuotes(@Path("Id") id: String) : Call<Q>

}