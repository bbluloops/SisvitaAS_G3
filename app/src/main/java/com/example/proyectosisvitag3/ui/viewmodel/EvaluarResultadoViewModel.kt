package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.proyectosisvitag3.ui.theme.data.model.UpdateRequest
import com.example.proyectosisvitag3.ui.theme.data.repository.UpdateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.proyectosisvitag3.ui.theme.data.model.UpdateResponse
import retrofit2.Response

class EvaluarResultadoViewModel : ViewModel()  {
/*
    private val repository = UpdateRepository()

    private val _nivelAnsiedad = MutableLiveData<String>()
    val nivelAnsiedad: LiveData<String> = _nivelAnsiedad

    private val _observaciones = MutableLiveData<String>()
    val observaciones: LiveData<String> = _observaciones

    private val _updateEnable = MutableLiveData<Boolean>()
    val updateEnable: LiveData<Boolean> = _updateEnable

    private val _updateSuccess = MutableLiveData<Boolean>()
    val updateSuccess: LiveData<Boolean> = _updateSuccess

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onUpdateChanged(nivelAnsiedad: String, observaciones: String) {
        _nivelAnsiedad.value = nivelAnsiedad
        _observaciones.value = observaciones
        _updateEnable.value = (nivelAnsiedad.length > 0) && (observaciones.length > 0)
    }

    fun onUpdateSelected() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val updateRequest = UpdateRequest(_nivelAnsiedad.value ?: "", _observaciones.value ?: "")
                val response: Response<UpdateResponse> = repository.update(updateRequest)
                if (response.isSuccessful && response.body() != null) {
                    val updateResponse = response.body()
                    if (updateResponse!!.success) {
                        _updateSuccess.postValue(true)
                    } else {
                        _isError.postValue(true)
                    }
                } else {
                    _isError.postValue(true)
                }
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isError.postValue(true)
                _isLoading.postValue(false)
            }
        }
    }*/
}