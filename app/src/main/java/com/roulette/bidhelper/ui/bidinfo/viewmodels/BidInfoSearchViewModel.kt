package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.before.Item
import com.roulette.bidhelper.models.apis.before.BidConstBasisAmountDTO
import com.roulette.bidhelper.models.apis.before.BidConstWorkSearchDTO
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

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
    var industryName: String = "",
    var searchName: String = ""
)



class BidInfoSearchViewModel(private val sharedPreferences: SharedPreferences)  : ViewModel() {
    var uiState by mutableStateOf(SearchUiState())

    private val _bidConstBasisAmount = MutableLiveData<BidConstBasisAmountDTO>()
    val bidConstBasisAmount: LiveData<BidConstBasisAmountDTO> = _bidConstBasisAmount

    private val _bidConstWorkSearch = MutableLiveData<BidConstWorkSearchDTO>()
    val bidConstWorkSearch: LiveData<BidConstWorkSearchDTO> = _bidConstWorkSearch

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item> = _selectedItem

    fun selectItem(item: Item) {
        _selectedItem.value = item
    }

    init {
        updateUIState(
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
        }
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

    fun setPastInfoSearchList() {
        //bidResultUiState = BidResultUiState.Loading

        val bidSearch = BidSearch().apply {
            numOfRows = "100"
            pageNo = "1"
            inqryDiv = "1"
            inqryBgnDt = getFormattedDate(uiState.dateFrom, "0000")
            inqryEndDt = getFormattedDate(uiState.dateTo, "2359")
        }

        Log.d(TAG, bidSearch.inqryBgnDt+" " +bidSearch.inqryEndDt)
        when (uiState.mainCategory) {
//            mainCategoryList[1] -> getStatusConstWorkList(bidSearch)
//            mainCategoryList[2] -> getStatusThingSearchList(bidSearch)
//            mainCategoryList[3] -> getStatusServiceSearchList(bidSearch)
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
                //_bidConstWorkSearch.value = null
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