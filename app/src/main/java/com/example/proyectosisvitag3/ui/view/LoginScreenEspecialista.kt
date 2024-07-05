package com.example.proyectosisvitag3.ui.theme.iu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyectosisvitag3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreenEspecialista(
    navController: NavHostController,
    loginViewModel: LoginViewModelEspecialista = viewModel()
) {
    val showDialog by loginViewModel.showDialog
    val dialogMessage by loginViewModel.dialogMessage

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LoginEspecialista(loginViewModel,navController)
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { loginViewModel.dismissDialog() },
            title = {
                Text(text = "Notificación")
            },
            text = {
                Text(text = dialogMessage)
            },
            confirmButton = {
                Button(
                    onClick = { loginViewModel.dismissDialog() }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginEspecialista(
    loginViewModel: LoginViewModelEspecialista,
    navController: NavHostController
) {
    val idEspecialista: String by loginViewModel.idEspecialista
    val correo: String by loginViewModel.correoState
    val contrasena: String by loginViewModel.contrasenaState
    val isError: Boolean by loginViewModel.isError
    val loginSuccess: Boolean by loginViewModel.loginSuccess
    val showDialog: Boolean by loginViewModel.showDialog
    val dialogMessage:String by loginViewModel.dialogMessage

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {

        HeaderImage(
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(
            value = correo,
            onValueChange = {loginViewModel.setEmail(it)},
            placeholder = "correo",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.padding(16.dp))
        PasswordField(
            value = contrasena,
            onValueChange = {loginViewModel.setPassword(it)},
            placeholder = "contraseña",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )  //Contraseña

        /*Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End)) //Olvidaste tu contra*/

        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(
            texto = "Iniciar Sesión",
            nav = { loginViewModel.login()}
        )
    }
    if (isError) {
        Text(
            text = "Hubo un error al iniciar sesión",
            color = MaterialTheme.colorScheme.error,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
    if(loginSuccess){
        Text(
            text = "siuuuuu",
            color = MaterialTheme.colorScheme.background,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        navController.navigate("especialistaMainScreen/${idEspecialista}")
    }

}