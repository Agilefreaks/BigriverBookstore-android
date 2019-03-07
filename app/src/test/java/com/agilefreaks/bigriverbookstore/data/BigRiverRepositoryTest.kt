package com.agilefreaks.bigriverbookstore.data

import com.agilefreaks.bigriverbookstore.TestData
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.model.Books
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import moe.banana.jsonapi2.Document
import okhttp3.Request
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BigRiverRepositoryTest {

    interface CallExecuteTest : Call<Document<Books>> {
        override fun enqueue(callback: Callback<Document<Books>>) = TODO("not implemented")
        override fun isExecuted(): Boolean = TODO("not implemented")
        override fun clone(): Call<Document<Books>> = TODO("not implemented")
        override fun isCanceled(): Boolean = TODO("not implemented")
        override fun cancel() = TODO("not implemented")
        override fun request(): Request = TODO("not implemented")
    }

    @Test
    fun `getBooks() will return a list of books`() {
//        val obj = Api.getMoshi().adapter(Document<Books>()::class.java).fromJson(TestData.booksResponseBody)
//        spy<Call<Document<Books>>> {
//            on { execute() } doReturn mock<Response<Document<Books>>> {
//                on { body() } doReturn obj
//            }
//        }

        val api = mock<Api> {
            on{getBooks()} doReturn object: CallExecuteTest {
                override fun execute(): Response<Document<Books>> {
                    return Response.success(Api.getMoshi().adapter(Document<Books>()::class.java).fromJson(TestData.booksResponseBody))
                }
            }
        }
        val repository = BigRiverRepository(api)

        val future = repository.getBooks()
        val books = future.get()
        assertThat(books.size, equalTo(5))
    }

    @Test
    fun `getBook(1) will return the book with id 1`() {
        val api = mock<Api> {
            on{getBook(1)} doReturn object: CallExecuteTest {
                override fun execute(): Response<Document<Books>> {
                    return Response.success(Api.getMoshi().adapter(Document<Books>()::class.java).fromJson(TestData.book1ResponseBody))
                }
            }
        }
        val repository = BigRiverRepository(api)

        val future = repository.getBook(1)
        val book = future.get()
        assertThat(book.id, equalTo("1"))
        assertThat(book.name, equalTo("Jast-Lockman"))
        assertThat(book.author, equalTo("Paul"))
        assertThat(book.cover, equalTo("https://lorempixel.com/400/300/abstract/Faker/?50139"))
    }
}