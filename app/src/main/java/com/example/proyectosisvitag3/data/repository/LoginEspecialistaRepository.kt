package com.example.proyectosisvitag3.ui.theme.data.repository

import com.example.proyectosisvitag3.ui.theme.data.model.LoginEspecialistaRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginEspecialistaResponse
import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance
import retrofit2.Response

class LoginEspecialistaRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun login(loginRequest: LoginEspecialistaRequest): LoginEspecialistaResponse {
        return apiService.loginEspecialista(loginRequest)
    }
}