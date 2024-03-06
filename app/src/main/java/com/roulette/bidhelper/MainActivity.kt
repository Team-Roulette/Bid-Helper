package com.roulette.bidhelper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.roulette.bidhelper.functions.OnBidResultPriceListReceivedListener
import com.roulette.bidhelper.functions.OnPastInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.functions.RequestServer.getBidStatusServiceSearch
import com.roulette.bidhelper.functions.RequestServer.getBidStatusThingSearch
import com.roulette.bidhelper.models.apis.BidAmountInfo
import com.roulette.bidhelper.models.apis.BidSearch
import com.roulette.bidhelper.models.apis.after.BidConstWorkResultPriceDTO
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.home.HomeScreen
import com.roulette.bidhelper.ui.theme.BidHelperTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showRate("조달청", 0)  // 조달청 물품 낙찰 결과별 사정률 조회
        setContent {
            BidHelperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }

    // showRate : 지금은 발주처별 과거건의 예정가격이랑 기초금액을 확인함 (투찰률 계산)
    // idx 구분 : 0-물품, 1-공사, 2-용역
    // 수정 : 공고번호로 A정보를 각각 조회해서(기초금액조회API에 있음)(A값 요소별로 있으면 더해서) -> 위의 예가, 기초가와 A포함 투찰률로 변경해야함
    fun showRate(instName: String, idx:Int) {
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
                    val assessmentRate = "1"
//                    var assessmentRate = BigDecimal(result.plnprc).divide(BigDecimal(result.bssamt), 5 , RoundingMode.HALF_UP).multiply(
//                        BigDecimal(100)
//                    )
                    Log.i("test", "공고명: ${result.bidNtceNm}\n예정가격: ${result.plnprc}\n기초금액: ${result.bssamt}\n사정률 : $assessmentRate\n\n")
                }
            } catch (e: Exception) {
                // 오류 처리
                Log.e("test", "비동기 처리 중 오류 발생: ${e.message}")
            }
        }
    }

    suspend fun getBidStatusThingSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        getBidStatusThingSearch(BidSearch().apply {
            numOfRows = "20"
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
    suspend fun getBidStatusConstWorkSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        RequestServer.getBidStatusConstWorkSearch(BidSearch().apply {
            numOfRows = "20"
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
    suspend fun getBidStatusServiceSearch(instName: String): List<Item> = suspendCancellableCoroutine { continuation ->
        getBidStatusServiceSearch(BidSearch().apply {
            numOfRows = "20"
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
    suspend fun getBidThingResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
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
    suspend fun getBidConstWorkResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
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
    suspend fun getBidServiceResultPrice(bidNtceNo_: String): List<BidConstWorkResultPriceDTO.Response.Body.Item> = suspendCancellableCoroutine { continuation ->
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