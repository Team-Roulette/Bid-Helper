package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidConstBasisAmountDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidConstBasisAmountViewModel {
    private val _bidConstBasisAmount = MutableLiveData<BidConstBasisAmountDTO>()
    val bidConstBasisAmount: LiveData<BidConstBasisAmountDTO> = _bidConstBasisAmount

    fun setBidConstBasisAmount(param: BidAmountInfo) {
        RequestServer.bidServiceBefore.getBidConstBasisAmount(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidConstBasisAmountDTO> {
            override fun onResponse(
                call: Call<BidConstBasisAmountDTO>,
                response: Response<BidConstBasisAmountDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
                _bidConstBasisAmount.value = body
            }

            override fun onFailure(call: Call<BidConstBasisAmountDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
                _bidConstBasisAmount.value = null
            }
        })
    }
}