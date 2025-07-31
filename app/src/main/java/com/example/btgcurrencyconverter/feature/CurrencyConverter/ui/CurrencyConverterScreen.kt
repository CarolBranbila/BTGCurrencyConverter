package com.example.btgcurrencyconverter.feature.CurrencyConverter.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.btgcurrencyconverter.R
import com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation.CurrencyConverterViewModel
import com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation.CurrencyConverterViewState
import com.example.btgcurrencyconverter.ui.theme.BTGCurrencyConverterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConventerScreen(
    modifier: Modifier,
    viewModel: CurrencyConverterViewModel,
    onClick: () -> Unit,
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Conversor de Moedas") },
                colors = TopAppBarDefaults.topAppBarColors(
                    MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        }
    ) { innerPadding ->
        when {
            viewState.isLoading ->
                ScreenLoading(
                    modifier = Modifier
                        .padding(innerPadding)
                )

            else -> {
                ContentCurrencyConverterScreen(
                    modifier = Modifier.padding(innerPadding),
                    viewState = viewState,
                    onInputUpdate = {
                        viewModel.updateCurrencyValue(it)
                    },
                    onTargetClick = onClick,
                    onValidateInput = { newValue, oldValue ->
                        viewModel.validIfInputIsValid(newValue, oldValue)
                    }
                )

                Row(
                    modifier
                        .border(
                            width = 1.dp,
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                }
            }
        }
    }
}

@Composable
fun ContentCurrencyConverterScreen(
    modifier: Modifier,
    viewState: CurrencyConverterViewState,
    onInputUpdate: (String) -> Unit,
    onValidateInput: (String, String) -> String,
    onTargetClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "De: ",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium
        )
        CurrencySelect(
            modifier = Modifier.padding(8.dp),
            currencyName = viewState.source,
            onClick = {},
        )
        Text(
            text = "Para: ",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium
        )
        CurrencySelect(
            modifier = Modifier.padding(8.dp),
            currencyName = viewState.target,
            onClick = onTargetClick,
        )
        Text(
            text = stringResource(R.string.currency_to_convert_value),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium
        )
        var value by remember { mutableStateOf(value = "") }
        OutlinedTextField(
            value = value,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = TextStyle(MaterialTheme.colorScheme.secondary),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
            ),
            onValueChange = { newValue: String ->
                value = onValidateInput(newValue, value)

                onInputUpdate(value)
            }
        )
        Text(
            text = stringResource(R.string.currency_result),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium
        )

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = viewState.result,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun CurrencySelect(
    modifier: Modifier,
    currencyName: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.secondaryContainer,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = currencyName
        )
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.End
        ) {
            IconButton(onClick = onClick) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Selecionar a moeda",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }

        }
    }
}

@Composable
fun ScreenLoading(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
        )
    }

}

@Preview
@Composable
private fun ContentCurrencyConventerScreenPreview() {
    BTGCurrencyConverterTheme {
        ContentCurrencyConverterScreen(
            modifier = Modifier,
            viewState = CurrencyConverterViewState(
                result = "33"
            ),
            onInputUpdate = {},
            onTargetClick = {
                println("target clicked")
            },
            onValidateInput = { _, _ -> "" }
        )
    }
}


@Preview
@Composable
private fun CurrencySelectPreview() {
    BTGCurrencyConverterTheme {
        CurrencySelect(
            modifier = Modifier,
            currencyName = "BRL",
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun ScreenLoadingPreview() {
    BTGCurrencyConverterTheme {
        ScreenLoading(
            modifier = Modifier,
        )
    }
}