package com.example.btgcurrencyconverter.feature.CurrencyListScreen.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btgcurrencyconverter.ui.theme.BTGCurrencyConverterTheme

@Composable
fun CurrencyItem(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.border(
                width = 1.dp,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.secondaryContainer,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(24.dp),
            text = name,
        )
    }
}


@Preview
@Composable
private fun CurrencyItemPreview() {
    BTGCurrencyConverterTheme {
        Column {
            CurrencyItem(
                name = "AED:United Arab Emirates Dirham",
                isSelected = false,
                onClick = { },
            )
            CurrencyItem(
                name = "AED:United Arab Emirates",
                isSelected = false,
                onClick = { },
            )
            CurrencyItem(
                name = "AED:United Arab Emirates",
                isSelected = false,
                onClick = { },
            )
        }
        
    }
}