package com.example.proyectosisvitag3.data.model.response

data class OpcionResponse (
    val idRangoTest: Int,
    val idTest: Int,
    val interpretacionPuntaje: String,
    val maximoPuntaje: Int,
    val minimoPuntaje: Int
)