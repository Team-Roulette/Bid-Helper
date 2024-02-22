@file:JvmName("BidInfoListViewModelKt")

package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

class SearchViewModel : ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    private val _bidConstBasisAmount = MutableLiveData<BidConstBasisAmountDTO>()
    val bidConstBasisAmount: LiveData<BidConstBasisAmountDTO> = _bidConstBasisAmount


    private val _bidConstWorkSearch = MutableLiveData<BidConstWorkSearchDTO>()
    val bidConstWorkSearch: LiveData<BidConstWorkSearchDTO> = _bidConstWorkSearch

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

    fun getBidConstBasisAmount() {
        /*viewModelScope.launch {
            val bid = BidConstBasisAmountViewModel()

            val bidAmountInfo: BidAmountInfo = BidAmountInfo().apply {
                numOfRows = "10"
                pageNo = "1"
                inqryDiv = "1"
            }

            Log.d(TAG, "$bidAmountInfo")
            Log.d(TAG, bidAmountInfo.inqryBgnDt)
            Log.d(TAG, bidAmountInfo.inqryEndDt)
            Log.d(TAG, bidAmountInfo.inqryDiv!!)

            withContext(Dispatchers.IO) {
                bid.setBidConstBasisAmount(bidAmountInfo)
                val num = bid.bidConstBasisAmount
            }
        }*/
        viewModelScope.launch {
            val bidAmountInfo: BidAmountInfo = BidAmountInfo().apply {
                numOfRows = "10"
                pageNo = "1"
                inqryDiv = "1"
                bidNtceNo = "1"
            }

            Log.d(TAG, "${bidAmountInfo.numOfRows}")
            Log.d(TAG, "${bidAmountInfo.pageNo}")
            Log.d(TAG, bidAmountInfo.serviceKey)
            Log.d(TAG, "${bidAmountInfo.inqryDiv}")
            Log.d(TAG, bidAmountInfo.inqryBgnDt)
            Log.d(TAG, bidAmountInfo.inqryEndDt)
            Log.d(TAG, "${bidAmountInfo.bidNtceNo}")
            Log.d(TAG, bidAmountInfo.type)

            setBidConstBasisAmount(bidAmountInfo)

            _bidConstBasisAmount.value?.response?.body?.items?.get(0)?.bssamt?.let {
                Log.d(
                    TAG,
                    "value: $it"
                )
            }
        }
    }

    private fun setBidConstBasisAmount(param: BidAmountInfo) {
        RequestServer.bidServiceBefore.getBidConstBasisAmount(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidConstBasisAmountDTO> {
            override fun onResponse(
                call: Call<BidConstBasisAmountDTO>,
                response: Response<BidConstBasisAmountDTO>
            ) {
                val body = response.body()!!
                Log.d(TAG, body.response.body.totalCount)
                Log.d(TAG, body.response.header.resultCode)
                _bidConstBasisAmount.value = body

            }

            override fun onFailure(call: Call<BidConstBasisAmountDTO>, t: Throwable) {
                Log.d(TAG, t.message.toString())
                _bidConstBasisAmount.value = null
            }
        })
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