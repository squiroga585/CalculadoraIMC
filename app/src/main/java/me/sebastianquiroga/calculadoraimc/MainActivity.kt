package me.sebastianquiroga.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()


    val viewModel: ImcViewModel = viewModel()

    NavHost(navController = navController, startDestination = "formulario") {
        composable("formulario") {
            FormularioScreen(
                viewModel = viewModel,
                onCalculado = { navController.navigate("resultado") }
            )
        }
        composable("resultado") {
            ResultadoScreen(
                viewModel = viewModel,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}