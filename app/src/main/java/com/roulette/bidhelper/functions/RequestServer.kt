package com.roulette.bidhelper.functions

import android.util.Log
import com.roulette.bidhelper.BuildConfig
import com.roulette.bidhelper.models.BidBasisAmount
import com.roulette.bidhelper.models.BidThingBasisAmountDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestServer {
    private const val BASE_URL = BuildConfig.BASE_URL
    private const val SERVICE_KEY = BuildConfig.API_SERVICE_KEY
    val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bidService= retrofit.create(BidService::class.java) //retrofit객체 만듦!

    fun getBidThingBasisAmount(bidBasisAmount: BidBasisAmount) {
        bidService.getBidThingBasisAmount(numOfRows = bidBasisAmount.numOfRows, pageNo = bidBasisAmount.pageNo, serviceKey = bidBasisAmount.serviceKey, inqryDiv = bidBasisAmount.inqryDiv, "202401010000", "202401300000", null, "json").enqueue(object: Callback<BidThingBasisAmountDTO> {
            override fun onResponse(
                call: Call<BidThingBasisAmountDTO>,
                response: Response<BidThingBasisAmountDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg)
            }

            override fun onFailure(call: Call<BidThingBasisAmountDTO>, t: Throwable) {
                Log.i("test", t.toString())
            }

        })
    }

//    fun getBidConstBasisAmount(bidBasisAmount: BidBasisAmount) {
//        bidService.getBidConstBasisAmount(bidBasisAmount).enqueue(object: Callback<BidConstBasisAmountDTO> {
//            override fun onResponse(
//                call: Call<BidConstBasisAmountDTO>,
//                response: Response<BidConstBasisAmountDTO>
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<BidConstBasisAmountDTO>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
}