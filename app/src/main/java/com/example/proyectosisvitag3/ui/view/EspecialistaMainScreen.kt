package com.example.proyectosisvitag3.ui.theme.iu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun EspecialistaMainScreen(navController: NavHostController) {
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
                text = "Pantalla Principal del Especialista",
                style = TextStyle(fontSize = 24.sp, color = Color.Black)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    try{
                        navController.navigate("especialistaTestScreen")
                    }catch(e:Exception)
                    {
                        Log.e("EspecialistaTestScreen",e.toString())
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "Ver Tests Registrados")
            }
            Button(
                onClick = {
                    try{
                        navController.navigate("mapaDeCalor")
                    }catch(e:Exception)
                    {
                        Log.e("MapaDeCalor",e.toString())
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "Ver mapa de calor")
            }
        }
    }
}