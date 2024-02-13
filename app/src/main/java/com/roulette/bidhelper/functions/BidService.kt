package com.roulette.bidhelper.functions

import com.roulette.bidhelper.models.dtos.BidCalcAInfoDTO
import com.roulette.bidhelper.models.dtos.BidConstBasisAmountDTO
import com.roulette.bidhelper.models.dtos.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.dtos.BidLicenseLimitDTO
import com.roulette.bidhelper.models.dtos.BidPosRegionDTO
import com.roulette.bidhelper.models.dtos.BidThingBasisAmountDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BidService {
    @GET("getBidPblancListInfoThngBsisAmount01") // 입찰공고목록 정보에 대한 물품기초금액조회
    fun getBidThingBasisAmount(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidThingBasisAmountDTO>

    @GET("getBidPblancListInfoCnstwkBsisAmount01") // 입찰공고목록 정보에 대한 공사기초금액조회
    fun getBidConstBasisAmount(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidConstBasisAmountDTO>

    @GET("getBidPblancListBidPrceCalclAInfo01") // 입찰공고목록 정보에 대한 입찰가격산식A정보조회
    fun getBidCalcAInfo(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.공고게시일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidCalcAInfoDTO>

    @GET("getBidPblancListInfoCnstwkPPSSrch01") // 나라장터검색조건에 의한 입찰공고공사조회
    fun getBidConstWorkSearch(
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String,
        @Query("ServiceKey") serviceKey: String,
        @Query("inqryDiv") inqryDiv: String,
        @Query("inqryBgnDt") inqryBgnDt: String?,
        @Query("inqryEndDt") inqryEndDt: String?,
        @Query("bidNtceNm") bidNtceNm: String?,
        @Query("ntceInsttCd") ntceInsttCd: String?,
        @Query("ntceInsttNm") ntceInsttNm: String?,
        @Query("dminsttCd") dminsttCd: String?,
        @Query("dminsttNm") dminsttNm: String?,
        @Query("refNo") refNo: String?,
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?,
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?,
        @Query("indstrytyCd") indstrytyCd: String?,
        @Query("indstrytyNm") indstrytyNm: String?,
        @Query("presmptPrceBgn") presmptPrceBgn: String?,
        @Query("presmptPrceEnd") presmptPrceEnd: String?,
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?,
        @Query("masYn") masYn: String?,
        @Query("prcrmntReqNo") prcrmntReqNo: String?,
        @Query("bidClseExcpYn") bidClseExcpYn: String?,
        @Query("intrntnlDivCd") intrntnlDivCd: String?,
        @Query("type") type: String?
    ): Call<BidConstWorkSearchDTO>

    @GET("getBidPblancListInfoPrtcptPsblRgn01") // 입찰공고목록 정보에 대한 참가가능지역정보조회
    fun getBidPosRegion(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("bidNtceOrd") bidNtceOrd: String?, // 검색하고자 하는 입찰공고차수 (조회구분이 2인 경우 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidPosRegionDTO>

    @GET("getBidPblancListInfoLicenseLimit01") // 입찰공고목록 정보에 대한 면허제한정보조회
    fun getBidLicenseLimit(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("bidNtceOrd") bidNtceOrd: String?, // 검색하고자 하는 입찰공고차수 (조회구분이 2인 경우 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidLicenseLimitDTO>
}