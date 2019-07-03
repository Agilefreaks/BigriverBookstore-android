package com.example.alexandra.bigriverbookstore.resources;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

import java.util.List;

@JsonApi(type = "books")
public class Book extends Resource {
    public String title;
    @Json(name = "date_published")
    public String datePublished;
    public String isbn;
    private HasOne<Author> author;
    private HasMany<Photo> photos;

    public Author getAuthor() {
        return author.get(getDocument());
    }

    public List<Photo> getAllPhotos() {
        return photos.get(getDocument());
    }
}
