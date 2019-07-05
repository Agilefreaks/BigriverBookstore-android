package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.BookEntity
import com.squareup.moshi.JsonDataException
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class BooksRepository(
    private val api: GetBooksRequest,
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
) : BookInterface {

    class ErrorException(error: Any?) : RuntimeException("Error: $error")

    override fun getBooks(): Future<List<Book>> {
        return executor.submit<List<Book>> {
            try {
                val response = api.getBooks().execute()
                val body = verifyResponse(response)
                body.map { book ->
                    Book.from(book)
                }
            } catch (e: JsonDataException) {
                throw JsonDataException("Error")
            }
        }
    }

    private fun verifyResponse(response: Response<List<BookEntity>>): List<BookEntity> {
        val statusCode = response.code()
        if (statusCode != 200) {
            throw  ErrorException("Status code different fro 200. Error body: ${response.errorBody().toString()}")
        }
        return response.body()
            ?: throw ErrorException("Null body found. Error body: ${response.errorBody().toString()}")
    }
}