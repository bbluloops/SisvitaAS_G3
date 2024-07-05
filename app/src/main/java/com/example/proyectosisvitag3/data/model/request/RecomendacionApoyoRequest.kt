package com.example.proyectosisvitag3.data.model.request

data class RecomendacionApoyoRequest (
    val idEspecialista:String,
    val idResultadoTest:String,
    val descripcionRecomendacionApoyo:String,
    val fechaInicioRecomendacionApoyo:String,
    val fechaFinRecomendacionApoyo:String,
    val nivelAnsiedadRevision:String
)