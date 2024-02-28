package com.roulette.bidhelper.ui.bidinfo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.OnBaseInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.IndSearch
import com.roulette.bidhelper.models.apis.etc.BidBaseInfoListDTO

class IndustryCodeSearchViewModel:ViewModel() {
    // 분류코드(2자리), 업종명, 업종코드(4자리) 있으면 넣고 없으면 그대로 검색해서
    // 결과로 분류코드(2자리, 4자리)랑, 분류명이랑, 업종명이랑

    fun searchIndustry(indCode2: String, indName:String, indCode4:String){
        RequestServer.getBaseInfoList(IndSearch().apply{
            indstrytyClsfcCd = indCode2
            indstrytyCd = indCode4
            indstrytyNm = indName
        }, object :OnBaseInfoListReceivedListener {
            override fun onReceived(items: List<BidBaseInfoListDTO.Response.Body.Item>) {
                //items : 응답 아이템
                Log.i("test", items.toString())
            }
        })
    }
}