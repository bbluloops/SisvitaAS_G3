package com.example.proyectosisvitag3.ui.theme.data.repository

import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance
import retrofit2.Response

class LoginRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return apiService.login(loginRequest)
    }
}