package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Patterns
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import kotlinx.coroutines.delay
import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequest
import com.example.proyectosisvitag3.ui.theme.data.model.LoginResponse
import com.example.proyectosisvitag3.ui.theme.data.model.tbEstudiante
import com.example.proyectosisvitag3.ui.theme.network.ApiInstance
import com.example.proyectosisvitag3.ui.theme.data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.proyectosisvitag3.data.model.response.EstudianteResponse
import com.example.proyectosisvitag3.domain.LoginUseCase
import com.example.proyectosisvitag3.ui.theme.data.model.LoginEspecialistaRequest
import com.example.proyectosisvitag3.ui.theme.data.model.tbEspecialistas
import com.example.proyectosisvitag3.ui.theme.data.repository.LoginEspecialistaRepository
import retrofit2.Response

class LoginViewModelEspecialista : ViewModel() {

    //private val loginUseCase = LoginUseCase()
    private val loginRepository = LoginEspecialistaRepository()

    private val _idEspecialista = mutableStateOf("")
    val idEspecialista: State<String> = _idEspecialista

    private val _correoState = mutableStateOf("")
    val correoState: State<String> = _correoState

    private val _contrasenaState = mutableStateOf("")
    val contrasenaState: State<String> = _contrasenaState

    private val _rememberMeState = mutableStateOf(false)
    val rememberMeState: State<Boolean> = _rememberMeState

    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _loginSuccess = mutableStateOf(false)
    val loginSuccess: State<Boolean> = _loginSuccess

    private val _showDialog = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog

    private val _dialogMessage = mutableStateOf("")
    val dialogMessage: State<String> = _dialogMessage

    private val _especialista = mutableStateOf<tbEspecialistas?>(null)
    val especialistas: State<tbEspecialistas?> = _especialista

    fun setEmail(email: String) {
        _correoState.value = email
    }

    fun setPassword(password: String) {
        _contrasenaState.value = password
    }

    fun setRememberMe(checked: Boolean) {
        _rememberMeState.value = checked
    }

    fun submitLoginForm() {
        login()
    }

    fun setDialogMessage(message: String) {
        _dialogMessage.value = message
        mostrarDialog()
    }

    fun mostrarDialog() {
        _showDialog.value = true
    }
    fun dismissDialog() {
        _showDialog.value = false
        _dialogMessage.value = ""
        _loginSuccess.value = false
    }

    // Función para iniciar sesión
    fun login() {
        Log.d("Login","se llama a la funcion login()")
        _isLoading.value = true
        Log.d("Login","Se inicia verificación")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Login","Inicia corutina")
            try {
                Log.d("Login","Se realiza la peticion")
                val loginRequest = LoginEspecialistaRequest(_correoState.value, _contrasenaState.value)
                //val response = loginUseCase.login(loginRequest)
                val response = loginRepository.login(loginRequest)
                Log.d("Login","peticion:"+response.toString())
                if (response.success && response.data != null) {
                    println("JSON recibido con éxito")
                    println(response.success)
                    println(response.msg)
                    println(response.data)

                    val rptaUsuario = response.data
                    _idEspecialista.value = response.data.idEspecialista.toString()
                    _especialista.value = tbEspecialistas(
                        idEspecialista = rptaUsuario.idEspecialista ?: 0,
                        nombreEspecialista = rptaUsuario.nombreEspecialista,
                        apellidoEspecialista = rptaUsuario.apellidoEspecialista,
                        correoEspecialista = rptaUsuario.correoEspecialista,
                        contrasenaEspecialista = rptaUsuario.contraseñaEspecialista
                    )
                    _loginSuccess.value = true

                } else {
                    _isError.value = true
                }
                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("Login","Error:"+e.toString())
                _isError.value = true
                _isLoading.value = false
            }
        }
    }
}