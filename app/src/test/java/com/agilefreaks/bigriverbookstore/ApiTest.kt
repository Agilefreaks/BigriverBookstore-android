package com.agilefreaks.bigriverbookstore

import com.agilefreaks.bigriverbookstore.model.*
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
            .add(Authors::class.java)
            .add(Photos::class.java)
            .add(Chapters::class.java)
            .add(Series::class.java)
            .add(Stores::class.java)
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
        assertEquals("2007-03-25", firstBook?.datePublished)
        assertEquals("617532143", firstBook?.isbn)

        val author = firstBook?.author
        assertEquals("Paul", author?.name)

        val photos = firstBook?.photos
        val firstPhoto = photos?.first()
        assertEquals("Photo 921", firstPhoto?.title)
    }
}

