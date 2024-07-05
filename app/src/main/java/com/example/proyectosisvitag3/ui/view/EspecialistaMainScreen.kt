package com.example.proyectosisvitag3.ui.theme.iu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EspecialistaMainScreen(navController: NavController,idEspecialista: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
    ) {
        Text(text = "Pantalla principal del Especialista")
        Button(onClick = {
            navController.navigate("resultadosTestScreen/${idEspecialista}")
        }){
            Text(text= "Test Realizados")
        }
    }
}