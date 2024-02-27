package com.roulette.bidhelper.ui.filter.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

private const val TAG = "FilterViewModel"

data class SearchUiState(
    var mainCategory: String = "",
    var firstCategory: String = "",
    var secondCategory: String = "",
    var locale: String = "",
    var priceType: String = "",
    var minPrice: String = "",
    var maxPrice: String = ""
)

class FilterViewModel(private val sharedPreferences: SharedPreferences)  : ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    init {
//        updateUIState(
//            mainCategory = sharedPreferences.getString("mainCategoryList", mainCategoryList[0])!!,
//            firstCategory = sharedPreferences.getString("firstCategoryList",
//                if(uiState.mainCategory == mainCategoryList[0]) "업종구분을 먼저 선택하세요" else "")!!,
//            secondCategory = sharedPreferences.getString("secondCategoryList",
//                if(uiState.mainCategory == "업종구분을 먼저 선택하세요") "1차업종구분을 먼저 선택하세요" else "")!!,
//            locale = sharedPreferences.getString("locationCategoryList", placeCategoryList[0])!!
//        )
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
        }
    }

    fun updateUIState(
        mainCategory: String = uiState.mainCategory,
        firstCategory: String = uiState.firstCategory,
        secondCategory: String = uiState.secondCategory,
        locale: String = uiState.locale,
        priceType: String = uiState.priceType,
        minPrice: String = uiState.minPrice,
        maxPrice: String = uiState.maxPrice
    ) {
        Log.d(TAG, "$mainCategory , $firstCategory, $secondCategory")

        uiState = SearchUiState(
            mainCategory = mainCategory,
            firstCategory = firstCategory,
            secondCategory = secondCategory,
            locale = locale,
            priceType = priceType,
            minPrice = minPrice,
            maxPrice = maxPrice
        )
    }
}

class FilterViewModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilterViewModel(sharedPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}