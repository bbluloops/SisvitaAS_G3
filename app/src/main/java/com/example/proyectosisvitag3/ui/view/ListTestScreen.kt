package com.example.proyectosisvitag3.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
    Column(Modifier.verticalScroll(rememberScrollState())){

        tests.filter{
                test ->
            test.nombreEstudiante == nombreEstudiante && test.apellidoEstudiante == apellidoEstudiante
        }.forEach{
                test ->
            Card {
                Text("Test de ${test.nombreTest}")
                Text("Nombre usuario: ${test.nombreEstudiante} ${test.apellidoEstudiante}")
                Text("Puntaje: ${test.puntajeResultadoTest}")
                Text("Nivel ansiedad: ${test.infoResultado}")
            }
        }
    }
}