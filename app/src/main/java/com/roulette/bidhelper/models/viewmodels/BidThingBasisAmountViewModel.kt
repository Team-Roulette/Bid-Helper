package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidThingBasisAmountDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidThingBasisAmountViewModel : ViewModel() {
    private val _bidThingBasisAmount = MutableLiveData<BidThingBasisAmountDTO>()
    val bidThingBasisAmount: LiveData<BidThingBasisAmountDTO> = _bidThingBasisAmount

    fun setBidThingBasisAmount(param: BidAmountInfo) {
        RequestServer.bidServiceBefore.getBidThingBasisAmount(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidThingBasisAmountDTO> {
            override fun onResponse(
                call: Call<BidThingBasisAmountDTO>,
                response: Response<BidThingBasisAmountDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
                _bidThingBasisAmount.value = body
            }

            override fun onFailure(call: Call<BidThingBasisAmountDTO>, t: Throwable) {
                Log.i("test", t.toString())
                _bidThingBasisAmount.value = null
            }

        })
    }
}