package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer.bidServiceAfter
import com.roulette.bidhelper.models.apis.BidResultUiState
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.after.BidStatusConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.after.BidStatusServiceSearchDTO
import com.roulette.bidhelper.models.apis.after.BidStatusThingSearchDTO
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
        }

        Log.d(TAG, bidSearch.inqryBgnDt+" " +bidSearch.inqryEndDt)
        when (uiState.mainCategory) {
            mainCategoryList[1] -> getStatusConstWorkList(bidSearch)
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
                if(body?.response?.body?.items != null)
                    bidResultUiState = BidResultUiState.Success(body.response.body.items)
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