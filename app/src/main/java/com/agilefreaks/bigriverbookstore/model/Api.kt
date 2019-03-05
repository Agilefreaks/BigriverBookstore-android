package com.agilefreaks.bigriverbookstore.model

import moe.banana.jsonapi2.Document
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("books?include=author,chapters,photos,series,stores") fun listBooks(): Call<Document<Books>>
}