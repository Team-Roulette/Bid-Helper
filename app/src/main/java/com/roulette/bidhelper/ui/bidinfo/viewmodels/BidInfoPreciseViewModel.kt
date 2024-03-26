package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.view.ContentInfoCompat.Flags
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roulette.bidhelper.functions.AssessmentItem
import com.roulette.bidhelper.functions.AssessmentRate
import com.roulette.bidhelper.models.apis.after.BidConstWorkResultPriceDTO
import com.roulette.bidhelper.models.apis.before.SearchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.math.BigDecimal

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

private const val TAG = "BidInfoPreciseViewModel"

class BidInfoPreciseViewModel : ViewModel() {
    var assessmentRateList: MutableList<AssessmentItem> =
        mutableListOf()
    var selectedItem: MutableState<SearchItem?> = mutableStateOf(null)
        private set

    fun selectItem(value: SearchItem) {
        selectedItem.value = value
        getAssessmentRate()
    }

    private fun getAssessmentRate() = viewModelScope.launch(Dispatchers.IO) {
        assessmentRateList.clear()
        if (selectedItem.value?.dminsttNm != null) {
            val assessmentRate = AssessmentRate(selectedItem.value?.dminsttNm!!)
            assessmentRateList.addAll(assessmentRate.getAssessmentRateList(0, 20))
        }
    }

    /**
     * 평균 사정률 계산 메서드
     */
    fun getAssessmentRateAverage(): Float {
        var answer = 0f

        for(assessmentRate in assessmentRateList) {
            answer += assessmentRate.assessmentRate.toFloat()
        }

        return answer / assessmentRateList.size
    }
}