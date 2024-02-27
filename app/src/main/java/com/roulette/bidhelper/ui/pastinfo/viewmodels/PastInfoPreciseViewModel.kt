package com.roulette.bidhelper.ui.pastinfo.viewmodels

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roulette.bidhelper.models.apis.Item
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoSearchViewModel


class PastInfoPreciseViewModel(): ViewModel() {
    var item: Item by mutableStateOf(Item("","","","",
        "","","","","","",
        "","","","","","",
        "","","","",""))

    fun getItemAsStringList(): List<String> {
        return listOf(
            item.bidNtceNm, item.bidNtceNo, item.dminsttNm, item.dminsttNm,
            "지역제한", item.ntceDivCd, item.rlOpengDt, item.rgstDt, "기초금액", "추정가격"
        )
    }


}


