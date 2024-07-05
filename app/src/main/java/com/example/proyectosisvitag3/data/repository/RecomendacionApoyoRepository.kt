package com.example.proyectosisvitag3.data.repository

import com.example.proyectosisvitag3.data.model.request.RecomendacionApoyoRequest
import com.example.proyectosisvitag3.data.model.response.RecomendacionApoyoResponse
import com.example.proyectosisvitag3.data.model.response.RespuestaResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class RecomendacionApoyoRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun insertarRecomendaciones(request:RecomendacionApoyoRequest) : RecomendacionApoyoResponse {
        return apiService.insertarRecomendaciones(request);
    }
}