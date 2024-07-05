package com.example.proyectosisvitag3.data.model.response

import com.google.gson.annotations.SerializedName

data class EspecialistaResponse(
    val apellidoEspecialista: String,
    val contraseñaEspecialista: String,
    val correoEspecialista: String,
    val idEspecialista: Int,
    val nombreEspecialista: String,
)
