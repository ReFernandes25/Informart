package com.refernandes.informart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuScreen(
    onVendasClick: () -> Unit,
    onGastosClick: () -> Unit,
    onRegistrosClick: () -> Unit,
    onBalancoClick: () -> Unit,
    onAnotacoesClick: () -> Unit
) {
    val fonteKufam = FontFamily(Font(R.font.kufam))

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF7D8CC4)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MenuButton(text = "Vendas", fontFamily = fonteKufam, onClick = onVendasClick)
            MenuButton(text = "Gastos", fontFamily = fonteKufam, onClick = onGastosClick)
            MenuButton(text = "Registros", fontFamily = fonteKufam, onClick = onRegistrosClick)
            MenuButton(text = "Financeiro", fontFamily = fonteKufam, onClick = onBalancoClick)
            MenuButton(text = "Anotações", fontFamily = fonteKufam, onClick = onAnotacoesClick)
        }
    }
}

@Composable
fun MenuButton(text: String, fontFamily: FontFamily, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(75.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001A57))
    ) {
        Text(text = text, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, fontFamily = fontFamily)
    }
}