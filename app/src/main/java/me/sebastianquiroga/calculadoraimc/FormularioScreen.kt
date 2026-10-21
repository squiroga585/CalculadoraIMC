package me.sebastianquiroga.calculadoraimc

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormularioScreen(
    viewModel: ImcViewModel,
    onCalculado: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Calculadora de IMC", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))

        // La View solo MUESTRA el estado y ENVÍA eventos al ViewModel
        OutlinedTextField(
            value = viewModel.peso,
            onValueChange = { viewModel.onPesoChange(it) },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = viewModel.altura,
            onValueChange = { viewModel.onAlturaChange(it) },
            label = { Text("Altura (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        // Estado de error: aparece solo si el ViewModel lo llena
        if (viewModel.error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(viewModel.error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            if (viewModel.calcular()) {
                onCalculado()
            }
        }) {
            Text("Calcular")
        }
    }
}