package com.example.proyectosisvitag3.ui.theme.data.model

import java.util.Objects

data class ResultadoResponse(
    val puntajeResultadoTest: Int,
    val infoResultado: String,
    val fechaResultado: String,
    val revisado: Boolean
)
