package com.example.proyectosisvitag3.ui.theme.data.model

import com.example.proyectosisvitag3.data.model.response.EspecialistaResponse
import com.example.proyectosisvitag3.data.model.response.EstudianteResponse
import java.util.Objects

data class LoginEspecialistaResponse(
    val data: EspecialistaResponse,
    val msg: String,
    val success: Boolean
)