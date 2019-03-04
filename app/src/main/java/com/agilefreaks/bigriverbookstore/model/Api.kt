package com.agilefreaks.bigriverbookstore.model

import moe.banana.jsonapi2.Document
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("books") fun listBooks(): Call<Document<Books>>
}