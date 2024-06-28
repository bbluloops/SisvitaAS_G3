package com.example.proyectosisvitag3.ui.theme.iu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.rememberNavController
import android.util.Log

@Composable
fun StudentMainScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pantalla Principal del Alumno",
                style = TextStyle(fontSize = 24.sp, color = Color.Black)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    try{
                        navController.navigate("termsAndConditionsScreen")
                    }catch(e:Exception)
                    {
                        Log.e("StudentMainScreen",e.toString())
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "Iniciar Test")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStudentMainScreen() {
    StudentMainScreen(rememberNavController())
}