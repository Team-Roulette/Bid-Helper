package com.roulette.bidhelper.functions

import com.roulette.bidhelper.models.apis.after.BidConstWorkResultPriceDTO
import com.roulette.bidhelper.models.apis.after.BidResultListDTO
import com.roulette.bidhelper.models.apis.after.BidStatusConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.after.BidStatusServiceSearchDTO
import com.roulette.bidhelper.models.apis.after.BidStatusThingSearchDTO
import com.roulette.bidhelper.models.apis.before.BidCalcAInfoDTO
import com.roulette.bidhelper.models.apis.before.BidConstBasisAmountDTO
import com.roulette.bidhelper.models.apis.before.BidConstWorkSearchDTO
import com.roulette.bidhelper.models.apis.before.BidLicenseLimitDTO
import com.roulette.bidhelper.models.apis.before.BidPosRegionDTO
import com.roulette.bidhelper.models.apis.before.BidServiceSearchDTO
import com.roulette.bidhelper.models.apis.before.BidThingBasisAmountDTO
import com.roulette.bidhelper.models.apis.before.BidThingSearchDTO
import com.roulette.bidhelper.models.apis.etc.BidBaseInfoListDTO
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
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("bidClseExcpYn") bidClseExcpYn: String?, // 입찰마감제외여부
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidConstWorkSearchDTO>

    @GET("getBidPblancListInfoThngPPSSrch01") // 나라장터 검색조건에 의한 입찰공고물품조회
    fun getBidThingSearch(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("bidClseExcpYn") bidClseExcpYn: String?, // 입찰마감제외여부
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidThingSearchDTO>

    @GET("getBidPblancListInfoServcPPSSrch01") // 나라장터 검색조건에 의한 입찰공고용역조회
    fun getBidServiceSearch(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("bidClseExcpYn") bidClseExcpYn: String?, // 입찰마감제외여부
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidServiceSearchDTO>

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

    @GET("getOpengResultListInfoCnstwkPreparPcDetail") // 개찰결과 공사 예비가격 상세 목록 조회
    fun getBidConstWorkResultPrice(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자하는 입찰공고번호, 조회구분 4인 경우 필수
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidConstWorkResultPriceDTO>

    @GET("getOpengResultListInfoThngPreparPcDetail") // 개찰결과 물품 예비가격 상세 목록 조회
    fun getBidThingResultPrice(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자하는 입찰공고번호, 조회구분 4인 경우 필수
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidConstWorkResultPriceDTO>

    @GET("getOpengResultListInfoServcPreparPcDetail") // 개찰결과 용역 예비가격 상세 목록 조회
    fun getBidServiceResultPrice(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자하는 입찰공고번호, 조회구분 4인 경우 필수
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidConstWorkResultPriceDTO>









    @GET("getOpengResultListInfoCnstwk") // 개찰결과 공사 목록 조회
    fun getBidResultList(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.공고일시, 3.개찰일시, 4.입찰공고번호
        @Query("inqryBgnDt") inqryBgnDt: String?, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 검색하고자하는 조회종료일시
        @Query("bidNtceNo") bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
        @Query("type") type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidResultListDTO>

    @GET("getScsbidListSttusThngPPSSrch") // 나라장터 검색조건에 의한 낙찰된 목록 현황 물품조회
    fun getBidStatusThingSearch(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidStatusThingSearchDTO>

    @GET("getScsbidListSttusCnstwkPPSSrch") // 나라장터 검색조건에 의한 낙찰된 목록 현황 공사조회
    fun getBidStatusConstWorkSearch(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidStatusConstWorkSearchDTO>

    @GET("getScsbidListSttusServcPPSSrch") // 나라장터 검색조건에 의한 낙찰된 목록 현황 용역조회
    fun getBidStatusServiceSearch(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호
        @Query("ServiceKey") serviceKey: String, // 공공데이터포털에서 받은 인증키
        @Query("inqryDiv") inqryDiv: String, // 조회구분
        @Query("inqryBgnDt") inqryBgnDt: String?, // 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String?, // 조회종료일시
        @Query("bidNtceNm") bidNtceNm: String?, // 입찰공고명
        @Query("ntceInsttCd") ntceInsttCd: String?, // 공고기관코드
        @Query("ntceInsttNm") ntceInsttNm: String?, // 공고기관명
        @Query("dminsttCd") dminsttCd: String?, // 수요기관코드
        @Query("dminsttNm") dminsttNm: String?, // 수요기관명
        @Query("refNo") refNo: String?, // 참조번호
        @Query("prtcptLmtRgnCd") prtcptLmtRgnCd: String?, // 참가제한지역코드
        @Query("prtcptLmtRgnNm") prtcptLmtRgnNm: String?, // 참가제한지역명
        @Query("indstrytyCd") indstrytyCd: String?, // 업종코드
        @Query("indstrytyNm") indstrytyNm: String?, // 업종명
        @Query("presmptPrceBgn") presmptPrceBgn: String?, // 추정가격시작
        @Query("presmptPrceEnd") presmptPrceEnd: String?, // 추정가격종료
        @Query("dtilPrdctClsfcNoNm") dtilPrdctClsfcNoNm: String?, // 세부품명번호
        @Query("masYn") masYn: String?, // 다수공급경쟁자여부
        @Query("prcrmntReqNo") prcrmntReqNo: String?, // 조달요청번호
        @Query("intrntnlDivCd") intrntnlDivCd: String?, // 국제구분코드
        @Query("type") type: String? // 타입
    ): Call<BidStatusServiceSearchDTO>

    @GET("getIndstrytyBaseLawrgltInfoList02") // 업종 및 근거법규 정보 조회
    fun getBaseInfoList(
        @Query("numOfRows") numOfRows: String, // 한 페이지 결과 수
        @Query("pageNo") pageNo: String, // 페이지 번호,
        @Query("ServiceKey") serviceKey: String, // 공공데이터포탈에서 받은 인증키
        @Query("indstrytyClsfcCd") indstrytyClsfcCd: String? = null, // 검색하고자하는 업종을 분류하는 코드
        @Query("indstrytyNm") indstrytyNm: String? = null, // 검색하고자하는 업종에 대한 분류 명
        @Query("indstrytyCd") indstrytyCd: String? = null, // 검색하고자하는 업종을 분류하는 코드(코드값)
        @Query("inqryBgnDt") inqryBgnDt: String? = null, // 검색하고자하는 조회시작일시
        @Query("inqryEndDt") inqryEndDt: String? = null, // 검색하고자하는 조회종료일시
        @Query("indstrytyUseYn") indstrytyUseYn: String? = null, // 업종사용여부, 값이 없을 경우 전체 조회
        @Query("type") type: String? = null // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
    ): Call<BidBaseInfoListDTO>
}