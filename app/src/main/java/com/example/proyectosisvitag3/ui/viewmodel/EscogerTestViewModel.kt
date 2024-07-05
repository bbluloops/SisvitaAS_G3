package com.example.proyectosisvitag3.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectosisvitag3.data.model.response.TestData
import com.example.proyectosisvitag3.data.repository.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EscogerTestViewModel: ViewModel() {
    private val repository = TestRepository()
    private val _tests = mutableStateOf(emptyList<TestData>())
    val tests: State<List<TestData>> = _tests

    fun loadTest(){
        viewModelScope.launch (Dispatchers.IO){
            try{
                val response = repository.obtenerTest()
                _tests.value = response.data
            }catch (e:Exception){
                Log.e("EscogerTestViewModel",e.toString())
            }
        }
    }
}