package com.roulette.bidhelper.models.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BidBeforeViewModel : ViewModel() {
    val mainCategory = MutableLiveData("업종 구분")
    val firstCategory = MutableLiveData("업종 구분")
    val secondCategory = MutableLiveData("업종 구분")
    val placeCategory = MutableLiveData("지역제한선택")
    val dateFrom = MutableLiveData("202401010000")
    val dateTo = MutableLiveData("202401012359")
    val budgetCategory = MutableLiveData("기초금액")
    val budgetMin = MutableLiveData("0")
    val budgetMax = MutableLiveData("123456789")
    val bidName = MutableLiveData("공고명")
}