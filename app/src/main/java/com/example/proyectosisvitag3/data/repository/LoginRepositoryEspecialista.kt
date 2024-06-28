package com.example.proyectosisvitag3.ui.theme.data.repository

import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequestEspecialista
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponseEspecialista
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class LoginRepositoryEspecialista {
    private val apiService = ApiInstance.apiInstance

    suspend fun login(loginRequestEspecialista: LoginRequestEspecialista): LoginResponseEspecialista {
        return apiService.loginEspecialista(loginRequestEspecialista)
    }
}