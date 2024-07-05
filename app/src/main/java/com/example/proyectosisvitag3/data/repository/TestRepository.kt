package com.example.proyectosisvitag3.data.repository

import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.data.model.response.TestResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class TestRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun obtenerTest() : TestResponse{
        return apiService.obtenerTest();
    }
}