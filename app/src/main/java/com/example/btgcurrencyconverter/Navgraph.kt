package com.example.btgcurrencyconverter

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.btgcurrencyconverter.data.database.createRoomDatabaseInstance
import com.example.btgcurrencyconverter.data.network.RetrofitInstance
import com.example.btgcurrencyconverter.domain.CurrencyRepository
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

    val navGraph = remember(navController) {
        navController.createGraph(
            startDestination = CurrencyConverter
        ) {
            composable<CurrencyConverter> {
                val viewModel = hiltViewModel<CurrencyConverterViewModel>()
                CurrencyConventerScreen(
                    modifier = Modifier,
                    viewModel = viewModel,
                    onClick = {
                        navController.navigate(
                            CurrencyList
                        )
                    }
                )
            }
            composable<CurrencyList> {
                val viewModel = viewModel<CurrencyListViewModel>()
                CurrencyListScreen(
                    modifier = Modifier,
                    viewModel = viewModel,
                    list = emptyList(),
                    onClick = {
                        navController.navigate(
                            CurrencyConverter,
                        )
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