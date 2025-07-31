package com.example.btgcurrencyconverter.feature.CurrencyListScreen.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.Currency
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.CurrencyListViewModel
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.CurrencyListViewState
import com.example.btgcurrencyconverter.ui.theme.BTGCurrencyConverterTheme
import java.time.format.TextStyle

@Composable
fun CurrencyListScreen(
    modifier: Modifier = Modifier,
    viewModel: CurrencyListViewModel,
    onClick: (Currency) -> Unit,
) {
    val viewState by viewModel.viewState.collectAsState()

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        items(
            items = viewState.list,
            key = null,
        ) {
            CurrencyItem(
                name = it.name,
                isSelected = it.isSelected,
                onClick = { onClick(it) },
            )
            Spacer(
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}

@Composable
fun CurrencyItem(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onClick: (Currency) -> Unit,
) {
    OutlinedButton(
        modifier = Modifier.padding(4.dp),
        onClick = {onClick},
        shape = ShapeDefaults.Medium,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            text = name,
            textAlign = TextAlign.Center,
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