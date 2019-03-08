package com.agilefreaks.bigriverbookstore

import org.intellij.lang.annotations.Language

class TestData {
    companion object {
        @Language("JSON")
        val booksResponseBody = "{\"meta\":{\"page\":1,\"resources_per_page\":5,\"total_resources\":6},\"data\":[{\"type\":\"books\",\"id\":\"1\",\"attributes\":{\"title\":\"Jast-Lockman\",\"date_published\":\"2007-03-25\",\"isbn\":617532143},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"16\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"15\"}]},\"photos\":{\"data\":[{\"type\":\"photos\",\"id\":\"151\"},{\"type\":\"photos\",\"id\":\"152\"}]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"27\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"47\"}]}},\"links\":{\"self\":\"\\/books\\/1\"}},{\"type\":\"books\",\"id\":\"2\",\"attributes\":{\"title\":\"Abernathy LLC\",\"date_published\":\"1978-05-13\",\"isbn\":2676749390},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"27\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"20\"}]},\"photos\":{\"data\":[]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"15\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"5\"}]}},\"links\":{\"self\":\"\\/books\\/2\"}},{\"type\":\"books\",\"id\":\"3\",\"attributes\":{\"title\":\"Wehner-Dare\",\"date_published\":\"1970-04-19\",\"isbn\":4294967295},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"2\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"45\"}]},\"photos\":{\"data\":[{\"type\":\"photos\",\"id\":\"153\"}]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"5\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"9\"}]}},\"links\":{\"self\":\"\\/books\\/3\"}},{\"type\":\"books\",\"id\":\"4\",\"attributes\":{\"title\":\"Runte LLC\",\"date_published\":\"1994-10-28\",\"isbn\":4294967295},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"7\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"36\"}]},\"photos\":{\"data\":[{\"type\":\"photos\",\"id\":\"154\"},{\"type\":\"photos\",\"id\":\"155\"}]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"32\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"18\"}]}},\"links\":{\"self\":\"\\/books\\/4\"}},{\"type\":\"books\",\"id\":\"5\",\"attributes\":{\"title\":\"Schamberger, Kunde and Fay\",\"date_published\":\"2010-07-01\",\"isbn\":4078914969},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"25\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"1\"}]},\"photos\":{\"data\":[]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"26\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"30\"}]}},\"links\":{\"self\":\"\\/books\\/5\"}}],\"included\":[{\"type\":\"authors\",\"id\":\"16\",\"attributes\":{\"name\":\"Paul\",\"birthplace\":\"Moldova\",\"date_of_birth\":\"1979-03-28\",\"date_of_death\":\"1988-07-24\"}},{\"type\":\"chapters\",\"id\":\"15\",\"attributes\":{\"title\":\"Chapter 182\",\"ordering\":3279340}},{\"type\":\"photos\",\"id\":\"151\",\"attributes\":{\"title\":\"Photo 921\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?50139\"}},{\"type\":\"photos\",\"id\":\"152\",\"attributes\":{\"title\":\"Photo 497\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?55702\"}},{\"type\":\"series\",\"id\":\"27\",\"attributes\":{\"title\":\"Series 1783695\"}},{\"type\":\"stores\",\"id\":\"47\",\"attributes\":{\"name\":\"Store 730\",\"address\":\"61503 Tiara Squares\",\"created_by\":1}},{\"type\":\"authors\",\"id\":\"27\",\"attributes\":{\"name\":\"efwefwef\",\"birthplace\":\"Kiribati\",\"date_of_birth\":\"1983-10-10\",\"date_of_death\":\"1984-10-31\"}},{\"type\":\"chapters\",\"id\":\"20\",\"attributes\":{\"title\":\"Chapter 609\",\"ordering\":1807605}},{\"type\":\"series\",\"id\":\"15\",\"attributes\":{\"title\":\"Series 7482689\"}},{\"type\":\"stores\",\"id\":\"5\",\"attributes\":{\"name\":\"Store 938\",\"address\":\"3650 Connie Manor Apt. 956\",\"created_by\":1}},{\"type\":\"authors\",\"id\":\"2\",\"attributes\":{\"name\":\"testststst\",\"birthplace\":\"Malaysia\",\"date_of_birth\":\"1996-01-29\",\"date_of_death\":\"1983-06-19\"}},{\"type\":\"chapters\",\"id\":\"45\",\"attributes\":{\"title\":\"Chapter 260\",\"ordering\":4402645}},{\"type\":\"photos\",\"id\":\"153\",\"attributes\":{\"title\":\"Photo 874\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?34638\"}},{\"type\":\"series\",\"id\":\"5\",\"attributes\":{\"title\":\"Series 0397823\"}},{\"type\":\"stores\",\"id\":\"9\",\"attributes\":{\"name\":\"Store 515\",\"address\":\"237 Gianni Run\",\"created_by\":1}},{\"type\":\"authors\",\"id\":\"7\",\"attributes\":{\"name\":\"Miss Noemy Paucek DVM\",\"birthplace\":\"Senegal\",\"date_of_birth\":\"1990-04-02\",\"date_of_death\":\"1988-10-14\"}},{\"type\":\"chapters\",\"id\":\"36\",\"attributes\":{\"title\":\"Chapter 218\",\"ordering\":6821464}},{\"type\":\"photos\",\"id\":\"154\",\"attributes\":{\"title\":\"Photo 391\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?77011\"}},{\"type\":\"photos\",\"id\":\"155\",\"attributes\":{\"title\":\"Photo 385\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?59832\"}},{\"type\":\"series\",\"id\":\"32\",\"attributes\":{\"title\":\"Series 7532629\"}},{\"type\":\"stores\",\"id\":\"18\",\"attributes\":{\"name\":\"Store 603\",\"address\":\"420 Quigley Lakes\",\"created_by\":1}},{\"type\":\"authors\",\"id\":\"25\",\"attributes\":{\"name\":\"Dr. Jordan Homenick I\",\"birthplace\":\"France\",\"date_of_birth\":\"1973-12-15\",\"date_of_death\":\"2018-07-23\"}},{\"type\":\"chapters\",\"id\":\"1\",\"attributes\":{\"title\":\"Chapter 771\",\"ordering\":3247140}},{\"type\":\"series\",\"id\":\"26\",\"attributes\":{\"title\":\"Series 3148970\"}},{\"type\":\"stores\",\"id\":\"30\",\"attributes\":{\"name\":\"Store 398\",\"address\":\"91122 Antwon Rue Apt. 361\",\"created_by\":3}}]}"

        @Language("JSON")
        val book1ResponseBody = "{\"meta\":[],\"data\":{\"type\":\"books\",\"id\":\"1\",\"attributes\":{\"title\":\"Jast-Lockman\",\"date_published\":\"2007-03-25\",\"isbn\":617532143},\"relationships\":{\"author\":{\"data\":{\"type\":\"authors\",\"id\":\"16\"}},\"chapters\":{\"data\":[{\"type\":\"chapters\",\"id\":\"15\"}]},\"photos\":{\"data\":[{\"type\":\"photos\",\"id\":\"151\"},{\"type\":\"photos\",\"id\":\"152\"}]},\"series\":{\"data\":{\"type\":\"series\",\"id\":\"27\"}},\"stores\":{\"data\":[{\"type\":\"stores\",\"id\":\"47\"}]}},\"links\":{\"self\":\"\\/books\\/1\"}},\"included\":[{\"type\":\"authors\",\"id\":\"16\",\"attributes\":{\"name\":\"Paul\",\"birthplace\":\"Moldova\",\"date_of_birth\":\"1979-03-28\",\"date_of_death\":\"1988-07-24\"}},{\"type\":\"chapters\",\"id\":\"15\",\"attributes\":{\"title\":\"Chapter 182\",\"ordering\":3279340}},{\"type\":\"photos\",\"id\":\"151\",\"attributes\":{\"title\":\"Photo 921\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?50139\"}},{\"type\":\"photos\",\"id\":\"152\",\"attributes\":{\"title\":\"Photo 497\",\"uri\":\"https:\\/\\/lorempixel.com\\/400\\/300\\/abstract\\/Faker\\/?55702\"}},{\"type\":\"series\",\"id\":\"27\",\"attributes\":{\"title\":\"Series 1783695\"}},{\"type\":\"stores\",\"id\":\"47\",\"attributes\":{\"name\":\"Store 730\",\"address\":\"61503 Tiara Squares\",\"created_by\":1}}]}"

        @Language("JSON")
        val book0Error = "{\"errors\":[{\"code\":\"404\",\"title\":\"Resource `0` not found.\"}]}"
    }
}