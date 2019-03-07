package com.agilefreaks.bigriverbookstore.data

import com.agilefreaks.bigriverbookstore.TestData
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.model.Books
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import moe.banana.jsonapi2.Document
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class BigRiverRepositoryTest {

    @Test
    fun `getBooks() will return a list of books`() {
        val booksObject = Api.getMoshi().adapter(Document<Books>()::class.java).fromJson(TestData.booksResponseBody)
        val responseMock = mock<Response<Document<Books>>> {
            on { body() } doReturn booksObject
        }
        val callMock = mock<Call<Document<Books>>> {
            on { execute() } doReturn responseMock
        }
        val apiMock = mock<Api> {
            on{getBooks()} doReturn callMock
        }

        val repository = BigRiverRepository(apiMock)

        val future = repository.getBooks()
        val books = future.get()
        assertThat(books.size, equalTo(5))
    }

    @Test
    fun `getBook(1) will return the book with id 1`() {
        val bookObject = Api.getMoshi().adapter(Document<Books>()::class.java).fromJson(TestData.book1ResponseBody)

        val responseMock = mock<Response<Document<Books>>> {
            on { body() } doReturn bookObject
        }
        val callMock = mock<Call<Document<Books>>> {
            on { execute() } doReturn responseMock
        }
        val apiMock = mock<Api> {
            on{getBook(1)} doReturn callMock
        }
        val repository = BigRiverRepository(apiMock)

        val future = repository.getBook(1)
        val book = future.get()
        val expected = Book("1", "Jast-Lockman", "Paul", "https://lorempixel.com/400/300/abstract/Faker/?50139")
        assertThat(book, equalTo(expected))
    }
}