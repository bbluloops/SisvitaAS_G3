package com.example.proyectosisvitag3.ui.theme.data.model

import com.example.proyectosisvitag3.data.model.response.LoginData
import java.util.Objects

data class LoginResponse(
    val data: LoginRequest?,
    val msg: String,
    val success: Boolean
)