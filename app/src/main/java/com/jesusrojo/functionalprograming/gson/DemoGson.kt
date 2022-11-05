package com.jesusrojo.functionalprograming.gson//package com.jesusrojo.functionalprograming.ui.main
//
//import com.google.gson.Gson
//import java.io.FileReader
//
////https://www.bezkoder.com/kotlin-parse-json-gson/
//class DemoGson {
//}
//class Tutorial(val title: String, val author: String, val categories: List<String>
//) {
//    override fun toString(): String {
//        return "fakeTutorial() = " +
//                "Tutorial(" +
//                    "title: "$title", " +
//                    "author: $author, " +
//                    "categories: ${this.categories}" +
//                "]"
//    }
//}
//
//
//fun main(args: Array<String>) {
//    val json = """{
//        "title": "Kotlin Tutorial",
//        "author": "bezkoder",
//        "categories" : ["Kotlin","Basic"]
//        }""".trimMargin()
//    val gson = Gson()
//
//    val tutorial_1: Tutorial = gson.fromJson(json, Tutorial::class.java)
//    println("> From JSON String:\n" + tutorial_1)
//
////    val tutorial_2: Tutorial = gson.fromJson(FileReader("tutorial.json"), Tutorial::class.java)
////    /* tutorial.json
////    {
////        "title": "Kotlin Tutorial #2",
////        "author": "bezkoder",
////        "categories": [
////            "Kotlin",
////            "Basic"
////        ],
////        "dummy": "dummy text"
////    }
////    */
////    println("> From JSON File:\n" + tutorial_2)
//}