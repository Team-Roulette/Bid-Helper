package com.roulette.bidhelper.ui.bidinfo

import android.content.Context
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.roulette.bidhelper.R
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.before.SearchItem
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoListViewModel
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoPreciseViewModel
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoSearchViewModel
import com.roulette.bidhelper.ui.bidinfo.viewmodels.SearchViewModelFactory

private const val TAG = "BidInfoScreen"

enum class BidInfoScreen {
    Search,
    List,
    Precise,
    Industry
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
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStartEntry by navController.currentBackStackEntryAsState()
    var selectedItem: SearchItem? = null

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("FilterDB", Context.MODE_PRIVATE)
    val factory = SearchViewModelFactory(sharedPreferences)
    val searchViewModel: BidInfoSearchViewModel = viewModel(factory = factory)
    val listViewModel: BidInfoListViewModel = BidInfoListViewModel()
    val preciseViewModel: BidInfoPreciseViewModel = BidInfoPreciseViewModel()

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
        ) {
            composable(route = BidInfoScreen.Search.name) {
                SearchScreen(
                    viewModel = searchViewModel,
                    onNextButtonClicked = {
                        val param = setBidSearch(searchViewModel)
                        listViewModel.getBidSearchResult(searchViewModel.uiState.mainCategory, param)
                        navController.navigate(BidInfoScreen.List.name)
                    },
                    onResetButtonClicked = {
                        searchViewModel.resetFilter()
                    },
                    onIndustryTextClicked = {
                        navController.navigate(BidInfoScreen.Industry.name)
                    }
                )
            }

            composable(route = BidInfoScreen.List.name) {
                ListScreen(
                    viewModel = listViewModel,
                    onItemClicked = { item ->
                        preciseViewModel.selectItem(item)
                        navController.navigate(BidInfoScreen.Precise.name) {
                            anim {
                                enter = R.anim.slide_in_right // 새 화면이 오른쪽에서 들어옴
                                exit = R.anim.slide_out_left // 현재 화면이 왼쪽으로 나감
                                popEnter = R.anim.slide_out_left // 이전 화면이 왼쪽에서 들어옴
                                popExit = R.anim.slide_out_right // 현재 화면이 오른쪽으로 나감
                            }
                        }
                    }
                )
            }
            composable(route = BidInfoScreen.Precise.name) {
                PreciseScreen(
                    viewModel = preciseViewModel
                )
            }
            composable(route = BidInfoScreen.Industry.name) {
                IndustrySearchScreen(
                    onClick = {
                        Log.d(TAG, it[R.string.industry_search_industry_name]!!)
                        searchViewModel.updateUIState(
                            industryName = it[R.string.industry_search_industry_name]!!
                        )
                        navController.navigateUp()
                    }
                )
            }

        }
    }
}

fun setBidSearch(searchViewModel: BidInfoSearchViewModel): BidSearch {

    val bidMinPrice = ((searchViewModel.uiState.minPrice.ifEmpty { "0" }).toInt() * 100000000)
    val bidMaxPrice = ((searchViewModel.uiState.maxPrice.ifEmpty { "0" }).toInt() * 100000000)

    return BidSearch().apply {
        numOfRows = "10"
        pageNo = "1"
        inqryDiv = "1"
        searchViewModel.apply {
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
            presmptPrceBgn = if(bidMinPrice == 0) null else bidMinPrice.toString()
            presmptPrceEnd = if(bidMaxPrice == 0) null else bidMaxPrice.toString()
            prtcptLmtRgnNm = if(uiState.locale == placeCategoryList[0]) null else uiState.locale
            bidNtceNm = uiState.searchName.ifEmpty { null }
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
        "Industry" -> "입찰정보 - 상세검색 - 업종검색"
        else -> "입찰정보 - 상세검색"
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BidInfoPreview() {
    BidInfoScreen()
}