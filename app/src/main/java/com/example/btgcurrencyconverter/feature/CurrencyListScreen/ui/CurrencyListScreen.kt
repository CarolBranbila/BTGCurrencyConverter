package com.example.btgcurrencyconverter.feature.CurrencyListScreen.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.CurrencyListViewState
import com.example.btgcurrencyconverter.ui.theme.BTGCurrencyConverterTheme

@Composable
fun CurrencyListScreen(
    modifier: Modifier = Modifier,
    list: List<Currency>,
    onClick: (Currency) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        items(
            items = list,
            key = null,
        ) {
            CurrencyItem(
                name = it.name,
                isSelected = it.isSelected,
                onClick = { onClick (it)},
            )
        }
    }
}

@Composable
fun CurrencyItem(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onClick: (Currency) -> Unit
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