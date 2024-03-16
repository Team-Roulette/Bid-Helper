package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.R
import com.roulette.bidhelper.functions.OnBaseInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.IndSearch
import com.roulette.bidhelper.models.apis.etc.BidBaseInfoListDTO

data class IndustryUiState(
    var industryClassificationCode: String = "",
    var industryCode: String = "",
    var industryName: String = ""
)

sealed interface IndustryDataState {
    data class Success(
        val items: List<BidBaseInfoListDTO.Response.Body.Item>? = null,
        ) : IndustryDataState
    data object Error : IndustryDataState
    data object Loading : IndustryDataState
}



class IndustryCodeSearchViewModel:ViewModel() {

    var industryUiState by mutableStateOf(IndustryUiState())

    var industryDataState: IndustryDataState by mutableStateOf(IndustryDataState.Loading)

    fun updateUiState(
        industryClassificationCode: String = industryUiState.industryClassificationCode,
        industryCode: String = industryUiState.industryCode,
        industryName: String  = industryUiState.industryName
    ) {
        industryUiState = IndustryUiState(
            industryClassificationCode = industryClassificationCode,
            industryCode = industryCode,
            industryName = industryName
        )
    }

    // 분류코드(2자리), 업종명, 업종코드(4자리) 있으면 넣고 없으면 그대로 검색해서
    // 결과로 분류코드(2자리, 4자리)랑, 분류명이랑, 업종명이랑
    fun searchIndustry(){
        industryDataState = IndustryDataState.Loading
        RequestServer.getBaseInfoList(IndSearch().apply{
            indstrytyClsfcCd = industryUiState.industryClassificationCode
            indstrytyCd = industryUiState.industryCode
            indstrytyNm = industryUiState.industryName
        }, object :OnBaseInfoListReceivedListener {
            override fun onReceived(items: List<BidBaseInfoListDTO.Response.Body.Item>) {
                //items : 응답 아이템
                Log.i("test", items.toString())
                industryDataState = IndustryDataState.Success(items)
            }
        })
    }

    fun getItemAsMap(item: BidBaseInfoListDTO.Response.Body.Item): Map<Int, String> {
        //법령 URL: item.baseLawordUrl
        return mapOf(
            R.string.industry_search_category_code to item.indstrytyClsfcCd,
            R.string.industry_search_category_name to item.indstrytyClsfcNm,
            R.string.industry_search_code to item.indstrytyCd,
            R.string.industry_search_industry_name to item.indstrytyNm,
            R.string.industry_search_related_law to item.baseLawordNm,
            R.string.industry_search_related_rule to item.rltnRgltCntnts
        )
    }
}