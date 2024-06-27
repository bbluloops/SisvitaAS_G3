package com.example.proyectosisvitag3.data.model.response

import com.google.gson.annotations.SerializedName

data class EstudianteResponse(
    val apellidoEstudiante: String,
    val contraseñaEstudiante: String,
    val correoEstudiante: String,
    val idEstudiante: Int,
    val idUbigeo: String,
    val nombreEstudiante: String,
)