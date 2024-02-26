package com.roulette.bidhelper.functions

import android.util.Log
import com.roulette.bidhelper.BuildConfig
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidCalcAInfoDTO
import com.roulette.bidhelper.models.apis.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.BidLicenseLimitDTO
import com.roulette.bidhelper.models.apis.BidLimitRegion
import com.roulette.bidhelper.models.apis.BidPosRegionDTO
import com.roulette.bidhelper.models.apis.BidResultListDTO
import com.roulette.bidhelper.models.apis.BidResultPriceDTO
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.BidServiceSearchDTO
import com.roulette.bidhelper.models.apis.BidStatusConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.BidStatusServiceSearchDTO
import com.roulette.bidhelper.models.apis.BidStatusThingSearchDTO
import com.roulette.bidhelper.models.apis.BidThingBasisAmountDTO
import com.roulette.bidhelper.models.apis.BidThingSearchDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestServer {
    private const val BASE_URL_BEFORE = BuildConfig.BASE_URL_BEFORE
    private const val BASE_URL_AFTER = BuildConfig.BASE_URL_AFTER
    
    val retrofitBefore = Retrofit.Builder()
        .baseUrl(BASE_URL_BEFORE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitAfter = Retrofit.Builder()
        .baseUrl(BASE_URL_AFTER)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bidServiceBefore = retrofitBefore.create(BidService::class.java) // 입찰 정보 retrofit 객체
    val bidServiceAfter = retrofitAfter.create(BidService::class.java) // 낙찰 정보 retrofit 객체

    fun getBidThingBasisAmount(param: BidAmountInfo) {
        bidServiceBefore.getBidThingBasisAmount(
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

    /*fun getBidConstBasisAmount(param: BidAmountInfo) {
        bidServiceBefore.getBidConstBasisAmount(
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
    }*/

    fun getBidCalcAInfo(param: BidAmountInfo) {
        bidServiceBefore.getBidCalcAInfo(
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
        bidServiceBefore.getBidConstWorkSearch(
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

    fun getBidThingSearch(param: BidSearch) {
        bidServiceBefore.getBidThingSearch(
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
        ).enqueue(object : Callback<BidThingSearchDTO> {
            override fun onResponse(
                call: Call<BidThingSearchDTO>,
                response: Response<BidThingSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidThingSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    fun getBidServiceSearch(param: BidSearch) {
        bidServiceBefore.getBidServiceSearch(
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
        ).enqueue(object : Callback<BidServiceSearchDTO> {
            override fun onResponse(
                call: Call<BidServiceSearchDTO>,
                response: Response<BidServiceSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidServiceSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    fun getBidPosRegion(param: BidLimitRegion) {
        bidServiceBefore.getBidPosRegion(
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
                Log.e("test", t.message.toString())
            }

        })
    }

    fun getBidLicenseLimit(param: BidLimitRegion) {
        bidServiceBefore.getBidLicenseLimit(
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
                Log.e("test", t.message.toString())
            }
        })
    }

    fun getBidResultPrice(param: BidAmountInfo) {
        bidServiceAfter.getBidResultPrice(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidResultPriceDTO>{
            override fun onResponse(
                call: Call<BidResultPriceDTO>,
                response: Response<BidResultPriceDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg+"낙찰 가격")
            }

            override fun onFailure(call: Call<BidResultPriceDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    fun getBidResultList(param: BidAmountInfo) {
        bidServiceAfter.getBidResultList(
            numOfRows = param.numOfRows!!,
            pageNo = param.pageNo!!,
            serviceKey = param.serviceKey,
            inqryDiv = param.inqryDiv!!,
            inqryBgnDt = param.inqryBgnDt,
            inqryEndDt = param.inqryEndDt,
            bidNtceNo = param.bidNtceNo,
            type = param.type
        ).enqueue(object : Callback<BidResultListDTO>{
            override fun onResponse(
                call: Call<BidResultListDTO>,
                response: Response<BidResultListDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.header.resultMsg+"낙찰 결과")
            }

            override fun onFailure(call: Call<BidResultListDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    // 나라장터 검색조건에 의한 낙찰된 목록 현황 물품조회
    fun getBidStatusThingSearch(param: BidSearch) {
        bidServiceAfter.getBidStatusThingSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusThingSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusThingSearchDTO>,
                response: Response<BidStatusThingSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidStatusThingSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    // 나라장터 검색조건에 의한 낙찰된 목록 현황 공사조회
    fun getBidStatusConstWorkSearch(param: BidSearch) {
        bidServiceAfter.getBidStatusConstWorkSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusConstWorkSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusConstWorkSearchDTO>,
                response: Response<BidStatusConstWorkSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidStatusConstWorkSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }

    // 나라장터 검색조건에 의한 낙찰된 목록 현황 용역조회
    fun getBidStatusServiceSearch(param: BidSearch) {
        bidServiceAfter.getBidStatusServiceSearch(
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
            intrntnlDivCd = param.intrntnlDivCd
        ).enqueue(object : Callback<BidStatusServiceSearchDTO> {
            override fun onResponse(
                call: Call<BidStatusServiceSearchDTO>,
                response: Response<BidStatusServiceSearchDTO>
            ) {
                val body = response.body()!!
                Log.i("test", body.response.body.items[0].bidNtceNm)
                Log.i("test", body.response.body.totalCount)
            }

            override fun onFailure(call: Call<BidStatusServiceSearchDTO>, t: Throwable) {
                Log.e("test", t.message.toString())
            }

        })
    }
}