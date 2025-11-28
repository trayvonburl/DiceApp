fun TipCalculatorScreen(modifier: Modifier = Modifier) {

    var billInput by remember { mutableStateOf("") }
    var tipPercent by remember { mutableIntStateOf(15) }
    var splitCount by remember { mutableIntStateOf(1) }
    var roundingOption by remember { mutableIntStateOf(0) }

    val bill = billInput.toDoubleOrNull() ?: 0.0
    var tip = bill * (tipPercent / 100.0)
    var total = bill + tip

    // Rounding: 0=none, 1=round tip up, 2=round total
    when (roundingOption) {
        1 -> {
            tip = ceil(tip * 100) / 100
            total = bill + tip
        }
        2 -> {
            total = round(total)
            tip = total - bill
        }
    }

    val perPerson = if (splitCount > 0) total / splitCount else total

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Tip Calculator",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = billInput,
            onValueChange = { billInput = it },
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Text(text = "Tip: $tipPercent%")

        Slider(
            value = tipPercent.toFloat(),
            onValueChange = { tipPercent = it.toInt() },
            valueRange = 0f..50f
        )

        Spacer(Modifier.height(20.dp))

        Text(text = "Tip Amount: $${"%.2f".format(tip)}")
        Text(text = "Total Amount: $${"%.2f".format(total)}")

        Spacer(Modifier.height(16.dp))

        // Tip description
        val description = when (tipPercent) {
            in 0..9 -> "Poor"
            in 10..19 -> "Okay"
            in 20..29 -> "Good"
            else -> "Excellent"
        }
        Text(text = "Service: $description")

        Spacer(Modifier.height(24.dp))

        // Split options
        Text("Split ($splitCount people)")
        Row {
            Button(onClick = { if (splitCount > 1) splitCount-- }) {
                Text("-")
            }
            Spacer(Modifier.width(10.dp))
            Button(onClick = { splitCount++ }) {
                Text("+")
            }
        }
        Text(text = "Per Person: $${"%.2f".format(perPerson)}")

        Spacer(Modifier.height(24.dp))

        Text("Rounding Options:")
        Row {
            RadioButton(selected = roundingOption == 0, onClick = { roundingOption = 0 })
            Text("None")
        }
        Row {
            RadioButton(selected = roundingOption == 1, onClick = { roundingOption = 1 })
            Text("Round Tip Up")
        }
        Row {
            RadioButton(selected = roundingOption == 2, onClick = { roundingOption = 2 })
            Text("Round Total")
        }
    }
}