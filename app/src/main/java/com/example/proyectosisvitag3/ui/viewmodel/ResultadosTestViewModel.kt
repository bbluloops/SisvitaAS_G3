package com.example.proyectosisvitag3.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.*
import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.data.repository.ResultadosTestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ResultadosTestViewModel : ViewModel() {
    private val repository = ResultadosTestRepository()
    private val _resultadosResponse = mutableStateOf(emptyList<ResultadoDetallado>())
    val resultadoResponse:State<List<ResultadoDetallado>> = _resultadosResponse

    fun loadResultados(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.resultadosTest()
                _resultadosResponse.value= response
            }
            catch (e:Exception){
                Log.e("ResultadosTestViewModel",e.toString())
            }
        }
    }
}