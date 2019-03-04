package com.agilefreaks.bigriverbookstore.model;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "books")
public class Books extends Resource {
    @Json(name = "title")
    public String title;
}
