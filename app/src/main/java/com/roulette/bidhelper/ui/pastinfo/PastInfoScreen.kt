package com.roulette.bidhelper.ui.pastinfo

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.BidInfoScreen
import com.roulette.bidhelper.ui.bidinfo.IndustrySearchScreen
import com.roulette.bidhelper.ui.pastinfo.viewmodels.PastInfoSharedViewModel

enum class PastInfoScreen {
    Search,
    List,
    Precise,
    Industry
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PastInfoTopAppBar(
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
fun PastInfoScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val backStartEntry by navController.currentBackStackEntryAsState()
    val sharedViewModel: PastInfoSharedViewModel = viewModel()

    Scaffold(
        topBar = {
            PastInfoTopAppBar(
                currentScreen = backStartEntry?.destination?.route?: PastInfoScreen.Search.name,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = modifier
            ) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PastInfoScreen.Search.name,
            modifier = modifier.padding(innerPadding)
        ){
            composable(route = PastInfoScreen.Search.name) {
                PastInfoSearchScreen(
                    viewModel = sharedViewModel,
                    onNextButtonClicked = {
                        sharedViewModel.setPastInfoSearchList()
                        navController.navigate(PastInfoScreen.List.name)
                    },
                    onIndustryTextClicked = {
                        navController.navigate(BidInfoScreen.Industry.name)
                    }
                )
            }

            composable(route = PastInfoScreen.List.name) {
                PastInfoListScreen(
                    viewModel = sharedViewModel,
                    onItemClicked = {clickedItem ->
                        sharedViewModel.item = clickedItem
                        navController.navigate(PastInfoScreen.Precise.name)
                    }
                )
            }

            composable(route = PastInfoScreen.Precise.name) {
                PastInfoPreciseScreen(item = sharedViewModel.item)
            }

            composable(route = BidInfoScreen.Industry.name) {
                IndustrySearchScreen(
                    onClick = {
                        sharedViewModel.updateUIState(
                            industryName = it[R.string.industry_search_industry_name]!!
                        )
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

private fun getTitle(
    currentScreen: String
): String {
    return when(currentScreen){
        "Search" -> "낙찰정보 - 상세검색"
        "List" -> "낙찰정보 - 리스트"
        "Precise" -> "공고 정보"
        else -> "낙찰정보 - 상세검색"
    }
}