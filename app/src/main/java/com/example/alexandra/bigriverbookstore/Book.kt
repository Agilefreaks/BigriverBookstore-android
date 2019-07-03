package com.example.alexandra.bigriverbookstore

import com.example.alexandra.bigriverbookstore.resources.Book

data class Book(val name: String, val author: String, val picturePath: String) {
    companion object {
        fun from(book: Book): Book {
            val name = book.title
            val author =  book.author.name
            val picturePath = book.allPhotos.first().uri

            return Book(name, author, picturePath)
        }
    }
}