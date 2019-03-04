package com.agilefreaks.bigriverbookstore

import com.agilefreaks.bigriverbookstore.model.Api
import com.agilefreaks.bigriverbookstore.model.Books
import com.squareup.moshi.Moshi
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit

class ApiTest {
    @Test
    fun `test api`() {
        val jsonApiFactory = ResourceAdapterFactory.builder()
            .add(Books::class.java)
            .build()

        val moshi = Moshi.Builder()
            .add(jsonApiFactory)
            .build()

        val client = OkHttpClient().newBuilder()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonapiplayground.reyesoft.com/v2/")
            .client(client)
            .addConverterFactory(JsonApiConverterFactory.create(moshi))
            .build()

        val service = retrofit.create(Api::class.java)

        val call = service.listBooks()
        val response = call.execute()
        val books = response.body()

        val firstBook = books?.first()
        assertEquals("Jast-Lockman", firstBook?.title)
    }
}

