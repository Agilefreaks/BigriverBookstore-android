package com.agilefreaks.bigriverbookstore.data

import com.agilefreaks.bigriverbookstore.viewmodel.Book
import java.util.concurrent.Future

interface BooksDataSource {
    fun getBooks(): Future<List<Book>>
    fun getBook(bookId: Int): Future<Book>
}