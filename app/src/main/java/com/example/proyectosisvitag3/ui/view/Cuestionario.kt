package com.example.proyectosisvitag3.ui.theme.iu.formulario

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import android.util.Log
import androidx.compose.runtime.livedata.observeAsState
import com.example.proyectosisvitag3.ui.theme.iu.CuestionarioViewModel
import com.example.proyectosisvitag3.ui.theme.data.model.*

@Composable
fun PreguntasCuestionario(cuestionarioViewModel: CuestionarioViewModel = viewModel()) {
    Log.d("Cuestionario View","Obteniendo datos")
    cuestionarioViewModel.loadPreguntas()
    val preguntas: Map<String,Set<PreguntasResponse>> by cuestionarioViewModel.preguntas
    var respuestasSeleccionadas by remember { mutableStateOf<Map<String, PreguntasResponse>>(emptyMap()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Test Becker",
            style = TextStyle(fontSize = 24.sp, color = Color.Black),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            preguntas!!.forEach { (question, answers) ->
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(2.dp, Color.Cyan, RoundedCornerShape(8.dp))
                            .padding(16.dp)
                            .background(Color(0xFFE3F2FD)) // Background color
                    ) {
                        Column {
                            Text(
                                text = question,
                                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                            answers.forEach { answer ->
                                RespuestasCuestionario(
                                    answerText = answer.respuestaOpcionTest,
                                    selectedAnswer = respuestasSeleccionadas[question]?.respuestaOpcionTest,
                                    onSelected = {
                                        respuestasSeleccionadas = respuestasSeleccionadas.toMutableMap().apply {
                                            put(question, answer)
                                        }
                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        val allQuestionsAnswered = preguntas!!.keys.all { respuestasSeleccionadas.containsKey(it) }

        Button(
            onClick = {
                Log.d("Cuestionario",respuestasSeleccionadas.toString())
                cuestionarioViewModel.sendRespuesta(respuestasSeleccionadas)
            },
            enabled = allQuestionsAnswered,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (allQuestionsAnswered) Color(0xFFFF4303) else Color(0xFFF78058),
                contentColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Enviar Test")
        }
    }
}

@Composable
fun RespuestasCuestionario(
    answerText: String,
    selectedAnswer: String?,
    onSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = (answerText == selectedAnswer),
                onClick = { onSelected(answerText) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = answerText)
        }
    }
}

@Preview
@Composable
fun PreviewPreguntasCuestionario() {
    PreguntasCuestionario()
}
