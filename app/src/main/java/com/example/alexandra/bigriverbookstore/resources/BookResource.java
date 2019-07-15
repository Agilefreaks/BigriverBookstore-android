package com.example.alexandra.bigriverbookstore.resources;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

import java.util.List;

@JsonApi(type = "books")
public class BookResource extends Resource {
    public String title;
    @Json(name = "date_published")
    public String datePublished;
    public String isbn;
    public HasOne<AuthorResource> authors;
    public HasMany<PhotoResource> photos;

    public AuthorResource getAuthor() {
        return authors.get(getDocument());
    }

    public List<PhotoResource> getAllPhotos() {
        return photos.get(getDocument());
    }
}
