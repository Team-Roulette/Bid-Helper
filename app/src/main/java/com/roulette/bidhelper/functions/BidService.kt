package com.roulette.bidhelper.functions

import com.roulette.bidhelper.models.BidBasisAmount
import com.roulette.bidhelper.models.BidBasisAmountDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface BidService {
    @GET("/getBidPblancListInfoThngBsisAmount01")
    fun getBidBasisAmount(@Body bidBasisAmount: BidBasisAmount): Call<BidBasisAmountDTO>
}