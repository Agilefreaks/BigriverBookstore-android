package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.AuthorResource
import com.example.alexandra.bigriverbookstore.resources.BookResource
import com.example.alexandra.bigriverbookstore.resources.PhotoResource
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import moe.banana.jsonapi2.ArrayDocument
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.HasOne
import moe.banana.jsonapi2.ObjectDocument
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class BooksRepositoryTest {
    @Test
    fun `should get books`() {
        //given
        val document = ArrayDocument<BookResource>()
        val bookResource = BookResource().apply {
            photos = HasMany()
            authors = HasOne()
            allPhotos.add(0, PhotoResource())
            authors.set("authors", "0")
            title = " Android Developer"
        }
        document.add(bookResource)
        val authorResource = AuthorResource().apply { id = "0"; name = "Ionica" }
        document.addInclude(authorResource)

        val bookServiceMock = mock<BookService>()
        val response = Response.success(document.toList())

        val mockCall = mock<Call<List<BookResource>>> {
            on { execute() } doReturn response
        }

        whenever(bookServiceMock.getBooks()).thenReturn(mockCall)

        val repository = BooksRepository(bookServiceMock)

        val future = repository.getBooks()

        val books = future.get()
        //assert
        assertThat(books.size, equalTo(1))
    }
}