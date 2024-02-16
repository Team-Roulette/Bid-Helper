package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidCalcAInfoDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidCalcAInfoViewModel : ViewModel() {
    private val _bidCalcAInfo = MutableLiveData<BidCalcAInfoDTO>()
    val bidCalcAInfo: LiveData<BidCalcAInfoDTO> = _bidCalcAInfo

    fun setBidCalcAInfo(param: BidAmountInfo) {
        RequestServer.bidServiceBefore.getBidCalcAInfo(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidCalcAInfoDTO> {
            override fun onResponse(
                call: Call<BidCalcAInfoDTO>,
                response: Response<BidCalcAInfoDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
                _bidCalcAInfo.value = body
            }

            override fun onFailure(call: Call<BidCalcAInfoDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
                _bidCalcAInfo.value = null
            }
        })
    }
}