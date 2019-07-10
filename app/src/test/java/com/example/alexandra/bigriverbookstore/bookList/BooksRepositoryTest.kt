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
import okhttp3.mock.get
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

class BooksRepositoryTest {
    @Test
    fun `should get books`() {
        //given
        val bookResourceMock = listOf(BookResource().apply {
            photos = HasMany()
            allPhotos.add(0, PhotoResource())
            authors = HasOne(AuthorResource())
            title = " Android Developer"
        })

        val apiMock = mock<BookService>()

        val response = Response.success(bookResourceMock)

        val mockCall = mock<Call<List<BookResource>>> {
            on { execute() } doReturn response
        }

        whenever(apiMock.getBooks()).thenReturn(mockCall)

        val repository = BooksRepository(apiMock)

        val future = repository.getBooks()
        Thread.sleep(5000)
        val books = future.get()

        //assert
        assertThat(books.size, equalTo(5))

    }
}