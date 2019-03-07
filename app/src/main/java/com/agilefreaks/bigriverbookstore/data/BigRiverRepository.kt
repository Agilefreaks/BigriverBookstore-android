package com.agilefreaks.bigriverbookstore.data

import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import java.util.concurrent.Executors
import java.util.concurrent.Future

class BigRiverRepository(private val api: Api) : BooksDataSource {

    override fun getBooks(): Future<List<Book>> {
        val executor = Executors.newSingleThreadExecutor()
        return executor.submit<List<Book>> {
            val response = api.getBooks().execute()
            val books = response.body()!!.toList()
            books.map { Book.from(it) }
        }
    }

    override fun getBook(bookId: Int): Future<Book> {
        val executor = Executors.newSingleThreadExecutor()
        return executor.submit<Book> {
            val response = api.getBook(bookId).execute()
            val book = response.body()!!.get()
            Book.from(book)
        }
    }
}