package com.roulette.bidhelper.models.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BidBeforeViewModel : ViewModel() {
    private var mainCategory = MutableLiveData("업종 구분")
        get() = mainCategory
    private var firstCategory = MutableLiveData("업종 구분")
        get() = firstCategory
    private var secondCategory = MutableLiveData("업종 구분")
    private var placeCategory = MutableLiveData("지역제한선택")
    private var dateFrom = MutableLiveData("202401010000")
    private var dateTo = MutableLiveData("202401012359")
    private var budgetCategory = MutableLiveData("기초금액")
    private var budgetMin = MutableLiveData("0")
    private var budgetMax = MutableLiveData("123456789")
    private var bidName = MutableLiveData("공고명")
}