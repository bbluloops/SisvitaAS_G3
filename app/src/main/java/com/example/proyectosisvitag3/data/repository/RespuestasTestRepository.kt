package com.example.proyectosisvitag3.data.repository

import com.example.proyectosisvitag3.data.model.response.RespuestaResponse
import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance

class RespuestasTestRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun respuestasTest(idResultado: Map<String,Int>) : List<RespuestaResponse>{
        return apiService.respuestasTest(idResultado);
    }
}