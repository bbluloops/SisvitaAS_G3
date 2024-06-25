package com.example.proyectosisvitag3.ui.theme.data.model

import com.example.proyectosisvitag3.data.model.response.LoginData

data class LoginResponse(
    val data: LoginData?,
    val msg: String,
    val success: Boolean
)