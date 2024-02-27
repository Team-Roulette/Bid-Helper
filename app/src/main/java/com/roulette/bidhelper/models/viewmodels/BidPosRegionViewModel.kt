package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidLimitRegion
import com.roulette.bidhelper.models.apis.before.BidPosRegionDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidPosRegionViewModel : ViewModel() {
    private val _bidPosRegion = MutableLiveData<BidPosRegionDTO>()
    val bidPosRegion: LiveData<BidPosRegionDTO> = _bidPosRegion

    fun setBidPosRegion(param: BidLimitRegion) {
        RequestServer.bidServiceBefore.getBidPosRegion(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            bidNtceOrd = param.bidNtceOrd,
            type = param.type
        ).enqueue(object : Callback<BidPosRegionDTO> {
            override fun onResponse(
                call: Call<BidPosRegionDTO>,
                response: Response<BidPosRegionDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
                _bidPosRegion.value = body
            }

            override fun onFailure(call: Call<BidPosRegionDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
                _bidPosRegion.value = null
            }
        })
    }
}