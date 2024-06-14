package com.example.proyectosisvitag3.ui.theme.login.iu.formulario

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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


@Composable
fun PreguntasCuestionario(CantPreguntas: Int, CantRespuestas: Int) {
    val preguntas = remember { List(CantPreguntas) { index -> "Pregunta ${index + 1}" } }
    val respuestas = remember { List(CantRespuestas) { index -> "Opción ${index + 1}" } }

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(preguntas) { question ->
            var selectedAnswer by remember { mutableStateOf<String?>(null) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(2.dp, Color.Cyan, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = question,
                        style = TextStyle(fontSize = 20.sp, color = Color.Black),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    respuestas.forEach { answer ->
                        RespuestasCuestionario(
                            answerText = answer,
                            selectedAnswer = selectedAnswer,
                            onSelected = { selectedAnswer = it }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun RespuestasCuestionario(answerText: String, selectedAnswer: String?, onSelected: (String) -> Unit) {
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

@Preview(showBackground = true)
@Composable
fun PreviewPreguntasCuestionario() {
    PreguntasCuestionario(CantPreguntas = 5, CantRespuestas = 3)
}
