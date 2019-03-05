package com.agilefreaks.bigriverbookstore.model;

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
    public String datePublished; //LocalDate requires explicit JsonAdapter to be registered
    public String isbn;
    private HasOne<Authors> author;
    private HasMany<Photos> photos;

    public Authors getAuthor() {
        return author.get(getContext());
    }

    public List<Photos> getPhotos() {
        return photos.get(getContext());
    }
}
