package com.example.alexandra.bigriverbookstore.bookList

import java.util.concurrent.Future

interface BookInterface {
    fun getBooks(): Future<List<Book>>
}