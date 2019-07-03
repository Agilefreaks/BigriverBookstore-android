package com.example.alexandra.bigriverbookstore.models;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "authors")
public class Authors extends Resource {
    public String name;
}
