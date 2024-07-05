package com.example.proyectosisvitag3.data.repository

import com.example.proyectosisvitag3.data.model.request.RecomendacionApoyoRequest
import com.example.proyectosisvitag3.data.model.response.OpcionResponse
import com.example.proyectosisvitag3.data.model.response.RecomendacionApoyoResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class OpcionRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun obtenerOpciones(nombreTest:String) : List<OpcionResponse> {
        return apiService.obtenerOpciones(nombreTest);
    }
}