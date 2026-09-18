package com.refernandes.informart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    // Variáveis que vão armazenar temporariamente o nome de usuário e a senha conforme o usuário digita
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    val fonteKufam = FontFamily(Font(R.font.kufam))

    // Box serve como um "sanduíche" visual: o que vem primeiro (a Imagem) fica no fundo, o resto fica por cima
    Box(modifier = Modifier.fillMaxSize()) {

        // Imagem de fundo da tela de login
        Image(
            painter = painterResource(id = R.drawable.login_fundo),
            contentDescription = "Fundo da Tela de Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Coluna central que alinha o texto, os campos e o botão no meio da tela
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título amarelo destacado
            Text(
                text = "LOGIN",
                fontFamily = fonteKufam,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5A623),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Campo de digitação para o Usuário (texto normal)
            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuário", color = Color.White) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de digitação para a Senha
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha", color = Color.White) },
                visualTransformation = PasswordVisualTransformation(), // Transforma as letras em "bolinhas" por segurança
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botão amarelo que efetua a ação de entrar (vai para o Menu)
            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5A623)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Entrar", color = Color.White, fontWeight = FontWeight.Bold, fontFamily = fonteKufam)
            }
        }
    }
}