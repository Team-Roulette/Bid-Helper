package com.roulette.bidhelper.functions

import android.util.Log
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.after.BidConstWorkResultPriceDTO
import com.roulette.bidhelper.models.apis.after.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.coroutines.resume

// showRate : 지금은 발주처별 과거건의 예정가격이랑 기초금액을 확인함 (투찰률 계산)
// idx 구분 : 0-물품, 1-공사, 2-용역
// count : 뽑아올 사정률 리스트 갯수

// 수정 : 공고번호로 A정보를 각각 조회해서(기초금액조회API에 있음)(A값 요소별로 있으면 더해서) -> 위의 예가, 기초가와 A포함 투찰률로 변경해야함
// listCount는 20개로 하자, 일단은 80개씩 불러옴. 유효한 데이터 20개만 뽑아서 넣기
interface AssessmentRateInterface {
    fun getAssessmentRateList(instName: String, idx:Int, listCount:Int) : MutableList<BidConstWorkResultPriceDTO.Response.Body.Item>
    suspend fun getBidStatusThingSearch(instName: String): List<Item>
    suspend fun getBidStatusConstWorkSearch(instName: String): List<Item>
    suspend fun getBidStatusServiceSearch(instName: String): List<Item>
    suspend fun getBidThingResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item>
    suspend fun getBidConstWorkResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item>
    suspend fun getBidServiceResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item>
}


class AssessmentRate: AssessmentRateInterface {

    override fun getAssessmentRateList(instName: String, idx:Int, listCount:Int) : MutableList<BidConstWorkResultPriceDTO.Response.Body.Item> {
        var answer:MutableList<BidConstWorkResultPriceDTO.Response.Body.Item> = mutableListOf()

        CoroutineScope(Dispatchers.Main).launch {
            try {
                // 첫 번째 요청을 비동기적으로 실행하고 결과를 가져옴
                val items = async(Dispatchers.IO) {
                    when(idx){
                        0->getBidStatusThingSearch(instName)
                        1->getBidStatusConstWorkSearch(instName)
                        else->getBidStatusServiceSearch(instName)
                    }
                }.await()

                // 각 아이템별로 비동기적으로 두 번째 요청을 실행
                //Log.e("test", items.toString())
                val results = items.map { item ->
                    async(Dispatchers.IO) {
                        // getBidConstWorkResultPrice() 함수 역시 suspend 함수이며, Retrofit을 사용하여 구현될 수 있음
                        when(idx){
                            0-> getBidThingResultPrice(item.bidNtceNo)  //item의 공고번호별로 예가와 기초가를 조회
                            1-> getBidConstWorkResultPrice(item.bidNtceNo)
                            else-> getBidServiceResultPrice(item.bidNtceNo)
                        }

                    }
                }.awaitAll().flatten() // 모든 비동기 작업을 기다린 후, 결과를 하나의 리스트로 합침
                // 최종 결과 처리
                results.forEach { result ->
                    // 결과 로깅
                    // 예정가격 / 기초금액 * 100 (소수점 5째자리에서 반올림 후 100곱함)
                    // 기초가나 예가가 없는 경우가 많음, 있는 경우만 계산

                    if(result.plnprc.isNullOrBlank() || result.bssamt.isNullOrBlank()){
                        //Log.i("test", "예가 or 기초가 없음")
                    }else{
                        // 유효데이터!
                        answer += result
                    }
                }
            } catch (e: Exception) {
                // 오류 처리
                Log.e("test", "비동기 처리 중 오류 발생: ${e.message}")
            }

            answer = answer.take(listCount).toMutableList() // listCount만큼만! 나머지 지우기
            Log.i("test", "유효데이터 수 : "+answer.size.toString() + " / "+listCount.toString())
            for(result in answer){
                val assessmentRate = BigDecimal(result.plnprc).divide(BigDecimal(result.bssamt), 5 , RoundingMode.HALF_UP).multiply(
                    BigDecimal(100)
                )
                Log.i("test", "공고명: ${result.bidNtceNm}\n예정가격: ${result.plnprc}\n기초금액: ${result.bssamt}\n사정률 : $assessmentRate\n\n")
            }
        }
        return answer
    }

    override suspend fun getBidStatusThingSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidStatusThingSearch(BidSearch().apply {
            numOfRows = "80"
            pageNo = "1"
            inqryDiv = "1"
            ntceInsttNm = instName
        }, listener = object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
    override suspend fun getBidStatusConstWorkSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidStatusConstWorkSearch(BidSearch().apply {
            numOfRows = "80"
            pageNo = "1"
            inqryDiv = "1"
            ntceInsttNm = instName
        }, listener = object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
    override suspend fun getBidStatusServiceSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidStatusServiceSearch(BidSearch().apply {
            numOfRows = "80"
            pageNo = "1"
            inqryDiv = "1"
            ntceInsttNm = instName
        }, listener = object : OnPastInfoListReceivedListener {
            override fun onReceived(items: List<Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
    override suspend fun getBidThingResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidThingResultPrice(BidAmountInfo().apply {
            numOfRows = "1"
            pageNo = "1"
            inqryDiv = "2"
            inqryBgnDt = null
            inqryEndDt = null
            bidNtceNo = bidNtceNo_
        }, listener = object : OnBidResultPriceListReceivedListener {
            override fun onReceived(items: List<BidConstWorkResultPriceDTO.Response.Body.Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
    override suspend fun getBidConstWorkResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidConstWorkResultPrice(BidAmountInfo().apply {
            numOfRows = "1"
            pageNo = "1"
            inqryDiv = "2"
            inqryBgnDt = null
            inqryEndDt = null
            bidNtceNo = bidNtceNo_
        }, listener = object : OnBidResultPriceListReceivedListener {
            override fun onReceived(items: List<BidConstWorkResultPriceDTO.Response.Body.Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
    override suspend fun getBidServiceResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidServiceResultPrice(BidAmountInfo().apply {
            numOfRows = "1"
            pageNo = "1"
            inqryDiv = "2"
            inqryBgnDt = null
            inqryEndDt = null
            bidNtceNo = bidNtceNo_
        }, listener = object : OnBidResultPriceListReceivedListener {
            override fun onReceived(items: List<BidConstWorkResultPriceDTO.Response.Body.Item>) {
                // 콜백에서 결과를 받으면 코루틴에 결과를 전달하여 계속 실행
                continuation.resume(items)
            }
        })
    }
}