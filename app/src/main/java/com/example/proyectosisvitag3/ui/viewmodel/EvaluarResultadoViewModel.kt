package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import kotlin.Pair
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.proyectosisvitag3.data.model.request.RecomendacionApoyoRequest
import com.example.proyectosisvitag3.data.model.response.OpcionResponse
import com.example.proyectosisvitag3.data.model.response.RespuestaResponse
import com.example.proyectosisvitag3.data.repository.OpcionRepository
import com.example.proyectosisvitag3.data.repository.RecomendacionApoyoRepository
import com.example.proyectosisvitag3.data.repository.RespuestasTestRepository
import com.example.proyectosisvitag3.data.repository.ResultadosTestRepository
import retrofit2.Response
import java.time.LocalDate

class EvaluarResultadoViewModel : ViewModel()  {

    private val repository = RespuestasTestRepository()
    private val tratamientoRepository= RecomendacionApoyoRepository()
    private val opcionRepository = OpcionRepository()
    private val _opciones = mutableStateOf(emptyList<OpcionResponse>())
    val opciones: State<List<OpcionResponse>> = _opciones
    private val _respuestasResponse = mutableStateOf(emptyList<RespuestaResponse>())
    val respuestasResponse:State<List<RespuestaResponse>> = _respuestasResponse
    private val _tratamiento = mutableStateOf(RecomendacionApoyoRequest("","","","","",""))
    val tratamiento:State<RecomendacionApoyoRequest> = _tratamiento

    fun loadOpciones(nombreTest: String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val response = opcionRepository.obtenerOpciones(nombreTest)
                _opciones.value = response
            }
            catch (e:Exception){
                Log.e("EvaluarResultado View Model",e.toString())
            }
        }
    }

    fun loadRespuestas(idResultado:String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.respuestasTest(mapOf(Pair("idResultado",idResultado.toInt())))
                _respuestasResponse.value = response
            }
            catch (e:Exception){
                Log.e("EvaluarResultado View model",e.toString())
            }
        }
    }

    fun sendTratamiento(idEspecialista:String,
                        idResultadoTest:String,
                        descripcionRecomendacionApoyo:String,
                        fechaInicioRecomendacionApoyo:String,
                        nivelAnsiedadRevision:String) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val request = RecomendacionApoyoRequest(idEspecialista,idResultadoTest,descripcionRecomendacionApoyo,
                    fechaInicioRecomendacionApoyo,fechaInicioRecomendacionApoyo,nivelAnsiedadRevision)
                val response = tratamientoRepository.insertarRecomendaciones(request)
            }
            catch(e:Exception){
                Log.e("EvaluarResultado View model",e.toString())
            }
        }
    }

}