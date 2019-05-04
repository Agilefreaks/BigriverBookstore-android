package com.example.alexandra.bigriverbookstore

import java.util.concurrent.Future

interface BooksReturns {
    fun getBooks(): Future<List<Book>>
}