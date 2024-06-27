package com.example.proyectosisvitag3.ui.theme.data.model

import com.example.proyectosisvitag3.data.model.response.EstudianteResponse
import java.util.Objects

data class LoginResponse(
    val data: EstudianteResponse,
    val msg: String,
    val success: Boolean
)