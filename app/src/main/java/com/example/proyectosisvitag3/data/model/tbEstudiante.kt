package com.example.proyectosisvitag3.ui.theme.data.model

import com.google.gson.annotations.SerializedName

data class tbEstudiante (
    val idEstudiante: Int,
    val nombreEstudiante: String,
    val apellidoEstudiante: String,
    val correoEstudiante: String,
    @SerializedName("contraseñaEstudiante")
    val contrasenaEstudiante: String,
)