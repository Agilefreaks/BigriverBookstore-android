package com.example.alexandra.bigriverbookstore

import com.example.alexandra.bigriverbookstore.javaModels.Books
import moe.banana.jsonapi2.Document
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class BooksRepository(
    private val api: ApiRequests,
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
) : BooksReturns {

    class ErrorException(error: Any?) : RuntimeException("Error: $error")

    override fun getBooks(): Future<List<Book>> {
        return executor.submit<List<Book>> {
            val response = api.getBooks().execute()
            val body = verifyResponse(response)
            val books = body.toList()
            books.map { Book.from(books) }
        }
    }

    private fun verifyResponse(response: Response<Document<Books>>): Document<Books> {
        val statusCode = response.code()
        if (statusCode != 200) {
            throw  ErrorException("Status code different fro 200. Error body: ${response.errorBody().toString()}")
        }
        return response.body()
            ?: throw ErrorException("Null body found. Error body: ${response.errorBody().toString()}")
    }
}