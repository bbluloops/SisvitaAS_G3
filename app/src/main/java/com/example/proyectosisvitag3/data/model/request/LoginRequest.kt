package com.example.proyectosisvitag3.ui.theme.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val correoEstudiante: String,
    @SerializedName("contraseñaEstudiante")
    val contrasenaEstudiante: String
)