package com.example.proyectosisvitag3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectosisvitag3.ui.theme.data.model.tbEstudiante
import com.example.proyectosisvitag3.ui.theme.iu.*
import com.example.proyectosisvitag3.ui.theme.iu.formulario.*
import com.example.proyectosisvitag3.ui.view.EspecialistaTestScreen
import com.example.proyectosisvitag3.ui.view.MapaDeCalor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "mainScreen") {
                composable("mainScreen") { MainScreen(navController) }
                composable("loginScreen") { LoginScreen(navController, LoginViewModel()) }
                composable("loginScreenEspecialista") { LoginScreenEspecialista(navController, LoginEspecialistaViewModel()) }
                composable("studentMainScreen") { StudentMainScreen(navController)}
                composable("especialistaMainScreen") { EspecialistaMainScreen(navController) }
                composable("termsAndConditionsScreen"){ TermsAndConditionsScreen(navController)}
                composable("evaluarResultadoScreen") { EvaluarResultadoScreen(navController, EvaluarResultadoViewModel()) }
                composable("testScreen") { PreguntasCuestionario() }
                composable("mapaDeCalor") { MapaDeCalor() }
                composable("especialistaTestScreen"){ EspecialistaTestScreen()}
            }
        }
    }
}
