package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidResultPriceDTO
import kotlinx.coroutines.launch
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
    data class Success(val bidResultPriceDTO: BidResultPriceDTO): BidResultUiState
    object Error: BidResultUiState
    object Loading: BidResultUiState
}

class PastInfoSharedViewModel : ViewModel() {
    var uiState by mutableStateOf(PastInfoUiState())

    private val _bidResultPrice = MutableLiveData<BidResultPriceDTO>()
    val bidResultPrice: LiveData<BidResultPriceDTO> = _bidResultPrice

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
        searchName: String = uiState.searchName,
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

    fun getBidResultList() {
        val param = BidAmountInfo().apply {
            numOfRows = "10"
            pageNo = "1"
            inqryDiv = "1"
            inqryBgnDt = "202401211200"
            inqryEndDt = "202402210445"
            bidNtceNo = null
        }

        viewModelScope.launch {
            RequestServer.bidServiceAfter.getBidResultPrice(
                numOfRows = param.numOfRows!!,
                pageNo = param.pageNo!!,
                serviceKey = param.serviceKey,
                inqryDiv = param.inqryDiv!!,
                inqryBgnDt = param.inqryBgnDt,
                inqryEndDt = param.inqryEndDt,
                bidNtceNo = param.bidNtceNo,
                type = param.type
            ).enqueue(object : Callback<BidResultPriceDTO> {
                override fun onResponse(
                    call: Call<BidResultPriceDTO>,
                    response: Response<BidResultPriceDTO>
                ) {
                    val body = response.body()!!
                    Log.i(
                        TAG, body.response.toString()
                    )
                    _bidResultPrice.value = body
                    bidResultUiState = BidResultUiState.Success(
                        body
                    )
                }

                override fun onFailure(call: Call<BidResultPriceDTO>, t: Throwable) {
                    Log.e(TAG, "${t.message.toString()} code: ${t.localizedMessage}")
                    _bidResultPrice.value = null
                    bidResultUiState = BidResultUiState.Error
                }
            })
        }
    }
}