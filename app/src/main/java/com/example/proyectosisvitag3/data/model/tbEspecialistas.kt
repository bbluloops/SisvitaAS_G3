package com.example.proyectosisvitag3.ui.theme.data.model

import com.google.gson.annotations.SerializedName

data class tbEspecialistas (
    val idEspecialista: Int? = null,
    val nombreEspecialista: String? = null,
    val apellidoEspecialista: String? = null,
    val correoEspecialista: String? = null,
    @SerializedName("contraseñaEspecialista")
    val contrasenaEspecialista: String? = null,
)