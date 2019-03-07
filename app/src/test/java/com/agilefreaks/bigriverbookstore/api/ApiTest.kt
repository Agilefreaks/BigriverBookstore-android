package com.agilefreaks.bigriverbookstore.api

import com.agilefreaks.bigriverbookstore.TestData
import okhttp3.mock.MediaTypes.MEDIATYPE_JSON
import okhttp3.mock.MockInterceptor
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.regex.Pattern

class ApiTest {
    @Test
    fun `getBooks() will return a list of books`() {
        val interceptor = MockInterceptor()
        interceptor.addRule()
            .get()
            .urlMatches(Pattern.compile(".*books\\?.+"))
            .respond(TestData.booksResponseBody, MEDIATYPE_JSON)

        val service = Api.newInstance(interceptor)

        val call = service.getBooks()
        val response = call.execute()
        val books = response.body()

        val firstBook = books?.first()
        MatcherAssert.assertThat(firstBook?.title, equalTo("Jast-Lockman"))
        assertEquals("Jast-Lockman", firstBook?.title)
        assertEquals("2007-03-25", firstBook?.datePublished)
        assertEquals("617532143", firstBook?.isbn)

        val author = firstBook?.author
        assertEquals("Paul", author?.name)

        val photos = firstBook?.photos
        val firstPhoto = photos?.first()
        assertEquals("Photo 921", firstPhoto?.title)
    }

    @Test
    fun `getBook(1) will return the book with id 1`() {

        val interceptor = MockInterceptor()
        interceptor.addRule()
            .get()
            .urlMatches(Pattern.compile(".*books/[0-9]+\\?.+"))
            .respond(TestData.book1ResponseBody, MEDIATYPE_JSON)

        val service = Api.newInstance(interceptor)

        val call = service.getBook(1)
        val response = call.execute()
        val books = response.body()

        val firstBook = books?.first()
        assertEquals("Jast-Lockman", firstBook?.title)
        assertEquals("2007-03-25", firstBook?.datePublished)
        assertEquals("617532143", firstBook?.isbn)

        val author = firstBook?.author
        assertEquals("Paul", author?.name)

        val photos = firstBook?.photos
        val firstPhoto = photos?.first()
        assertEquals("Photo 921", firstPhoto?.title)
    }

}

