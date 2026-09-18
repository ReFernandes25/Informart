package com.refernandes.informart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
fun RegistrosScreen(onBackClick: () -> Unit) {
    val fonteKufam = FontFamily(Font(R.font.kufam))

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF7D8CC4))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF001A57), RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .padding(top = 60.dp, bottom = 20.dp)
        ) {
            IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.White)
            }
            Text("Registros", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, fontFamily = fonteKufam, modifier = Modifier.align(Alignment.Center))
        }

        if (Repositorio.vendas.isEmpty() && Repositorio.gastos.isEmpty()) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("Nenhum registro cadastrado.", color = Color.White, fontSize = 18.sp, fontFamily = fonteKufam)
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth().padding(horizontal = 24.dp, vertical = 16.dp)) {
                if (Repositorio.vendas.isNotEmpty()) {
                    item {
                        Text("--- Vendas Registradas ---", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = fonteKufam, modifier = Modifier.padding(vertical = 8.dp))
                    }
                    items(items = Repositorio.vendas) { venda ->
                        ItemCard(registro = venda, corTag = Color(0xFF4CAF50), tagText = "VENDA", fonte = fonteKufam)
                    }
                }

                if (Repositorio.gastos.isNotEmpty()) {
                    item {
                        Text("--- Gastos Registrados ---", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = fonteKufam, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))
                    }
                    items(items = Repositorio.gastos) { gasto ->
                        ItemCard(registro = gasto, corTag = Color(0xFFF44336), tagText = "GASTO", fonte = fonteKufam)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCard(registro: Registro, corTag: Color, tagText: String, fonte: FontFamily) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF001A57)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = registro.item, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold, fontFamily = fonte)
                Text(text = "Qtd: ${registro.quantidade}", color = Color.LightGray, fontSize = 14.sp, fontFamily = fonte)
                Text(text = "Total: R$ ${String.format("%.2f", registro.valor)}", color = Color(0xFFF5A623), fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = fonte)
            }
            Surface(color = corTag, shape = RoundedCornerShape(6.dp)) {
                Text(text = tagText, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), fontFamily = fonte)
            }
        }
    }
}