package com.agilefreaks.bigriverbookstore.data

import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.model.Books
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import moe.banana.jsonapi2.Document
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class BigRiverRepository(private val api: Api, private val executor: ExecutorService) : BooksDataSource {

    class UnexpectedStatusCodeException(code: Int): RuntimeException("Unexpected status code: $code")
    class EmptyResponseBodyException(error: Any?) : RuntimeException("Response body was null. Error: $error")

    override fun getBooks(): Future<List<Book>> {
        return executor.submit<List<Book>> {
            val response = api.getBooks().execute()
            val body = verifyResponse(response)
            val books = body.toList()
            books.map { Book.from(it) }
        }
    }

    override fun getBook(bookId: Int): Future<Book> {
        return executor.submit<Book> {
            val response = api.getBook(bookId).execute()
            val body = verifyResponse(response)
            val book = body.get()
            Book.from(book)
        }
    }

    private fun verifyResponse(response: Response<Document<Books>>): Document<Books> {
        val status = response.code()
        if (status !in 200..299) {
            throw UnexpectedStatusCodeException(status)
        }

        return response.body()
            ?: throw EmptyResponseBodyException("Null body found. Error body: ${response.errorBody().toString()}")
    }
}
