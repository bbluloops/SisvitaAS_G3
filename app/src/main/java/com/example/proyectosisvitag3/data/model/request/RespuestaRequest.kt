package com.example.proyectosisvitag3.ui.theme.data.model

data class RespuestaRequest(
    val idTest:Int,
    val respuestas: Map<String,PreguntasResponse>
)
