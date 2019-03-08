package com.agilefreaks.bigriverbookstore.model;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "authors")
public class Authors extends Resource {

    public String name;
    public String birthplace;

    @Json(name = "date_of_birth")
    public String dateOfBirth;

    @Json(name = "date_of_death")
    public String dateOfDeath;
}
