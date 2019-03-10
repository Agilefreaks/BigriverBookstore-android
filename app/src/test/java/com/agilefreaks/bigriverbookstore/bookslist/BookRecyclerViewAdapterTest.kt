package com.agilefreaks.bigriverbookstore.bookslist

import com.agilefreaks.bigriverbookstore.viewmodel.Book
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class BookRecyclerViewAdapterTest {

    private val book = Book("1", "Harap Alb", "Creanga", null)

    @Test
    fun getItemCount() {
        val adapter = BookRecyclerViewAdapter(listOf(book))
        assertThat(adapter.itemCount, equalTo(1))
    }
}