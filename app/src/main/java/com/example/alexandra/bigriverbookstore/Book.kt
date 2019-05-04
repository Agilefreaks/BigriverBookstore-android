package com.example.alexandra.bigriverbookstore

import com.example.alexandra.bigriverbookstore.javaModels.Books

data class Book(val name: String, val author: String, val picturePath: String) {
    companion object {
         fun from(book: Books):Book{
             val name= book.title
             val author= book.author.name
             val picturePath = book.photos.first().uri

            return Book(name, author, picturePath)
        }
    }
}