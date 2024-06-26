package com.example.proyectosisvitag3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectosisvitag3.ui.theme.iu.MainScreen
import com.example.proyectosisvitag3.ui.theme.iu.LoginScreen
import com.example.proyectosisvitag3.ui.theme.iu.EvaluarResultadoScreen
import com.example.proyectosisvitag3.ui.theme.iu.StudentMainScreen
import com.example.proyectosisvitag3.ui.theme.iu.LoginViewModel
import com.example.proyectosisvitag3.ui.theme.iu.EvaluarResultadoViewModel
import com.example.proyectosisvitag3.ui.theme.iu.formulario.PreguntasCuestionario
import com.example.proyectosisvitag3.ui.theme.iu.TermsAndConditionsScreen
import com.example.proyectosisvitag3.ui.theme.iu.EspecialistaMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "mainScreen") {
                composable("mainScreen") { MainScreen(navController) }
                composable("loginScreen") { LoginScreen(navController, LoginViewModel()) }
                composable("studentMainScreen") { StudentMainScreen(navController) }
                composable("EspecialistaMainScreen") { EspecialistaMainScreen() }
                composable("evaluarResultadoScreen") { EvaluarResultadoScreen(navController, EvaluarResultadoViewModel()) }
                composable("termsAndConditionsScreen") { TermsAndConditionsScreen(navController) }
                composable("testScreen") { PreguntasCuestionario(CantPreguntas = 10, CantRespuestas = 4) }
            }
        }
    }
}
