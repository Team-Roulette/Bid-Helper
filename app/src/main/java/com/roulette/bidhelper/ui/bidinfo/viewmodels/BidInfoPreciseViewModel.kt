package com.roulette.bidhelper.ui.bidinfo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.ui.bidinfo.spinners.firstCategoryList_1
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.secondCategoryList_1_1

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
}