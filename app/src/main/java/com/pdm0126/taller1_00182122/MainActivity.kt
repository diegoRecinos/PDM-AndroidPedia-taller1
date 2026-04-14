package com.pdm0126.taller1_00182122

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo de Android (Versión sin fondo y un poco más grande)
        Image(
            painter = painterResource(id = R.drawable.android_logo_2023_22),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 32.dp)
        )

        Text(
            text = "FIN",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Tu puntaje: $score / $totalQuestions",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF004080),
                contentColor = Color.White
            ),
            onClick = onRestart
        ) {
            Text("Volver al Inicio")
        }
    }
}
