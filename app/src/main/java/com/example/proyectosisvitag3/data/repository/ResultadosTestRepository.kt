package com.example.proyectosisvitag3.data.repository

import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.ui.theme.data.model.LoginEspecialistaRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginEspecialistaResponse
import com.example.proyectosisvitag3.ui.theme.data.model.ResultadoResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class ResultadosTestRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun resultadosTest() : List<ResultadoDetallado>{
        return apiService.resultadosTest();
    }
}