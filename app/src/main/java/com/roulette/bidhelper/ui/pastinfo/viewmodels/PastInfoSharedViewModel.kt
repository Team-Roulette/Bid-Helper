package com.roulette.bidhelper.ui.pastinfo.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.models.apis.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.BidResultListDTO
import kotlinx.coroutines.flow.MutableStateFlow


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
class PastInfoSharedViewModel: ViewModel() {
    val uiState by mutableStateOf(PastInfoUiState())

    private val _bidResultList = MutableLiveData<BidResultListDTO>()
    val bidResultList: LiveData<BidResultListDTO> = _bidResultList


}