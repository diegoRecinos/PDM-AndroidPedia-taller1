package com.pdm0126.taller1_00182122

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.pdm0126.taller1_00182122.ui.theme.AndroidPediaByCastroRecinosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPediaByCastroRecinosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

enum class Screen {
    Welcome,
    Quiz,
    Results
}

@Composable
fun App(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(Screen.Welcome) }
    var finalScore by remember { mutableIntStateOf(0) }

    when (currentScreen) {
        Screen.Welcome -> {
            WelcomeScreen(
                modifier = modifier,
                studentName = "Castro Recinos",
                studentId = "00182122",
                onStartQuiz = { currentScreen = Screen.Quiz }
            )
        }
        Screen.Quiz -> {
            QuizScreen(
                onQuizFinished = { score ->
                    finalScore = score
                    currentScreen = Screen.Results
                }
            )
        }
        Screen.Results -> {
            ResultsScreen(
                score = finalScore,
                totalQuestions = QuizRepository.androidHistoryQuiz.size,
                onRestart = { currentScreen = Screen.Welcome }
            )
        }
    }
}

@Composable
fun ResultsScreen(score: Int, totalQuestions: Int, onRestart: () -> Unit) {

    androidx.compose.foundation.layout.Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Text(
            text = "¡Quiz Terminado!",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )
        androidx.compose.material3.Text(
            text = "Tu puntaje: $score / $totalQuestions",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        androidx.compose.material3.Button(onClick = onRestart) {
            androidx.compose.material3.Text("Volver al Inicio")
        }
    }
}