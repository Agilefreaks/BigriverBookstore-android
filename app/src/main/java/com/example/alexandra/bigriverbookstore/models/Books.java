package com.example.alexandra.bigriverbookstore.models;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

import java.util.List;

@JsonApi(type = "books")
public class Books extends Resource {
    public String title;
    @Json(name = "date_published")
    public String datePublished;
    public String isbn;
    private HasOne<Authors> author;
    private HasMany<Photos> photos;

    public Authors getAuthor() {
        return author.get(getDocument());
    }

    public List<Photos> getAllPhotos() {
        return photos.get(getDocument());
    }
}
