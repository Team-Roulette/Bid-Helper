package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roulette.bidhelper.functions.OnPastInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoSearchViewModel
import java.text.SimpleDateFormat
import java.util.Locale

private const val TAG = "PastInfoListViewModel"

sealed interface PastResultUiState {
    data class Success(val items: List<Item>) : PastResultUiState
    data object Error : PastResultUiState
    data object Loading : PastResultUiState
}

class PastInfoListViewModel(
    private val uiState: PastInfoUiState
): ViewModel() {

    var pastResultUiState: PastResultUiState by mutableStateOf(PastResultUiState.Loading)
        private set

    init {
        setPastInfoSearchList()
    }

    private fun setPastInfoSearchList() {
        pastResultUiState = PastResultUiState.Loading

        val bidMinPrice = ((uiState.minPrice.ifEmpty { "0" }).toInt() * 100000000)
        val bidMaxPrice = ((uiState.maxPrice.ifEmpty { "0" }).toInt() * 100000000)

        val bidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "2"
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
            presmptPrceBgn = if(bidMinPrice == 0) null else bidMinPrice.toString()
            presmptPrceEnd = if(bidMaxPrice == 0) null else bidMaxPrice.toString()
            prtcptLmtRgnNm = if(uiState.locale == placeCategoryList[0]) null else uiState.locale
            bidNtceNm = uiState.searchName.ifEmpty { null }
        }

        Log.d(TAG,
            bidSearch.inqryBgnDt+"\n"+
                    bidSearch.inqryEndDt+"\n"+
                    bidSearch.presmptPrceBgn+"\n"+
                    bidSearch.presmptPrceEnd+"\n"+
                    bidSearch.prtcptLmtRgnNm+"\n"+
                    bidSearch.bidNtceNm)

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
                pastResultUiState = PastResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }
    private fun getStatusConstWorkSearchList(param: BidSearch){
        RequestServer.getBidStatusConstWorkSearch(param, object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>){
                pastResultUiState = PastResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }

    private fun getStatusServiceSearchList(param: BidSearch){
        Log.i(TAG, "items.toString()")
        RequestServer.getBidStatusServiceSearch(param, object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>){
                pastResultUiState = PastResultUiState.Success(items)
                //items : 응답 아이템
                Log.i(TAG, items.toString())
            }
        })
    }
}

class PastListViewModelFactory(private val uiState: PastInfoUiState) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PastInfoListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PastInfoListViewModel(uiState) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}