package com.roulette.bidhelper.models.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.BidLicenseLimitDTO
import com.roulette.bidhelper.models.apis.BidLimitRegion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BidLicenseLimitViewModel : ViewModel() {
    private val _bidLicenseLimit = MutableLiveData<BidLicenseLimitDTO>()
    val bidLicenseLimit: LiveData<BidLicenseLimitDTO> = _bidLicenseLimit

    fun setBidLicenseLimit(param: BidLimitRegion) {
        RequestServer.bidServiceBefore.getBidLicenseLimit(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            bidNtceOrd = param.bidNtceOrd,
            type = param.type
        ).enqueue(object : Callback<BidLicenseLimitDTO> {
            override fun onResponse(
                call: Call<BidLicenseLimitDTO>,
                response: Response<BidLicenseLimitDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
                _bidLicenseLimit.value = body
            }

            override fun onFailure(call: Call<BidLicenseLimitDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
                _bidLicenseLimit.value = null
            }
        })
    }
}