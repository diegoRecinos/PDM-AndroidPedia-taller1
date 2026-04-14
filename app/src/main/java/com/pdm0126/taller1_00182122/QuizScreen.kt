package com.pdm0126.taller1_00182122

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizScreen(
    onQuizFinished: (Int) -> Unit
) {
    // 1. Acceso a los datos mediante el repositorio usa índice
    val questions = QuizRepository.androidHistoryQuiz
    var currentIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }

    // Estados de la pregunta actual
    val currentQuestion = questions[currentIndex]
    var selectedOptionIndex by remember { mutableIntStateOf(-1) }
    var isAnswered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Indicadores de progreso y puntaje
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Pregunta ${currentIndex + 1} de ${questions.size}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Puntaje: $score / ${questions.size}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Card de la Pregunta
        Card(
            modifier = Modifier.fillMaxWidth().heightIn(min = 120.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Box(modifier = Modifier.padding(16.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = currentQuestion.text,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Opciones con forEach 4 elementos fijos
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            currentQuestion.options.forEachIndexed { index, optionText ->
                val isCorrect = index == currentQuestion.correctAnswerIndex
                val isSelected = index == selectedOptionIndex

                // Lógica de colores según estado
                val buttonColor = when {
                    !isAnswered -> MaterialTheme.colorScheme.surfaceVariant
                    isCorrect -> Color(0xFF4CAF50)
                    isSelected -> Color(0xFFF44336)
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }

                Button(
                    onClick = {
                        if (!isAnswered) {
                            selectedOptionIndex = index
                            isAnswered = true
                            if (isCorrect) score++
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor,
                        contentColor = if (isAnswered && (isCorrect || isSelected)) Color.White
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = optionText, fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección de Feedback y Siguiente
        if (isAnswered) {
            Text(
                text = "💡 ${currentQuestion.funFact}",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    if (currentIndex + 1 < questions.size) {
                        // Reset para la siguiente pregunta
                        currentIndex++
                        selectedOptionIndex = -1
                        isAnswered = false
                    } else {
                        // Fin del quiz
                        onQuizFinished(score)
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(if (currentIndex + 1 < questions.size) "Siguiente" else "Ver Resultados")
            }
        }
    }
}
