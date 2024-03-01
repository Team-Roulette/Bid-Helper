package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roulette.bidhelper.functions.RequestServer.getBidConstWorkSearch
import com.roulette.bidhelper.functions.RequestServer.getBidServiceSearch
import com.roulette.bidhelper.functions.RequestServer.getBidThingSearch
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import com.roulette.bidhelper.ui.pastinfo.viewmodels.PastInfoUiState
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

private const val TAG = "SearchViewModel"

data class SearchUiState(
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

class BidInfoSearchViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    init {
        /*updateUIState(
            mainCategory = sharedPreferences.getString("mainCategoryList", mainCategoryList[0])!!,
            firstCategory = sharedPreferences.getString("firstCategoryList",
                if(uiState.mainCategory == mainCategoryList[0]) "업종구분을 먼저 선택하세요" else "")!!,
            secondCategory = sharedPreferences.getString("secondCategoryList",
                if(uiState.mainCategory == "업종구분을 먼저 선택하세요") "1차업종구분을 먼저 선택하세요" else "")!!,
            locale = sharedPreferences.getString("locationCategoryList", placeCategoryList[0])!!
        )
        val properties = uiState::class.memberProperties
            .filterIsInstance<KMutableProperty<*>>()

        sharedPreferences.all.forEach { (key, value) ->
            val property = properties.find { it.name == key }
            property?.let {
                it.isAccessible = true
                when (val v = it.getter.call(uiState)) {
                    is String -> it.setter.call(uiState, value.toString())
                    // 다른 타입의 프로퍼티가 있을 경우 여기에 처리 로직 추가
                    // 예: is Int -> it.setter.call(uiState, value.toString().toInt())
                }
            }
        }*/

        resetFilter()
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
        Log.d(TAG, "$mainCategory , $firstCategory, $secondCategory")

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
            industryName = industryName,
            searchName = searchName
        )
    }

    fun resetFilter() {
        uiState = SearchUiState(
            dateFrom = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
            dateTo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        )
    }

    fun getFormattedDate(date: String, time:String): String {
        val originalFormatString = "yyyy/MM/dd"
        val newFormatString = "yyyyMMdd"

        val originalFormat = SimpleDateFormat(originalFormatString, Locale.getDefault())
        val newFormat = SimpleDateFormat(newFormatString, Locale.getDefault())

        val formattedDate = originalFormat.parse(date)!!
        return newFormat.format(formattedDate)+time
    }
}

class SearchViewModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BidInfoSearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BidInfoSearchViewModel(sharedPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}