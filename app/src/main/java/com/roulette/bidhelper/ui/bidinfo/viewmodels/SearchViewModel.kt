package com.roulette.bidhelper.ui.bidinfo.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roulette.bidhelper.models.viewmodels.BidConstBasisAmountViewModel
import com.roulette.bidhelper.ui.bidinfo.spinners.firstCategoryList_1
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.secondCategoryList_1_1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchUiState(
    var mainCategory: String = mainCategoryList[0],
    var firstCategory: String = firstCategoryList_1[0],
    var secondCategory: String = secondCategoryList_1_1[0],
    var locale: String = "",
    var dateFrom: String = "",
    var dateTo: String = "",
    var priceType: String = "",
    var minPrice: String = "",
    var maxPrice: String = "",
    var searchName: String = ""
)

class SearchViewModel: ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    fun updateUIState(
        mainCategory: String = uiState.mainCategory,
        firstCategory: String = uiState.firstCategory,
        secondCategory: String = uiState.secondCategory,
        locale: String = uiState.locale,
        dateFrom: String = uiState.dateFrom,
        dateTo: String = uiState.dateTo,
        priceType: String = uiState.priceType,
        minPrice: String = uiState.minPrice,
        maxPrice: String = uiState.maxPrice,
        searchName: String = uiState.searchName,
    ) {
        uiState = SearchUiState(
            mainCategory = mainCategory,
            firstCategory = firstCategory,
            secondCategory = secondCategory,
            locale = locale,
            dateFrom = dateFrom,
            dateTo = dateTo,
            priceType = priceType,
            minPrice = minPrice,
            maxPrice = maxPrice,
            searchName = searchName
        )
    }

}