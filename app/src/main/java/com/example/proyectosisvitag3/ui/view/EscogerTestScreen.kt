package com.example.proyectosisvitag3.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectosisvitag3.ui.viewmodel.EscogerTestViewModel

@Composable
fun EscogerTestScreen(navController: NavController,
                      viewModel: EscogerTestViewModel){
    viewModel.loadTest()
    val tests by viewModel.tests
    var nombreTest by remember {
        mutableStateOf("Inventario de Ansiedad de Beck (BAI)")
    }
    var idTest by remember {
        mutableStateOf("5")
    }
    Column (Modifier.verticalScroll(rememberScrollState())){
        Text(text = "Test actual :$nombreTest")
        tests.forEach{
                test ->
            Card {
                Text("Nombre del test : ${test.nombreTest}")
                Text("Autor del test : ${test.autorTest}")
                RadioButton(selected = (test.nombreTest==nombreTest), onClick = {
                    nombreTest = test.nombreTest
                    idTest = test.idTest})
            }
        }
        Spacer(Modifier.height(8.dp))
        Button( onClick = {
            try {
                navController.navigate("testScreen/${nombreTest}/${idTest}")
            }catch(e:Exception)
            {
                Log.e("EscogerTestScreen",e.toString())
            }
        }){
            Text(text = "Iniciar test")
        }
    }
}