package com.example.proyectosisvitag3.ui.view

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectosisvitag3.data.model.response.ResultadoDetallado
import com.example.proyectosisvitag3.ui.viewmodel.ResultadosTestViewModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ResultadosTestScreen(navController: NavController,
                         resultadosTestViewModel: ResultadosTestViewModel,
                         idEspecialista:String){
    resultadosTestViewModel.loadResultados()
    var fechaInicial by remember {
        mutableStateOf(LocalDate.of(1900, 1, 1))
    }
    var fechaFinal by remember {
        mutableStateOf(LocalDate.now())
    }
    var showFechaInicial by remember {
        mutableStateOf(false)
    }
    var showFechaFinal by remember {
        mutableStateOf(false)
    }
    val resultados: List<ResultadoDetallado> by resultadosTestViewModel.resultadoResponse

    var listaTest by remember {
        mutableStateOf( setOf<String>())
    }
    var listaAnsiedad by remember {
        mutableStateOf( setOf<String>())
    }
    var ansiedad by remember{
        mutableStateOf("Ansiedad baja")
    }
    var tests by remember {
        mutableStateOf("No tiene nombre el test")
    }
    var sinFiltro by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(resultados) {
        listaTest = resultados.map { it.nombreTest }.toSet()
        listaAnsiedad = resultados.map{ it.infoResultado}.toSet()
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Text("Tipo de test")
                    listaTest.forEach{
                            test ->
                        Text(test)
                        RadioButton(selected = tests == test, onClick = { tests = test})
                    }
                    Text("Nivel de ansiedad:")
                    listaAnsiedad.forEach{
                        Text(it)
                        RadioButton(selected = ansiedad == it, onClick = { ansiedad = it })
                    }
                    Button(onClick = {sinFiltro = !sinFiltro}){
                        if(sinFiltro) {
                            Text("Aplicar Filtro")
                        }
                        else{
                            Text("Eliminar filtro")
                        }
                    }
                }
            }
            Row {
                Button(onClick = { showFechaInicial = true }) {
                    Text("Seleccionar fecha de inicio")
                }
                Button(onClick = { showFechaFinal = true }) {
                    Text(text = "Seleccionar fecha final")
                }
            }
            if (showFechaInicial) {
                val datePicker = rememberDatePickerState()
                DatePickerDialog(onDismissRequest = { showFechaInicial = false }, confirmButton = {
                    TextButton(onClick = {
                        if (datePicker.selectedDateMillis != null) {
                            val instant = Instant.ofEpochMilli(datePicker.selectedDateMillis!!)
                            fechaInicial = instant.atZone(ZoneId.systemDefault()).toLocalDate()
                            showFechaInicial = false
                        }
                    }) {
                        Text(text = "Ok")
                    }
                }) {
                    DatePicker(state = datePicker)
                }
            }
            if (showFechaFinal) {
                val datePicker = rememberDatePickerState()
                DatePickerDialog(onDismissRequest = { showFechaFinal = false }, confirmButton = {
                    TextButton(onClick = {
                        if (datePicker.selectedDateMillis != null) {
                            val instant = Instant.ofEpochMilli(datePicker.selectedDateMillis!!)
                            fechaFinal = instant.atZone(ZoneId.systemDefault()).toLocalDate()
                            showFechaFinal = false
                        }
                    }) {
                        Text(text = "Ok")
                    }
                }) {
                    DatePicker(state = datePicker)
                }
            }

            val dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH)

            resultados.filter { resultado ->
                val fechaResultado = LocalDate.parse(resultado.fechaResultado, dateFormatter)
                (fechaResultado in fechaInicial..fechaFinal && ((resultado.nombreTest == tests && resultado.infoResultado == ansiedad)|| sinFiltro))
            }.forEach { resultado ->
                Row(horizontalArrangement = Arrangement.Center) {
                    TestCard(
                        navController = navController,
                        nombreTest = resultado.nombreTest,
                        nombreUsuario = "${resultado.nombreEstudiante} ${resultado.apellidoEstudiante}",
                        puntaje = resultado.puntajeResultadoTest,
                        nivelAnsiedad = resultado.infoResultado,
                        idResultado = resultado.idResultadoTest,
                        idEspecialista = idEspecialista
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Button(onClick = { navController.navigate("especialistaMainScreen/${idEspecialista}") }) {
                Text(text = "Volver al menu")
            }
        }
    }
}

@Composable
fun TestCard(navController: NavController, nombreTest: String, nombreUsuario: String, puntaje: String,
             nivelAnsiedad: String,
             idResultado: String,
             idEspecialista: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Test de $nombreTest")
            Text(text = nombreUsuario)
            Text(text = "Puntaje del test: $puntaje")
            Text(text = "Nivel de ansiedad: $nivelAnsiedad")
            Button(onClick = {
                navController.navigate("evaluarResultadoScreen/${idResultado}/${puntaje}/${idEspecialista}/${nivelAnsiedad}/${nombreTest}")
            }) {
                Text(text = "Evaluar Test")
            }
        }
    }
}