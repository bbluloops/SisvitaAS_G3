package com.example.proyectosisvitag3.ui.theme.network

import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.data.model.*
import kotlin.collections.*
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/Estudiantes/v1/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("/Tests/v1/preguntas")
    suspend fun preguntas(@Body idTest: Map<String,Int>) : Map<String,Set<PreguntasResponse>>
    @POST("/Tests/v1/respuesta")
    suspend fun respuesta(@Body respuestaRequest: RespuestaRequest) : ResultadoResponse

    @POST("/Especialistas/v1/login")
    suspend fun loginEspecialista(@Body loginRequestEspecialista: LoginRequestEspecialista): LoginResponseEspecialista
}