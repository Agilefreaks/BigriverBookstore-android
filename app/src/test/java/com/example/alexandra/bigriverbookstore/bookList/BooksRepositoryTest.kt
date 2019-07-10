package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.AuthorResource
import com.example.alexandra.bigriverbookstore.resources.BookResource
import com.example.alexandra.bigriverbookstore.resources.PhotoResource
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import moe.banana.jsonapi2.HasMany
import moe.banana.jsonapi2.HasOne
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

class BooksRepositoryTest {
    @Test
    fun `should check if a list of books is returned`() {
        //given
        val bookResourceMock = listOf(BookResource().apply {
            photos = HasMany()
            allPhotos.add(0, PhotoResource())
            authors = HasOne(AuthorResource())
            title = " Android Developer"
        })

        val executor = mock<ExecutorService>()

        val apiMock = mock<BookService>()

        val response = Response.success(bookResourceMock)

        val mockCall = mock<Call<List<BookResource>>> {
            on { execute() } doReturn response
        }

        whenever(apiMock.getBooks()).thenReturn(mockCall)

        val repository = BooksRepository(apiMock, executor)

        val future = repository.getBooks()
        executor.awaitTermination(4, TimeUnit.SECONDS)
        val books = future.get()

        //assert
        assertThat(books.size, equalTo(5))

    }
}