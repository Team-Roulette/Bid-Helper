package com.roulette.bidhelper.functions

import android.util.Log
import com.roulette.bidhelper.BuildConfig
import com.roulette.bidhelper.models.BidAmountInfo
import com.roulette.bidhelper.models.BidLimitRegion
import com.roulette.bidhelper.models.BidSearch
import com.roulette.bidhelper.models.dtos.BidCalcAInfoDTO
import com.roulette.bidhelper.models.dtos.BidConstBasisAmountDTO
import com.roulette.bidhelper.models.dtos.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.dtos.BidLicenseLimitDTO
import com.roulette.bidhelper.models.dtos.BidPosRegionDTO
import com.roulette.bidhelper.models.dtos.BidThingBasisAmountDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestServer {
    private const val BASE_URL = BuildConfig.BASE_URL
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bidService = retrofit.create(BidService::class.java) //retrofit객체 만듦!

    fun getBidThingBasisAmount(param: BidAmountInfo) {
        bidService.getBidThingBasisAmount(
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
            }

            override fun onFailure(call: Call<BidThingBasisAmountDTO>, t: Throwable) {
                Log.i("test", t.toString())
            }

        })
    }

    fun getBidConstBasisAmount(param: BidAmountInfo) {
        bidService.getBidConstBasisAmount(
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
            }

            override fun onFailure(call: Call<BidConstBasisAmountDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
            }
        })
    }

    fun getBidCalcAInfo(param: BidAmountInfo) {
        bidService.getBidCalcAInfo(
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
            }

            override fun onFailure(call: Call<BidCalcAInfoDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
            }
        })
    }

    fun getBidConstWorkSearch(param: BidSearch) {
        bidService.getBidConstWorkSearch(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            type = param.type,
            bidNtceNm = param.bidNtceNm,
            ntceInsttCd = param.ntceInsttCd,
            ntceInsttNm = param.ntceInsttNm,
            dminsttCd = param.dminsttCd,
            dminsttNm = param.dminsttNm,
            refNo = param.refNo,
            prtcptLmtRgnCd = param.prtcptLmtRgnCd,
            prtcptLmtRgnNm = param.prtcptLmtRgnNm,
            indstrytyCd = param.indstrytyCd,
            indstrytyNm = param.indstrytyNm,
            presmptPrceBgn = param.presmptPrceBgn,
            presmptPrceEnd = param.presmptPrceEnd,
            dtilPrdctClsfcNoNm = param.dtilPrdctClsfcNoNm,
            masYn = param.masYn,
            prcrmntReqNo = param.prcrmntReqNo,
            bidClseExcpYn = param.bidClseExcpYn,
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidConstWorkSearchDTO> {
            override fun onResponse(
                call: Call<BidConstWorkSearchDTO>,
                response: Response<BidConstWorkSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidConstWorkSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    fun getBidPosRegion(param: BidLimitRegion) {
        bidService.getBidPosRegion(
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
            }

            override fun onFailure(call: Call<BidPosRegionDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
            }

        })
    }

    fun getBidLicenseLimit(param: BidLimitRegion) {
        bidService.getBidLicenseLimit(
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
            }

            override fun onFailure(call: Call<BidLicenseLimitDTO>, t: Throwable) {
                Log.i("test", t.message.toString())
            }
        })
    }
}