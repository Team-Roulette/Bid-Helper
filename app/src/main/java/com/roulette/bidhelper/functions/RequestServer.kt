package com.roulette.bidhelper.functions

import com.roulette.bidhelper.models.BidBasisAmount
import com.roulette.bidhelper.models.BidBasisAmountDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestServer {
    val retrofit= Retrofit.Builder()
        .baseUrl("apis.data.go.kr/1230000/BidPublicInfoService04")
        .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
        .build() //레트로핏 구현체 완성!

    val bidService= retrofit.create(BidService::class.java) //retrofit객체 만듦!

    fun test(bidBasisAmount: BidBasisAmount){
        bidService.getBidBasisAmount(bidBasisAmount).enqueue(object: Callback<BidBasisAmountDTO> {
            override fun onResponse(
                call: Call<BidBasisAmountDTO>,
                response: Response<BidBasisAmountDTO>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<BidBasisAmountDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}