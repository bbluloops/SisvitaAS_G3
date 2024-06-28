package com.example.proyectosisvitag3.ui.theme.data.repository

import com.example.proyectosisvitag3.ui.theme.data.model.PreguntasResponse
import com.example.proyectosisvitag3.ui.theme.data.model.RespuestaRequest
import com.example.proyectosisvitag3.ui.theme.data.model.ResultadoResponse
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance
import retrofit2.Response
import kotlin.collections.*

class PreguntasRepository {
    private val apiService = ApiInstance.apiInstance

    suspend fun preguntas(idTest: Int): Map<String,Set<PreguntasResponse>> {
        return apiService.preguntas(mapOf("idTest" to idTest))
    }

    suspend fun respuestas(request:RespuestaRequest): ResultadoResponse {
        return apiService.respuesta(request)
    }
}