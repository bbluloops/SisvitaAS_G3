package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.proyectosisvitag3.ui.theme.data.model.LoginRequestEspecialista
import com.example.proyectosisvitag3.ui.theme.data.model.tbEspecialistas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.proyectosisvitag3.ui.theme.data.repository.LoginRepositoryEspecialista

class LoginEspecialistaViewModel : ViewModel() {

    //private val loginUseCase = LoginUseCase()
    private val loginRepositoryEspecialista = LoginRepositoryEspecialista()

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
    val estudiante: State<tbEspecialistas?> = _especialista

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
                val loginRequestEspecialista = LoginRequestEspecialista(_correoState.value, _contrasenaState.value)
                //val response = loginUseCase.login(loginRequest)
                val response = loginRepositoryEspecialista.login(loginRequestEspecialista)
                Log.d("Login","peticion:"+response.toString())
                if (response.success && response.data != null) {
                    println("JSON recibido con éxito")
                    println(response.success)
                    println(response.msg)
                    println(response.data)

                    val rptaEspecialista = response.data
                    _especialista.value = tbEspecialistas(
                        idEspecialista = rptaEspecialista.idEspecialista ?: 0,
                        nombreEspecialista = rptaEspecialista.nombreEspecialista,
                        apellidoEspecialista = rptaEspecialista.apellidoEspecialista,
                        correoEspecialista = rptaEspecialista.correoEspecialista,
                        contrasenaEspecialista = rptaEspecialista.contraseñaEspecialista
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