package com.pdm0126.taller1_00182122

// modelo de datos
data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val funFact: String
)


object QuizRepository {
    val androidHistoryQuiz = listOf(

        Question(
            id = 1,
            text = "¿Quiénes fueron los fundadores principales de Android Inc. en 2003?",
            options = listOf("Andy Rubin y Rich Miner", "Steve Jobs y Wozniak", "Bill Gates y Paul Allen", "Larry Page y Sergey Brin"),
            correctAnswerIndex = 0,
            funFact = "Fue fundada en Palo Alto por Andy Rubin, Rich Miner, Nick Sears y Chris White."
        ),
        Question(
            id = 2,
            text = "¿Para qué tipo de dispositivos se diseñó Android originalmente?",
            options = listOf("Computadoras", "Cámaras Digitales", "Consolas de Videojuegos", "Relojes Inteligentes"),
            correctAnswerIndex = 1,
            funFact = "El objetivo era un SO avanzado para cámaras que se conectaran a la nube."
        ),
        Question(
            id = 3,
            text = "¿Cuánto pagó Google aproximadamente por la adquisición de Android en 2005?",
            options = listOf("$10 Millones", "$50 Millones", "$100 Millones", "$1,000 Millones"),
            correctAnswerIndex = 1,
            funFact = "Google buscaba asegurar su presencia en la web móvil antes de que el mercado se cerrara."
        ),

        Question(
            id = 4,
            text = "¿Qué consorcio se anunció en 2007 para fomentar los estándares abiertos?",
            options = listOf("Android Alliance", "Open Handset Alliance (OHA)", "Mobile Open Group", "Linux Mobile Found."),
            correctAnswerIndex = 1,
            funFact = "La OHA comenzó con 84 empresas para competir contra sistemas cerrados como el de Apple."
        ),
        Question(
            id = 5,
            text = "¿Bajo qué licencia de código abierto liberó Google el sistema Android?",
            options = listOf("Licencia GPL", "Licencia MIT", "Licencia Apache", "Licencia Creative Commons"),
            correctAnswerIndex = 2,
            funFact = "Esto permitió que cualquier fabricante pudiera modificar y usar el sistema libremente."
        ),
        Question(
            id = 6,
            text = "¿Cómo se llamó comercialmente el primer dispositivo Android (HTC Dream)?",
            options = listOf("Nexus One", "Motorola Droid", "T-Mobile G1", "Samsung Galaxy S"),
            correctAnswerIndex = 2,
            funFact = "Se lanzó el 22 de octubre de 2008 e incluía un teclado físico deslizable."
        ),
        Question(
            id = 7,
            text = "¿En qué año Android superó el 50% de la cuota de mercado global?",
            options = listOf("2009", "2011", "2013", "2015"),
            correctAnswerIndex = 1,
            funFact = "Para finales de 2011, Android ya dominaba el mercado superando a iOS."
        ),

        Question(
            id = 8,
            text = "¿Qué máquina virtual usaba Android antes de la versión 5.0?",
            options = listOf("JVM", "Dalvik", "ART", "V8 Engine"),
            correctAnswerIndex = 1,
            funFact = "Dalvik usaba compilación Just-In-Time (JIT), lo que consumía más recursos en el momento."
        ),
        Question(
            id = 9,
            text = "¿Qué mejora técnica introdujo ART (Android Runtime) en Lollipop?",
            options = listOf("Interpretación pura", "Compilación Ahead-of-Time (AOT)", "Sin compilación", "Solo JIT"),
            correctAnswerIndex = 1,
            funFact = "Las apps se compilan al instalarse, mejorando la velocidad y la duración de la batería."
        ),

        Question(
            id = 10,
            text = "¿Cuál era el problema principal de Java mencionado en la historia?",
            options = listOf("Muy lento", "Verboso y propenso a NullPointerException", "Sin soporte de Google", "Solo para servidores"),
            correctAnswerIndex = 1,
            funFact = "La seguridad de nulos de lenguajes modernos resolvió gran parte de estos fallos."
        ),
        Question(
            id = 11,
            text = "¿En qué año se anunció a Kotlin como lenguaje oficial en el Google I/O?",
            options = listOf("2015", "2017", "2019", "2021"),
            correctAnswerIndex = 1,
            funFact = "En 2017 recibió soporte oficial y en 2019 se declaró como el lenguaje 'preferido'."
        ),

        Question(
            id = 12,
            text = "¿Qué herramienta de 2018 permitió estandarizar la lógica (como ViewModel y Room)?",
            options = listOf("Android SDK", "Android Jetpack", "Material Design", "Firebase"),
            correctAnswerIndex = 1,
            funFact = "Jetpack permitió separar por fin la lógica de datos de la interfaz de usuario."
        )
    )
}