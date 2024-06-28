package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.*
import com.example.proyectosisvitag3.ui.theme.data.model.PreguntasResponse
import com.example.proyectosisvitag3.ui.theme.data.model.RespuestaRequest
import com.example.proyectosisvitag3.ui.theme.data.repository.PreguntasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CuestionarioViewModel : ViewModel() {

private val repository = PreguntasRepository()

private val _preguntas = mutableStateOf(emptyMap<String,Set<PreguntasResponse>>())
val preguntas : State<Map<String,Set<PreguntasResponse>>> = _preguntas

private val _isLoading = MutableLiveData<Boolean>()
val isLoading: LiveData<Boolean> = _isLoading

fun loadPreguntas() {
    Log.d("Cuestionario", "Cargar preguntas")
    _isLoading.value = true // Initialize loading state

    viewModelScope.launch(Dispatchers.IO) {
        try {
            Log.d("Cuestionario", "en viewModelScope")
            val response = repository.preguntas(5)
            _preguntas.value = response 
        } catch (e: Exception) {
            Log.e("Cuestionario scope", e.toString())
        } finally {
            _isLoading.postValue(false) // Ensure loading state is updated
        }
    }

}

fun sendRespuesta(respuestas:Map<String,PreguntasResponse>){
    viewModelScope.launch(Dispatchers.IO){
        try{
            val request = RespuestaRequest(5,respuestas)
            repository.respuestas(request)
        }catch(e:Exception){
            Log.e("SendRespuestas", e.toString())
        } finally {
        }
    }
}
}

