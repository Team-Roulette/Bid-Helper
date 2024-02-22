package com.roulette.bidhelper.ui.bidinfo

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.roulette.bidhelper.ui.bidinfo.viewmodels.SearchViewModel

enum class BidInfoScreen {
    Search,
    List,
    Precise
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidInfoTopAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = getTitle(currentScreen)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        })
}

@Composable
fun BidInfoScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val backStartEntry by navController.currentBackStackEntryAsState()
    val sharedViewModel: SearchViewModel = viewModel()
    Scaffold(
        topBar = {
            BidInfoTopAppBar(
                currentScreen = backStartEntry?.destination?.route?: BidInfoScreen.Search.name,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
            ) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BidInfoScreen.Search.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = BidInfoScreen.Search.name) {
                SearchScreen(
                    viewModel = sharedViewModel,
                    onNextButtonClicked = {
                        sharedViewModel.getBidConstWorkSearch()
                        sharedViewModel.getBidConstBasisAmount()
                        navController.navigate(BidInfoScreen.List.name)
                    }
                )
            }

            composable(route = BidInfoScreen.List.name) {
                ListScreen(
                    viewModel = sharedViewModel,
                    onItemClicked = {
                        navController.navigate(BidInfoScreen.Precise.name)
                    }
                )
            }
            composable(route = BidInfoScreen.Precise.name) {
                PreciseScreen()
            }
        }
    }
}

private fun getTitle(
    currentScreen: String
): String {
    return when(currentScreen){
        "Search" -> "입찰정보 - 상세검색"
        "List" -> "입찰정보 - 리스트"
        "Precise" -> "공고 정보"
        else -> "입찰정보 - 상세검색"
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BidInfoPreview() {
    BidInfoScreen()
}