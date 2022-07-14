package com.azazellj.tuneinapp.data.network

import com.azazellj.tuneinapp.data.network.response.ElementResponse
import com.azazellj.tuneinapp.domain.network.response.DefaultResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming
import retrofit2.http.Url

interface DefaultApi {

    @GET
    suspend fun getElements(
        @Url url: String,
        @Query("render") render: String = "json",
    ): DefaultResponse<List<ElementResponse>>

    @Streaming
    @GET
    suspend fun fetchStreamingUrl(
        @Url url: String,
    ): Response<ResponseBody>
}