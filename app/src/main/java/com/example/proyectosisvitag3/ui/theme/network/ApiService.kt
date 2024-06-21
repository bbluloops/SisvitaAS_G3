package com.example.proyectosisvitag3.ui.theme.network

import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.data.model.UpdateRequest
import com.example.proyectosisvitag3.ui.theme.data.model.UpdateResponse
import com.example.proyectosisvitag3.ui.theme.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Response

interface ApiService {
    @POST("Estudiantes/v1/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @POST("/ResultadoTests/v1/update")
    suspend fun update(@Body updateRequest: UpdateRequest): Response<UpdateResponse>
}