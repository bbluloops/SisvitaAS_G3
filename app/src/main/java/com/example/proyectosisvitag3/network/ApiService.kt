package com.example.proyectosisvitag3.ui.theme.network

import com.example.proyectosisvitag3.data.model.request.RecomendacionApoyoRequest
import com.example.proyectosisvitag3.data.model.response.OpcionResponse
import com.example.proyectosisvitag3.data.model.response.RecomendacionApoyoResponse
import com.example.proyectosisvitag3.data.model.response.RespuestaResponse
import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.data.model.response.TestResponse
import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.data.model.*
import com.example.proyectosisvitag3.ui.theme.data.repository.LoginEspecialistaRepository
import kotlin.collections.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/Estudiantes/v1/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
    @POST("/Especialistas/v1/login")
    suspend fun loginEspecialista(@Body loginEspecialistaRequest: LoginEspecialistaRequest) : LoginEspecialistaResponse

    @POST("/Tests/v1/preguntas")
    suspend fun preguntas(@Body idTest: Map<String,Int>) : Map<String,Set<PreguntasResponse>>
    @POST("/Tests/v1/respuesta")
    suspend fun respuesta(@Body respuestaRequest: RespuestaRequest) : ResultadoResponse

    @GET("/ResultadoTests/v1/obtener-resultados-detallados")
    suspend fun resultadosTest() : List<ResultadoDetallado>

    @POST("/RespuestasTests/v1/obtener-por-resultado")
    suspend fun respuestasTest(@Body idResultado:Map<String,Int>) : List<RespuestaResponse>

    @POST("/RecomendacionesApoyos/v1/insert")
    suspend fun insertarRecomendaciones(@Body request: RecomendacionApoyoRequest) : RecomendacionApoyoResponse

    @GET("/RangosPuntajes/v1/obtener-nombre")
    suspend fun obtenerOpciones(@Query("nombreTest") nombreTest:String) : List<OpcionResponse>

    @GET("/Tests/v1/listar")
    suspend fun obtenerTest() : TestResponse
}