package com.roulette.bidhelper.ui.bidinfo.viewmodels

import androidx.lifecycle.ViewModel

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