package com.example.proyectosisvitag3.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.ui.viewmodel.ResultadosTestViewModel

@Composable
fun ResultadosTestScreen(navController: NavController,
                         resultadosTestViewModel: ResultadosTestViewModel,
                         idEspecialista:String){
    resultadosTestViewModel.loadResultados()
    val resultados : List<ResultadoDetallado> by resultadosTestViewModel.resultadoResponse;
    Column(Modifier.verticalScroll(rememberScrollState())){
        resultados.forEach{
                resultado ->
            Row (horizontalArrangement = Arrangement.Center){
                TestCard(navController = navController, nombreTest = resultado.nombreTest, nombreUsuario ="${resultado.nombreEstudiante} ${resultado.apellidoEstudiante}"
                    ,puntaje= resultado.puntajeResultadoTest, nivelAnsiedad = resultado.infoResultado
                    , idResultado = resultado.idResultadoTest
                    , idEspecialista = idEspecialista)
            }
        }
        Button(onClick = { navController.navigate("especialistaMainScreen/${idEspecialista}")}) {
            Text(text = "Volver al menu")
        }
    }
}

@Composable
fun TestCard(navController:NavController,nombreTest:String,nombreUsuario: String,puntaje:String,
             nivelAnsiedad:String,
             idResultado: String,
             idEspecialista: String){
    Card {
        Text(text = "Test de ${nombreTest}")
        Text(text = nombreUsuario)
        Text(text = "Puntaje del test:${puntaje}")
        Text(text = "Nivel de ansiedad: ${nivelAnsiedad}")
        Button(onClick = {
            navController.navigate("evaluarResultadoScreen/${idResultado}/${puntaje}/${idEspecialista}/${nivelAnsiedad}/${nombreTest}")
        }) {
            Text(text = "Evaluar Test")
        }
    }
}