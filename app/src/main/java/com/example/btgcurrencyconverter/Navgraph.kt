package com.example.btgcurrencyconverter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import kotlinx.serialization.Serializable

@Serializable
data object CurrencyConventer

@Composable
fun MainNavGraph(){
    val navController = rememberNavController()

    val navGraph = remember(navController){
        navController.createGraph (
            startDestination = CurrencyConventer
        ) {
            composable<CurrencyConventer>{
               // val viewModel = viewModel<CurrencyConventerViewModel>
            }
        }
    }
}