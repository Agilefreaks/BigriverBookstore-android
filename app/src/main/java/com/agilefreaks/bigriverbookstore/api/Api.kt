package com.agilefreaks.bigriverbookstore.api

import androidx.annotation.VisibleForTesting
import com.agilefreaks.bigriverbookstore.model.*
import com.squareup.moshi.Moshi
import moe.banana.jsonapi2.Document
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("books?include=author,chapters,photos,series,stores")
    fun getBooks(): Call<Document<Books>>

    @GET("books/{book_id}?include=author,chapters,photos,series,stores")
    fun getBook(@Path (value = "book_id") bookId: Int): Call<Document<Books>>

    companion object {
        fun getMoshi() : Moshi {
            val jsonApiFactory = ResourceAdapterFactory.builder()
                .add(Books::class.java)
                .add(Authors::class.java)
                .add(Photos::class.java)
                .add(Chapters::class.java)
                .add(Series::class.java)
                .add(Stores::class.java)
                .build()

            return Moshi.Builder()
                .add(jsonApiFactory)
                .build()
        }

        fun newInstance(): Api {
            val moshi = getMoshi()

            val client = OkHttpClient().newBuilder()
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonapiplayground.reyesoft.com/v2/")
                .client(client)
                .addConverterFactory(JsonApiConverterFactory.create(moshi))
                .build()

            return retrofit.create(Api::class.java)
        }

        @VisibleForTesting
        internal fun newInstance(mock: Interceptor): Api {
            val moshi = getMoshi()

            val client = OkHttpClient().newBuilder()
                .addInterceptor(mock)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonapiplayground.reyesoft.com/v2/")
                .client(client)
                .addConverterFactory(JsonApiConverterFactory.create(moshi))
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}