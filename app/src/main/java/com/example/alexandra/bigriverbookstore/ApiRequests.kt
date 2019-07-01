package com.example.alexandra.bigriverbookstore

import com.example.alexandra.bigriverbookstore.models.Books
import com.example.alexandra.bigriverbookstore.models.Photos
import com.squareup.moshi.Moshi
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

//https://medium.com/@r4rohit002/parse-json-with-moshi-873d0ff6af9b
//https://github.com/kamikat/moshi-jsonapi

interface ApiRequests {
    @GET("books?include=photos,author")
    fun getBooks(): Call<Books>

    companion object {
        fun getMoshi(): Moshi {
            // First create the factory
            val jsonApiAdapterFactory = ResourceAdapterFactory.builder()
                .add(Books::class.java)
                .add(Photos::class.java)
                .build()

            // Create a custom moshi instance
            val moshi = Moshi.Builder()
                .add(jsonApiAdapterFactory)
                .build()
            return moshi
        }

        fun newInstance(): ApiRequests {
            val moshi = getMoshi()
            val client = OkHttpClient().newBuilder()
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonapiplayground.reyesoft.com/v2/")
                .client(client)
                .addConverterFactory(JsonApiConverterFactory.create(moshi))
                .build()

            return retrofit.create(ApiRequests::class.java)
        }
    }
}