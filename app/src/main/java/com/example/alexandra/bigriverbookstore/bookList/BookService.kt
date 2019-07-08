package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.AuthorResource
import com.example.alexandra.bigriverbookstore.resources.BookResource
import com.example.alexandra.bigriverbookstore.resources.PhotoResource
import com.squareup.moshi.Moshi
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface BookService {
    @GET("books?include=photos,author")
    fun getBooks(): Call<List<BookResource>>

    companion object {
        fun getMoshi(): Moshi {
            // Create the factory
            val jsonApiAdapterFactory = ResourceAdapterFactory.builder()
                .add(AuthorResource::class.java)
                .add(BookResource::class.java)
                .add(PhotoResource::class.java)
                .build()

            // Create a custom moshi instance
            return Moshi.Builder()
                .add(jsonApiAdapterFactory)
                .build()
        }

        fun newInstance(): BookService {
            val moshi = getMoshi()
            val client = OkHttpClient().newBuilder()
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonapiplayground.reyesoft.com/v2/")
                .client(client)
                .addConverterFactory(JsonApiConverterFactory.create(moshi))
                .build()

            return retrofit.create(BookService::class.java)
        }
    }
}