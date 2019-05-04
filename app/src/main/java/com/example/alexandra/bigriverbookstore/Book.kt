package com.example.alexandra.bigriverbookstore

data class Book(val authorName: String, val bookTitle: String, val picturePath: String) {
    companion object {
        fun from(book: Book): Book {
            val authorName = book.authorName
            val bookTitle = book.bookTitle
            val picturePath = book.picturePath
            return Book(authorName, bookTitle, picturePath)
        }
    }
}

//public class Book(val name: String, val title: String, val picturePath: String)

