package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.*
import com.example.proyectosisvitag3.ui.theme.data.model.PreguntasResponse
import com.example.proyectosisvitag3.ui.theme.data.model.RespuestaRequest
import com.example.proyectosisvitag3.ui.theme.data.model.ResultadoResponse
import com.example.proyectosisvitag3.ui.theme.data.repository.PreguntasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CuestionarioViewModel : ViewModel() {

    private val _resultadoResponse = mutableStateOf(ResultadoResponse(0,"","",false))
    val resultadoResponse: State<ResultadoResponse> = _resultadoResponse
    private val repository = PreguntasRepository()

    private val _preguntas = mutableStateOf(emptyMap<String,Set<PreguntasResponse>>())
    val preguntas : State<Map<String,Set<PreguntasResponse>>> = _preguntas

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    fun loadPreguntas() {
        Log.d("Cuestionario", "Cargar preguntas")
        _isLoading.value = true // Initialize loading state

        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("Cuestionario", "en viewModelScope")
                val response = repository.preguntas(5)
                _preguntas.value = response
                Log.d("Cuestionario", "Preguntas cargadas: $_preguntas")
                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("Cuestionario scope", e.toString())
            }
        }

    }

    fun sendRespuesta(respuestas:Map<String,PreguntasResponse>,idTest:String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = RespuestaRequest(idTest.toInt(), respuestas)
                val result = repository.respuestas(request)
                _resultadoResponse.value=result
            } catch (e: Exception) {
                Log.e("SendRespuestas", e.toString())
            }
        }
    }
}

