package com.roulette.bidhelper.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roulette.bidhelper.models.apis.after.BidConstWorkResultPriceDTO

class BidResultPriceViewModel : ViewModel() {
    private val _bidResultPrice = MutableLiveData<BidConstWorkResultPriceDTO>()
    val bidResultPrice: LiveData<BidConstWorkResultPriceDTO> = _bidResultPrice
//    이게 뭔데 오류내는겨?
//    fun setBidResultPrice(param: BidAmountInfo) {
//        RequestServer.bidServiceAfter.getBidResultPrice(
//            numOfRows = param.numOfRows!!,
//            pageNo = param.pageNo!!,
//            serviceKey = param.serviceKey,
//            inqryDiv = param.inqryDiv!!,
//            inqryBgnDt = param.inqryBgnDt,
//            inqryEndDt = param.inqryEndDt,
//            bidNtceNo = param.bidNtceNo,
//            type = param.type
//        ).enqueue(object : Callback<BidConstWorkResultPriceDTO> {
//            override fun onResponse(
//                call: Call<BidConstWorkResultPriceDTO>,
//                response: Response<BidConstWorkResultPriceDTO>
//            ) {
//                val body = response.body()!!
//                Log.i("test", body.response.header.resultMsg+"낙찰 가격")
//                _bidResultPrice.value = body
//            }
//
//            override fun onFailure(call: Call<BidConstWorkResultPriceDTO>, t: Throwable) {
//                Log.e("test", t.message.toString())
//                _bidResultPrice.value = null
//            }
//        })
//    }
}