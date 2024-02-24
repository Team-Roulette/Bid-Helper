@file:JvmName("BidInfoListViewModelKt")

package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidConstBasisAmountDTO
import com.roulette.bidhelper.models.apis.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "SearchViewModel"

data class SearchUiState(
    var mainCategory: String = "",
    var firstCategory: String = "",
    var secondCategory: String = "",
    var locale: String = "",
    var dateFrom: String = "",
    var dateTo: String = "",
    var priceType: String = "",
    var minPrice: String = "",
    var maxPrice: String = "",
    var searchName: String = ""
)

class BidInfoSearchViewModel(private val sharedPreferences: SharedPreferences)  : ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    private val _bidConstWorkSearch = MutableLiveData<BidConstWorkSearchDTO>()
    val bidConstWorkSearch: LiveData<BidConstWorkSearchDTO> = _bidConstWorkSearch

    init {
        updateUIState(
            mainCategory = sharedPreferences.getString("mainCategory", mainCategoryList[0])!!,
            firstCategory = sharedPreferences.getString("firstCategory",
                if(uiState.mainCategory == mainCategoryList[0]) "업종구분을 먼저 선택하세요" else "")!!,
            secondCategory = sharedPreferences.getString("secondCategory",
                if(uiState.mainCategory == "업종구분을 먼저 선택하세요") "1차업종구분을 먼저 선택하세요" else "")!!,
            locale = sharedPreferences.getString("locale", placeCategoryList[0])!!
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
        searchName: String = uiState.searchName,
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
            searchName = searchName
        )
    }

    fun getBidConstWorkSearch() {
        val param: BidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "1"
        }

        RequestServer.bidServiceBefore.getBidConstWorkSearch(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            type = param.type,
            bidNtceNm = param.bidNtceNm,
            ntceInsttCd = param.ntceInsttCd,
            ntceInsttNm = param.ntceInsttNm,
            dminsttCd = param.dminsttCd,
            dminsttNm = param.dminsttNm,
            refNo = param.refNo,
            prtcptLmtRgnCd = param.prtcptLmtRgnCd,
            prtcptLmtRgnNm = param.prtcptLmtRgnNm,
            indstrytyCd = param.indstrytyCd,
            indstrytyNm = param.indstrytyNm,
            presmptPrceBgn = param.presmptPrceBgn,
            presmptPrceEnd = param.presmptPrceEnd,
            dtilPrdctClsfcNoNm = param.dtilPrdctClsfcNoNm,
            masYn = param.masYn,
            prcrmntReqNo = param.prcrmntReqNo,
            bidClseExcpYn = param.bidClseExcpYn,
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidConstWorkSearchDTO> {
            override fun onResponse(
                call: Call<BidConstWorkSearchDTO>,
                response: Response<BidConstWorkSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
                _bidConstWorkSearch.value = body
            }

            override fun onFailure(call: Call<BidConstWorkSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
                _bidConstWorkSearch.value = null
            }

        })
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