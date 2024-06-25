package com.example.proyectosisvitag3.domain

import androidx.navigation.compose.rememberNavController
import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.data.repository.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return repository.login(loginRequest)
    }
}