package com.agilefreaks.bigriverbookstore.viewmodel

import com.agilefreaks.bigriverbookstore.TestData
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.model.Books
import moe.banana.jsonapi2.Document
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test

class BookTest {

    private val book1 = Api.getMoshi()
        .adapter(Document<Books>()::class.java)
        .fromJson(TestData.book1ResponseBody)!!
        .get()

/*
FIXME can't mock because reasons

private val authorMock = mock<Authors> {
on { name } doReturn "Paul"
}
private val photosMock = mock<Photos> {
on { uri } doReturn "https://lorempixel.com/400/300/abstract/Faker/?50139"
}
private val bookMock = mock<Books> {
on { id } doReturn "1"
on { title } doReturn "Jast-Lockman"
on { getAuthor() } doReturn authorMock
on { getPhotos() } doReturn listOf(photosMock)
}
*/

    @Test
    fun `from(Books) should return a book with the correct book id`() {
        val book = Book.from(book1)
        Assert.assertThat(book.id, Matchers.equalTo("1"))
    }

    @Test
    fun `from(Books) should return a book with the correct book name`() {
        val book = Book.from(book1)
        Assert.assertThat(book.name, Matchers.equalTo("Jast-Lockman"))
    }

    @Test
    fun `from(Books) should return a book with the correct author name`() {
        val book = Book.from(book1)
        Assert.assertThat(book.author, Matchers.equalTo("Paul"))
    }

    @Test
    fun `from(Books) should return a book with the correct book cover link`() {
        val book = Book.from(book1)
        Assert.assertThat(book.cover, Matchers.equalTo("https://lorempixel.com/400/300/abstract/Faker/?50139"))
    }
}
