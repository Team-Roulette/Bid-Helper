package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.after.BidResultListDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidResultListViewModel : ViewModel() {
    private val _bidResultList = MutableLiveData<BidResultListDTO>()
    val bidResultList: LiveData<BidResultListDTO> = _bidResultList

    fun setBidResultList(param: BidAmountInfo) {
        RequestServer.bidServiceAfter.getBidResultList(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidResultListDTO> {
            override fun onResponse(
                call: Call<BidResultListDTO>,
                response: Response<BidResultListDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg+"낙찰 결과")
                _bidResultList.value = body
            }

            override fun onFailure(call: Call<BidResultListDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
                _bidResultList.value = null
            }

        })
    }
}