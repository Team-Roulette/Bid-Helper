package com.roulette.bidhelper.functions

import com.roulette.bidhelper.models.BidThingBasisAmountDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BidService {
    @GET("getBidPblancListInfoThngBsisAmount01")
    fun getBidThingBasisAmount(@Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
                               @Query("pageNo") pageNo: String, // 페이지 번호,
                               @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
                               @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
                               @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
                               @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
                               @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
                               @Query("type") type: String?): Call<BidThingBasisAmountDTO>// 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정): Call<BidThingBasisAmountDTO> // 입찰공고목록 정보에 대한 물품기초금액조회
//    fun getBidConstBasisAmount(@Body bidBasisAmount: BidBasisAmount): Call<BidConstBasisAmountDTO> // 입찰공고목록 정보에 대한 공사기초금액조회

}