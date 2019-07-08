package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.JsonData
import com.example.alexandra.bigriverbookstore.resources.BookResource
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class RepositoryTest {
    @Test
    fun test_with_mock() {

        val booksObject =
            BookService.getMoshi().adapter(List<BookResource>()::class.java)
                .fromJson(JsonData.booksResponseBody)
        val responseMock = mock<Response<List<BookResource>>> {
            on { body() } doReturn booksObject
            on { code() } doReturn 200
        }
        val callMock = mock<Call<List<BookResource>>> {
            on { execute() } doReturn responseMock
        }
        val apiMock = mock<BookService> {
            on { getBooks() } doReturn callMock
        }

        val repository = BooksRepository(apiMock)

        val future = repository.getBooks()
        val books = future.get()
        assertThat(books.size, equalTo(5))
    }
}