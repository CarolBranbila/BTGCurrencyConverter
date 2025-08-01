package com.example.btgcurrencyconverter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.btgcurrencyconverter.feature.CurrencyConverter.presentation.CurrencyConverterViewModel
import com.example.btgcurrencyconverter.feature.CurrencyConverter.ui.CurrencyConventerScreen
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.presentation.CurrencyListViewModel
import com.example.btgcurrencyconverter.feature.CurrencyListScreen.ui.CurrencyListScreen
import kotlinx.serialization.Serializable

@Serializable
data object CurrencyConverter

@Serializable
data object CurrencyList

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    val converterViewModel = hiltViewModel<CurrencyConverterViewModel>()

    val navGraph = remember(navController) {
        navController.createGraph(
            startDestination = CurrencyConverter
        ) {
            composable<CurrencyConverter> {
                CurrencyConventerScreen(
                    modifier = Modifier,
                    viewModel = converterViewModel,
                    onClick = {
                        navController.navigate(
                            CurrencyList
                        )
                    }
                )
            }
            composable<CurrencyList> { entry ->
                val viewModel = hiltViewModel<CurrencyListViewModel>()
                CurrencyListScreen(
                    modifier = Modifier,
                    viewModel = viewModel,
                    onClick = { currencyID ->
                        converterViewModel.setSelectedCurrency(currencyID)
                        navController.popBackStack()
                    }
                )
            }


        }
    }
    NavHost(
        navController = navController,
        graph = navGraph,
    )

}