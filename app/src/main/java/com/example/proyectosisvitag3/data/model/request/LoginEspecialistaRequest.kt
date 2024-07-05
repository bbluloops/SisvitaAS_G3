package com.example.proyectosisvitag3.ui.theme.data.model

import com.google.gson.annotations.SerializedName

data class LoginEspecialistaRequest(
    val correoEspecialista: String,
    @SerializedName("contraseñaEspecialista")
    val contrasenaEspecialista: String
)
