package com.jesusrojo.functionalprograming.gson

import com.google.gson.Gson
// NEEDS     implementation 'com.google.code.gson:gson:2.8.5'


fun main(args: Array<String>) {
    val gson = Gson()
    val demo = gson.fromJson(json, FakeDTO::class.java)
    val demo2 = gson.fromJson(json2, FakeDTO2::class.java)
    println(demo)
    println(demo2)
//FakeDTO(id=1, age=23, checked=true, numbers=[33, 34], colors=[Red, Blue])
//FakeDTO2(id=1, age=23, user=User(user_id=7, user_name=James))
//Ahora copiando esta línea y creamos el fake object a partir de aquí
//Los Strings hay que rodearlos con ""
}

data class FakeDTO(
    val id: Int,
    val age: String,
    val checked: Boolean,
    val numbers: List<Int>,
    val colors: List<String>,
)

data class FakeDTO2(
    val id: Int,
    val age: String,
    val user: User,
)

data class User(
    val user_id: Int,
    val user_name: String,
)

val json2 = """
    {
        "id": 1,
        "age": "23",
        "user" : {
            "user_id" : 007,
            "user_name": "James"
            }
    }
    """.trimMargin()

val json = """
    {
        "id": 1,
        "age": "23",
        "checked" : true,
        "numbers" : [33, 34],
        "colors" : ["Red","Blue"]
    }
    """.trimMargin()