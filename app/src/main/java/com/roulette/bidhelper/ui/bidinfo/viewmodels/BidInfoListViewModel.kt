package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidInfoUiState
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.before.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.before.BidServiceSearchDTO
import com.roulette.bidhelper.models.apis.before.BidThingSearchDTO
import com.roulette.bidhelper.models.apis.before.SearchItem
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale

private const val TAG = "BidInfoListViewModel"

class BidInfoListViewModel : ViewModel() {
    var bidInfoList: MutableState<List<SearchItem>?> = mutableStateOf(null)

    var uiState: BidInfoUiState by mutableStateOf(BidInfoUiState.Loading)
        private set

//    private val _bidConstWorkSearch = MutableLiveData<BidConstWorkSearchDTO>()
//    val bidConstWorkSearch: LiveData<BidConstWorkSearchDTO> = _bidConstWorkSearch
//
//    private val _bidItemSearch = MutableLiveData<List<Item>>()
//    val bidItemSearch: LiveData<List<Item>> = _bidItemSearch
//
//    private val _selectedItem = MutableLiveData<Item>()
//    val selectedItem: LiveData<Item> = _selectedItem

//    fun selectItem(item: Item) {
//        _selectedItem.value = item
//    }

    /* fun setPastInfoSearchList() {
        uiState = ResultUiState.Loading

        val bidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "1"
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
        }

        Log.d(TAG, bidSearch.inqryBgnDt+" " +bidSearch.inqryEndDt)
        when (uiState.mainCategory) {
            mainCategoryList[1] -> getBidConstWorkSearch(bidSearch)
            mainCategoryList[2] -> getBidConstWorkSearch(bidSearch)
            mainCategoryList[3] -> getBidConstWorkSearch(bidSearch)
            else -> {
                getBidConstWorkSearch(bidSearch)
            }
        }
    } */
    fun getBidSearchResult(category: String, param: BidSearch) {
        when(category) {
            mainCategoryList[1] -> getBidConstWorkSearch(param)
            mainCategoryList[2] -> getBidThingSearch(param)
            mainCategoryList[3] -> getBidServiceSearch(param)
        }
    }

    private fun getBidConstWorkSearch(param: BidSearch) {
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
                val list = body.response.body.items
                bidInfoList.value = list
                uiState = BidInfoUiState.Success(list)
            }

            override fun onFailure(call: Call<BidConstWorkSearchDTO>, t: Throwable) {

                Log.e("test", t.message.toString())
                //_bidConstWorkSearch.value = null
            }
        })
    }

    private fun getBidThingSearch(param: BidSearch) {
        RequestServer.bidServiceBefore.getBidThingSearch(
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
        ).enqueue(object : Callback<BidThingSearchDTO> {
            override fun onResponse(
                call: Call<BidThingSearchDTO>,
                response: Response<BidThingSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
                val list = body.response.body.items
                uiState = BidInfoUiState.Success(list)
                bidInfoList.value = list
            }

            override fun onFailure(call: Call<BidThingSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    private fun getBidServiceSearch(param: BidSearch) {
        RequestServer.bidServiceBefore.getBidServiceSearch(
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
        ).enqueue(object : Callback<BidServiceSearchDTO> {
            override fun onResponse(
                call: Call<BidServiceSearchDTO>,
                response: Response<BidServiceSearchDTO>
            ) {
                val body = response.body()!!
//                Log.i("test", body.response.body.items[0].bidNtceNm)
//                Log.i("test", body.response.body.totalCount)
                val list = body.response.body.items
                bidInfoList.value = list
                uiState = BidInfoUiState.Success(list)
            }

            override fun onFailure(call: Call<BidServiceSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    private fun getFormattedDate(date: String, time:String): String {
        val originalFormatString = "yyyy/MM/dd"
        val newFormatString = "yyyyMMdd"

        val originalFormat = SimpleDateFormat(originalFormatString, Locale.getDefault())
        val newFormat = SimpleDateFormat(newFormatString, Locale.getDefault())

        val formattedDate = originalFormat.parse(date)!!
        return newFormat.format(formattedDate)+time
    }
}