package com.roulette.bidhelper.ui.bidinfo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.models.apis.before.SearchItem

data class PreciseUiState(
    val noticeName: String,
    val noticeNum: String,
    val ordererName: String,
    val demanderName: String,
    val locationLimit: String,
    val company: String,
    val bidDate: String,
    val rgsDate: String,
    val basisAmount: String,
    val preemptionAmount: String
)

class BidInfoPreciseViewModel: ViewModel() {
    var selectedItem: MutableState<SearchItem?> = mutableStateOf(null)
        private set

    fun selectItem(value: SearchItem){
        selectedItem.value = value
    }
}