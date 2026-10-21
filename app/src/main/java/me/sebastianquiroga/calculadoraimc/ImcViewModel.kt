package me.sebastianquiroga.calculadoraimc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ImcViewModel : ViewModel() {


    var peso by mutableStateOf("")
        private set

    var altura by mutableStateOf("")
        private set

    var imc by mutableStateOf<Float?>(null)
        private set

    var categoria by mutableStateOf("")
        private set

    var error by mutableStateOf("")
        private set


    fun onPesoChange(nuevo: String) {
        peso = nuevo
    }

    fun onAlturaChange(nuevo: String) {
        altura = nuevo
    }


    fun calcular(): Boolean {
        val p = peso.toFloatOrNull()
        val a = altura.toFloatOrNull()

        if (p == null || a == null || p <= 0 || a <= 0) {
            error = "Ingresa valores válidos"
            return false
        }

        error = ""
        val metros = a / 100f
        val resultado = p / (metros * metros)
        imc = resultado

        categoria = when {
            resultado < 18.5f -> "Bajo peso"
            resultado < 25f   -> "Peso normal"
            resultado < 30f   -> "Sobrepeso"
            else              -> "Obesidad"
        }
        return true
    }

    fun limpiar() {
        peso = ""
        altura = ""
        imc = null
        categoria = ""
        error = ""
    }
}