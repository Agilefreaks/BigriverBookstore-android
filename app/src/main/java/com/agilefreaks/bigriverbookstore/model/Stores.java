package com.agilefreaks.bigriverbookstore.model;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "stores")
public class Stores extends Resource {
    public String name;
    public String address;

    @Json(name = "created_by")
    public Integer createdBy;
}
