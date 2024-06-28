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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreenEspecialista(
    navController: NavHostController,
    loginEspecialistaViewModel: LoginEspecialistaViewModel = viewModel()
) {
    val showDialog by loginEspecialistaViewModel.showDialog
    val dialogMessage by loginEspecialistaViewModel.dialogMessage

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Login(loginEspecialistaViewModel,navController)
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { loginEspecialistaViewModel.dismissDialog() },
            title = {
                Text(text = "Notificación")
            },
            text = {
                Text(text = dialogMessage)
            },
            confirmButton = {
                Button(
                    onClick = { loginEspecialistaViewModel.dismissDialog() }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    loginEspecialistaViewModel: LoginEspecialistaViewModel,
    navController: NavHostController
) {
    val correo: String by loginEspecialistaViewModel.correoState
    val contrasena: String by loginEspecialistaViewModel.contrasenaState
    val isError: Boolean by loginEspecialistaViewModel.isError
    val loginSuccess: Boolean by loginEspecialistaViewModel.loginSuccess
    val showDialog: Boolean by loginEspecialistaViewModel.showDialog
    val dialogMessage:String by loginEspecialistaViewModel.dialogMessage

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp),
    ) {

        HeaderImageEspecialista(
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))
        EmailFieldEspecialista(
            value = correo,
            onValueChange = {loginEspecialistaViewModel.setEmail(it)},
            placeholder = "correo",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.padding(16.dp))
        PasswordFieldEspecialista(
            value = contrasena,
            onValueChange = {loginEspecialistaViewModel.setPassword(it)},
            placeholder = "contraseña",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )  //Contraseña

        /*Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End)) //Olvidaste tu contra*/

        Spacer(modifier = Modifier.padding(16.dp))
        LoginButtonEspecialista(
            texto = "Iniciar Sesión",
            nav = { loginEspecialistaViewModel.login()}
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
        navController.navigate("especialistaMainScreen")
    }

}

@Composable
fun LoginButtonEspecialista(
    texto:String,
    nav: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF4303),
            disabledContainerColor = Color(0xFFC75C38),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        onClick = { nav() },
    ) {
        Text(texto)
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Olvidaste la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFB9600)
    )
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldEspecialista(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(), // Contraseña en *****
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(text = placeholder)
        }
    )
}

@Composable
fun EmailFieldEspecialista(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(text = placeholder)
        }
    )
}

@Composable
fun HeaderImageEspecialista(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.login_especilaistas),
        contentDescription = "Header",
        modifier = modifier
    )
}