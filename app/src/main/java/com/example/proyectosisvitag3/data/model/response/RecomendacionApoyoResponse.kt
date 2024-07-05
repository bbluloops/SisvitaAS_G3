package com.example.proyectosisvitag3.data.model.response

import com.example.proyectosisvitag3.data.model.request.RecomendacionApoyoRequest

data class RecomendacionApoyoResponse (
    val status_code:String,
    val msg:String,
    val data:RecomendacionApoyoRequest
)