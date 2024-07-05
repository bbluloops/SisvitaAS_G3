package com.example.proyectosisvitag3.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectosisvitag3.ui.viewmodel.ResultadosTestViewModel

@Composable
fun ListTestScreen(navController: NavController,
                   viewModel: ResultadosTestViewModel,
                   nombreEstudiante:String,
                   apellidoEstudiante:String
) {
    viewModel.loadResultados()
    val tests by viewModel.resultadoResponse
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                textAlign = TextAlign.Center,
                text = "Mis Test",
                style = TextStyle(fontSize = 24.sp, color = Color.Black)
            )
            Spacer(modifier = Modifier.height(16.dp))

            tests.filter{
                    test ->
                test.nombreEstudiante == nombreEstudiante && test.apellidoEstudiante == apellidoEstudiante
            }.forEach{
                    test ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Test de ${test.nombreTest}")
                        Text("Nombre usuario: ${test.nombreEstudiante} ${test.apellidoEstudiante}")
                        Text("Puntaje: ${test.puntajeResultadoTest}")
                        Text("Nivel ansiedad: ${test.infoResultado}")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}