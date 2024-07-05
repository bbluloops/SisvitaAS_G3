package com.example.proyectosisvitag3.data.model.response

data class TestResponse (
    val data:List<TestData>,
    val msg: String,
    val status_code:String
)