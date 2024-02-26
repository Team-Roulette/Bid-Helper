package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer.bidServiceAfter
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.BidStatusConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.BidStatusServiceSearchDTO
import com.roulette.bidhelper.models.apis.Item
import com.roulette.bidhelper.models.apis.BidStatusThingSearchDTO
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
    var searchName: String = ""
)

sealed interface BidResultUiState {
    data class Success(val items: List<Item>) : BidResultUiState
    data object Error : BidResultUiState
    data object Loading : BidResultUiState
}

class PastInfoSharedViewModel : ViewModel() {
    var uiState by mutableStateOf(PastInfoUiState())

    var bidResultUiState: BidResultUiState by mutableStateOf(BidResultUiState.Loading)
        private set

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
            searchName = searchName
        )
    }

    fun setPastInfoSearchList() {
        bidResultUiState = BidResultUiState.Loading
        val bidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "1"
        }
        when (uiState.mainCategory) {
            mainCategoryList[1] -> getStatusConstWorkList(bidSearch)
            mainCategoryList[2] -> getStatusThingSearchList(bidSearch)
            mainCategoryList[3] -> getStatusServiceSearchList(bidSearch)
            else -> {
                Log.d(TAG, "누구 맘대로 알바감?")
            }
        }
    }

    private fun getStatusThingSearchList(param: BidSearch){
        bidServiceAfter.getBidStatusThingSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusThingSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusThingSearchDTO>,
                response: Response<BidStatusThingSearchDTO>
            ) {
                val body = response.body()
                bidResultUiState = BidResultUiState.Success(
                    body?.response?.body?.items!!
                )
            }

            override fun onFailure(call: Call<BidStatusThingSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }
        })
    }

    private fun getStatusConstWorkList(param: BidSearch){
        bidServiceAfter.getBidStatusConstWorkSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusConstWorkSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusConstWorkSearchDTO>,
                response: Response<BidStatusConstWorkSearchDTO>
            ) {
                val body = response.body()
                bidResultUiState = BidResultUiState.Success(
                    body?.response?.body?.items!!
                )
            }

            override fun onFailure(call: Call<BidStatusConstWorkSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }
        })
    }

    private fun getStatusServiceSearchList(param: BidSearch){
        bidServiceAfter.getBidStatusServiceSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusServiceSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusServiceSearchDTO>,
                response: Response<BidStatusServiceSearchDTO>
            ) {
                val body = response.body()
                bidResultUiState = BidResultUiState.Success(
                    body?.response?.body?.items!!
                )
            }

            override fun onFailure(call: Call<BidStatusServiceSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }
        })
    }

}