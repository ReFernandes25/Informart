package com.refernandes.informart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@Composable
fun BalancoScreen(onBackClick: () -> Unit) {
    val fonteKufam = FontFamily(Font(R.font.kufam))
    var filtroAtual by remember { mutableStateOf("Tudo") }
    val hoje = LocalDate.now()

    val vendasFiltradas = Repositorio.vendas.filter {
        when (filtroAtual) {
            "Hoje" -> it.data == hoje
            "Mês" -> it.data.month == hoje.month && it.data.year == hoje.year
            else -> true
        }
    }
    val gastosFiltrados = Repositorio.gastos.filter {
        when (filtroAtual) {
            "Hoje" -> it.data == hoje
            "Mês" -> it.data.month == hoje.month && it.data.year == hoje.year
            else -> true
        }
    }

    val totalVendido = vendasFiltradas.sumOf { it.valor }
    val totalGasto = gastosFiltrados.sumOf { it.valor }
    val lucro = totalVendido - totalGasto

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF7D8CC4)), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF001A57), RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .padding(top = 60.dp, bottom = 20.dp)
        ) {
            IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.White)
            }
            Text("Financeiro", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = fonteKufam, modifier = Modifier.align(Alignment.Center))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            FiltroButton("Hoje", filtroAtual == "Hoje") { filtroAtual = "Hoje" }
            FiltroButton("Mês", filtroAtual == "Mês") { filtroAtual = "Mês" }
            FiltroButton("Tudo", filtroAtual == "Tudo") { filtroAtual = "Tudo" }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ResumoCard(titulo = "Total Faturado", valor = totalVendido, corValor = Color(0xFF4CAF50), fontFamily = fonteKufam)
        Spacer(modifier = Modifier.height(16.dp))

        ResumoCard(titulo = "Total Gasto", valor = totalGasto, corValor = Color(0xFFF44336), fontFamily = fonteKufam)
        Spacer(modifier = Modifier.height(24.dp))

        ResumoCard(
            titulo = "LUCRO LÍQUIDO",
            valor = lucro,
            corValor = if (lucro >= 0) Color(0xFF4CAF50) else Color(0xFFF44336),
            fontFamily = fonteKufam
        )
    }
}

@Composable
fun FiltroButton(texto: String, selecionado: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = if (selecionado) Color(0xFF001A57) else Color(0xFF9EABDB)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = texto, color = if (selecionado) Color.White else Color.DarkGray, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ResumoCard(titulo: String, valor: Double, corValor: Color, fontFamily: FontFamily) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF001A57)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = titulo, color = Color.White, fontSize = 18.sp, fontFamily = fontFamily)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "R$ ${String.format("%.2f", valor)}", color = corValor, fontSize = 28.sp, fontWeight = FontWeight.Bold, fontFamily = fontFamily)
        }
    }
}
