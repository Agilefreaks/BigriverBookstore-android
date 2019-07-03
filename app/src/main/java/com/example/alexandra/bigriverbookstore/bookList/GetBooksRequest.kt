package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.AuthorEntity
import com.example.alexandra.bigriverbookstore.resources.BookEntity
import com.example.alexandra.bigriverbookstore.resources.PhotoEntity
import com.squareup.moshi.Moshi
import moe.banana.jsonapi2.JsonApiConverterFactory
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface GetBooksRequest {
    @GET("books?include=photos,author")
    fun getBooks(): Call<List<BookEntity>>

    companion object {
        fun getMoshi(): Moshi {
            // Create the factory
            val jsonApiAdapterFactory = ResourceAdapterFactory.builder()
                .add(AuthorEntity::class.java)
                .add(BookEntity::class.java)
                .add(PhotoEntity::class.java)
                .build()

            // Create a custom moshi instance
            val moshi = Moshi.Builder()
                .add(jsonApiAdapterFactory)
                .build()
            return moshi
        }

        fun newInstance(): GetBooksRequest {
            val moshi = getMoshi()
            val client = OkHttpClient().newBuilder()
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonapiplayground.reyesoft.com/v2/")
                .client(client)
                .addConverterFactory(JsonApiConverterFactory.create(moshi))
                .build()

            return retrofit.create(GetBooksRequest::class.java)
        }
    }
}