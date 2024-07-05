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

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.proyectosisvitag3.ui.view.EscogerTestScreen
import com.example.proyectosisvitag3.ui.view.ListTestScreen
import com.example.proyectosisvitag3.ui.view.ResultadosTestScreen
import com.example.proyectosisvitag3.ui.viewmodel.EscogerTestViewModel
import com.example.proyectosisvitag3.ui.viewmodel.ResultadosTestViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "mainScreen") {
                composable("mainScreen") { MainScreen(navController) }
                composable("listTestScreen/{nombreEstudiante}/{apellidoEstudiante}"){ backStackEntry ->
                    ListTestScreen(navController, ResultadosTestViewModel(),
                        backStackEntry.arguments!!.getString("nombreEstudiante").toString(),
                        backStackEntry.arguments!!.getString("apellidoEstudiante").toString())}
                composable("escogerTestScreen"){
                    EscogerTestScreen(navController = navController, viewModel = EscogerTestViewModel())
                }
                composable("loginScreen") { LoginScreen(navController, LoginViewModel()) }
                composable("loginScreenEspecialista") { LoginScreenEspecialista(navController, LoginEspecialistaViewModel()) }
                composable("studentMainScreen/{nombreEstudiante}/{apellidoEstudiante}") { backStackEntry ->
                    StudentMainScreen(navController,backStackEntry.arguments!!.getString("nombreEstudiante").toString(),backStackEntry.arguments!!.getString("apellidoEstudiante").toString()) }
                composable("especialistaMainScreen/{idEspecialista}"){backStackEntry->
                    EspecialistaMainScreen(navController,backStackEntry.arguments!!.getString("idEspecialista").toString())}
                composable("termsAndConditionsScreen/{nombreTest}/{idTest}"){ backStackEntry ->
                    TermsAndConditionsScreen(navController)}
                composable("resultadosTestScreen/{idEspecialista}"){ backStackEntry ->
                    ResultadosTestScreen(navController,ResultadosTestViewModel(),backStackEntry.arguments!!.getString("idEspecialista").toString()) }
                composable("evaluarResultadoScreen/{idResultado}/{puntajeObtenido}/{idEspecialista}/{nivelAnsiedad}/{nombreTest}") { backStackEntry ->
                    EvaluarResultadoScreen(navController, EvaluarResultadoViewModel(),
                        backStackEntry.arguments!!.getString("idResultado").toString(),
                        backStackEntry.arguments!!.getString("puntajeObtenido").toString(),
                        backStackEntry.arguments!!.getString("idEspecialista").toString(),
                        backStackEntry.arguments!!.getString("nivelAnsiedad").toString(),
                        backStackEntry.arguments!!.getString("nombreTest").toString()) }
                composable("testScreen/{nombreTest}/{idTest}") { backStackEntry -> PreguntasCuestionario(CuestionarioViewModel(),
                    backStackEntry.arguments!!.getString("nombreTest").toString(),
                    backStackEntry.arguments!!.getString("idTest").toString()) }
            }
        }
    }
}
