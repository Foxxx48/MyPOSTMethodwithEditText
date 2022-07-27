package com.fox.mypostmethodwithedittext

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksApi {
    @GET("/api/books")
    suspend fun getBooks(): Response<List<Books>>

    @POST("/api/books/create")
    suspend fun addBook(@Body book:Books): Response<Books>
}