package com.example.btgcurrencyconverter.feature.CurrencyConverter.ui

import android.R.attr.content
import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btgcurrencyconverter.CurrencyConventer
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency
import com.example.btgcurrencyconverter.ui.theme.BTGCurrencyConverterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConventerScreen(
    modifier: Modifier,
    result: Double,
) {

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
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                currencyName = "BRL",
                onClick = {},
            )
            Text(
                text = "Para: ",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium
            )
            CurrencySelect(
                modifier = Modifier.padding(8.dp),
                currencyName = "BRL",
                onClick = {},
            )
            Text(
                text = "Valor: ",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium
            )
            var value by remember {
                mutableStateOf(value = "")
            }
            OutlinedTextField(
                value = value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 1.dp,
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                textStyle = TextStyle(MaterialTheme.colorScheme.secondary),
                onValueChange = { newValue ->
                    value = newValue
                }
            )
            Text(
                text = "Resultado: ",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium
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
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    text = result.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )
            }

        }

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

@Preview
@Composable
private fun CurrencyConventerScreenPreview() {
    BTGCurrencyConverterTheme {
        CurrencyConventerScreen(
            modifier = Modifier,
            result = 20.0,
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