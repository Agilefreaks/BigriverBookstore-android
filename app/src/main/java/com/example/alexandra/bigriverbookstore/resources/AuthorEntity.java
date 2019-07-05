package com.example.alexandra.bigriverbookstore.resources;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "authors")
public class AuthorEntity extends Resource {
    public String name;
}
