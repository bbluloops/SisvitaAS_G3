package com.example.proyectosisvitag3.ui.theme.iu

import android.os.Build
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import com.example.proyectosisvitag3.R
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import com.example.proyectosisvitag3.data.model.response.OpcionResponse
import com.example.proyectosisvitag3.data.model.response.RespuestaResponse
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EvaluarResultadoScreen(navController: NavHostController,
                           viewModel: EvaluarResultadoViewModel,
                           idResultado: String,
                           puntajeObtenido:String,
                           idEspecialista:String,
                           nivelAnsiedad: String,
                           nombreTest: String) {
    viewModel.loadRespuestas(idResultado)
    viewModel.loadOpciones(nombreTest)
    val opciones: List<OpcionResponse> by viewModel.opciones
    val respuestas:List<RespuestaResponse> by viewModel.respuestasResponse
    var tratamiento:String by remember {
        mutableStateOf("")
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    var nivelAnsiedadState by remember{
        mutableStateOf(nivelAnsiedad)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Row (horizontalArrangement = Arrangement.Center)
        {
            Column(modifier = Modifier.verticalScroll(rememberScrollState()))
            {
                Card {
                    Text(text = puntajeObtenido)
                }
                Text(text = "Respuestas:")
                respuestas.forEach { respuesta ->
                    Card {
                        Text(text = "Respuesta selecccionada ->${respuesta.respuestas}")
                        Text(text = "Valor numerico:${respuesta.valorRespuesta}")
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                }
                Text(text = "Tratamiento:")
                TextField(value = tratamiento, placeholder = {
                    Text(text = "Aqui se debe escribir el tratamiento que recomienda el especialista")
                }, onValueChange = { tratamiento = it })
                Card{
                    Text("Nivel de ansiedad actual -> $nivelAnsiedadState")
                    opciones.forEach{
                            opcion ->
                        Text(opcion.interpretacionPuntaje)
                        RadioButton(selected = (nivelAnsiedadState == opcion.interpretacionPuntaje), onClick = {
                            nivelAnsiedadState = opcion.interpretacionPuntaje
                        })
                    }
                }
                Button(onClick = {
                    showDialog = true
                    viewModel.sendTratamiento(
                        idEspecialista,
                        idResultado,
                        tratamiento,
                        LocalDate.now().toString(),
                        nivelAnsiedadState
                    )
                }) {
                    Text(text = "Regitrar tratamiento")
                }
            }
        }
        if(showDialog)
        {
            Column(verticalArrangement = Arrangement.Center) {
                Row (horizontalArrangement = Arrangement.Center) {
                    Card {
                        Text(text = "Tratamiento registrado con exito")
                        Text(text = "Fecha inicio tratamiento :${LocalDate.now()}")
                        Text(text = "Recomendacion: ${tratamiento}")
                        Button(onClick = { showDialog = false }) {
                            Text("Ok")
                        }
                    }
                }
            }
        }
    }
}