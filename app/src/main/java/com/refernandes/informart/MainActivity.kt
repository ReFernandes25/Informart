package com.refernandes.informart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuração para deixar o app em Tela cheia
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        setContent {
            // O estado inicial do app é a tela de "entrada" (splash screen)
            var telaAtual by remember { mutableStateOf("entrada") }

            // Crossfade cria uma transição suave (esmaecimento) entre as telas
            Crossfade(
                targetState = telaAtual,
                animationSpec = tween(durationMillis = 1000),
                label = "transicao_telas"
            ) { tela ->
                when (tela) {
                    "entrada" -> {
                        HomeScreen(onScreenClick = { telaAtual = "login" })
                        // Muda para o login automaticamente após 3 segundos
                        LaunchedEffect(Unit) {
                            delay(3000)
                            telaAtual = "login"
                        }
                    }
                    "login" -> {
                        LoginScreen(onLoginClick = { telaAtual = "menu" })
                    }
                    "menu" -> {
                        MenuScreen(
                            onVendasClick = { telaAtual = "vendas" },
                            onGastosClick = { telaAtual = "gastos" },
                            onRegistrosClick = { telaAtual = "registros" },
                            onBalancoClick = { telaAtual = "balanco" },
                            onAnotacoesClick = { telaAtual = "anotacoes" } // BOTÃO DE ANOTAÇÕES CONECTADO AQUI
                        )
                    }
                    // Rotas para as telas do aplicativo
                    "vendas" -> VendasScreen(onBackClick = { telaAtual = "menu" })
                    "gastos" -> GastosScreen(onBackClick = { telaAtual = "menu" })
                    "registros" -> RegistrosScreen(onBackClick = { telaAtual = "menu" })
                    "balanco" -> BalancoScreen(onBackClick = { telaAtual = "menu" })
                    "anotacoes" -> AnotacoesScreen(onBackClick = { telaAtual = "menu" }) // ROTA DA TELA DE ANOTAÇÕES AQUI
                }
            }
        }
    }
}