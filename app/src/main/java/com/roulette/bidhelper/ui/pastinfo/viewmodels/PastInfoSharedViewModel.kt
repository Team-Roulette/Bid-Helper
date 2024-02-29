package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.OnPastInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidResultUiState
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


private const val TAG = "PastInfoSharedViewModel"

data class PastInfoUiState(
    var mainCategory: String = "",
    var firstCategory: String = "",
    var secondCategory: String = "",
    var locale: String = "",
    var dateFrom: String = "",
    var dateTo: String = "",
    var priceType: String = "",
    var minPrice: String = "",
    var maxPrice: String = "",
    var industryName: String = "",
    var searchName: String = ""
)



class PastInfoSharedViewModel : ViewModel() {
    var uiState by mutableStateOf(PastInfoUiState())

    var bidResultUiState: BidResultUiState by mutableStateOf(BidResultUiState.Loading)
        private set

    var item: Item by mutableStateOf(Item("","","","",
        "","","","","","",
        "","","","","","",
        "","","","",""))

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

    fun setPastInfoSearchList() {
        bidResultUiState = BidResultUiState.Loading

        val bidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "1"
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
        }

        Log.d(TAG, bidSearch.inqryBgnDt+" " +bidSearch.inqryEndDt)
        when (uiState.mainCategory) {
            mainCategoryList[1] -> getStatusConstWorkSearchList(bidSearch)
            mainCategoryList[2] -> getStatusThingSearchList(bidSearch)
            mainCategoryList[3] -> getStatusServiceSearchList(bidSearch)
            else -> {
            }
        }
    }

    private fun getFormattedDate(date: String, time:String): String {
        val originalFormatString = "yyyy/MM/dd"
        val newFormatString = "yyyyMMdd"

        val originalFormat = SimpleDateFormat(originalFormatString, Locale.getDefault())
        val newFormat = SimpleDateFormat(newFormatString, Locale.getDefault())

        val formattedDate = originalFormat.parse(date)!!
        return newFormat.format(formattedDate)+time
    }

    private fun getStatusThingSearchList(param: BidSearch){
        RequestServer.getBidStatusThingSearch(param, object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>){
                bidResultUiState = BidResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }
    private fun getStatusConstWorkSearchList(param: BidSearch){
        RequestServer.getBidStatusConstWorkSearch(param, object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>){
                bidResultUiState = BidResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }

    private fun getStatusServiceSearchList(param: BidSearch){
        Log.i(TAG, "items.toString()")
        RequestServer.getBidStatusServiceSearch(param, object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>){
                bidResultUiState = BidResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }


}