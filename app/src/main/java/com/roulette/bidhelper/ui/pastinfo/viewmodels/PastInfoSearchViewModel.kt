package com.roulette.bidhelper.ui.pastinfo.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import java.time.LocalDate
import java.time.format.DateTimeFormatter


private const val TAG = "PastInfoSharedViewModel"

data class PastInfoUiState(
    var mainCategory: String = mainCategoryList[0],
    var firstCategory: String = "",
    var secondCategory: String = "",
    var locale: String = placeCategoryList[0],
    var dateFrom: String = "",
    var dateTo: String = "",
    var priceType: String = "",
    var minPrice: String = "",
    var maxPrice: String = "",
    var industryName: String = "",
    var searchName: String = ""
)

class PastInfoSearchViewModel : ViewModel() {
    var uiState by mutableStateOf(PastInfoUiState())

    init {
        updateUIState(
            dateFrom = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
            dateTo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        )
    }


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
        industryName: String = uiState.industryName,
        searchName: String = uiState.searchName
    ) {
        uiState = PastInfoUiState(
            mainCategory = mainCategory,
            firstCategory = firstCategory,
            secondCategory = secondCategory,
            locale = locale,
            dateFrom = dateFrom,
            dateTo = dateTo,
            priceType = priceType,
            minPrice = minPrice,
            maxPrice = maxPrice,
            industryName = industryName,
            searchName = searchName
        )
    }
    fun resetFilter() {
        uiState = PastInfoUiState(
            dateFrom = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
            dateTo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        )
    }
}