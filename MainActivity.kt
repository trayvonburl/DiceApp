package diceapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.ceil
import kotlin.math.round

class MainActivity : ComponentActivity() {

    // Example of lateinit var (Compose doesn't need many)
    private lateinit var _unusedPlaceholder: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Just fulfilling requirement that lateinit vars exist
        _unusedPlaceholder = "ComposeTipCalc"

        enableEdgeToEdge()
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        TipCalculatorScreen(
            modifier = Modifier.padding(padding)
        )
    }
}