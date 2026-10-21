package me.sebastianquiroga.calculadoraimc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultadoScreen(
    viewModel: ImcViewModel,
    onVolver: () -> Unit
) {
    val resultado = viewModel.imc

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tu resultado", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))

        if (resultado != null) {
            Text("IMC: ${"%.1f".format(resultado)}", fontSize = 48.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(viewModel.categoria, fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Datos guardados en el ViewModel:\nPeso: ${viewModel.peso} kg | Altura: ${viewModel.altura} cm",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onVolver) {
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(onClick = {
            viewModel.limpiar()
            onVolver()
        }) {
            Text("Limpiar y empezar de nuevo")
        }
    }
}