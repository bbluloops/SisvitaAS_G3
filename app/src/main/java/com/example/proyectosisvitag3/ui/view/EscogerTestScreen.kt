package com.example.proyectosisvitag3.ui.view

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column (
            Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                textAlign = TextAlign.Center,
                text = "Test actual :$nombreTest",
                style = TextStyle(fontSize = 24.sp, color = Color.Black)
            )
            Spacer(modifier = Modifier.height(16.dp))
            tests.forEach{
                    test ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ){
                    Column (
                        modifier = Modifier.padding(16.dp)
                    ){
                        Text("Nombre del test : ${test.nombreTest}")
                        Text("Autor del test : ${test.autorTest}")
                        RadioButton(selected = (test.nombreTest==nombreTest), onClick = {
                            nombreTest = test.nombreTest
                            idTest = test.idTest})
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
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
}