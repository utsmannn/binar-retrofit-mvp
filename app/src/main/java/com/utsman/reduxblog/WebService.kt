package com.utsman.reduxblog

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WebService {

    companion object {
        private const val BASE_URL = "http://reduxblog.herokuapp.com/"
        private const val POST = "/api/posts"

        private val logInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(logInterceptor)
            .build()

        fun retrofit(): WebService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(WebService::class.java)
        }
    }

    @GET(POST)
    suspend fun getPosts(): List<Item>

    @GET("$POST/{id}")
    suspend fun getPost(
        @Path("id") id: Long
    ): Item

    @POST(POST)
    suspend fun addPost(post: Item): Item

    @DELETE("$POST/{id}")
    suspend fun deletePost(
        @Path("id") id: Long
    )

}