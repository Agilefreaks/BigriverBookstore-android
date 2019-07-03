package com.example.alexandra.bigriverbookstore.resources;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

import java.util.List;

@JsonApi(type = "books")
public class BookEntity extends Resource {
    public String title;
    @Json(name = "date_published")
    public String datePublished;
    public String isbn;
    private HasOne<AuthorEntity> author;
    private HasMany<PhotoEntity> photos;

    public AuthorEntity getAuthor() {
        return author.get(getDocument());
    }

    public List<PhotoEntity> getAllPhotos() {
        return photos.get(getDocument());
    }
}
