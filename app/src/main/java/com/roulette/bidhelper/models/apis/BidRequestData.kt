package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName
import com.roulette.bidhelper.BuildConfig
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.models.apis.before.SearchItem
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private lateinit var time: LocalDateTime
private val formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmm") // ex) 202402132233
fun targetTime(month: Long): String {
    time = LocalDateTime.now().minusMonths(month)
    if(month != 0L) time = time.withHour(0).withMinute(0)
    return time.format(formatter)
}

sealed interface BidResultUiState {
    data class Success(val items: List<Item>) : BidResultUiState
    data object Error : BidResultUiState
    data object Loading : BidResultUiState
}

sealed interface BidInfoUiState {
    data class Success(val items: List<SearchItem>) : BidInfoUiState
    data object Error : BidInfoUiState
    data object Loading : BidInfoUiState
}

open class BidCommonParams( // 요청 기본 파라미터
    @SerializedName("numOfRows") var numOfRows: String? = null, // 한 페이지 결과 수
    @SerializedName("pageNo") var pageNo: String? = null, // 페이지 번호,
    @SerializedName("ServiceKey") val serviceKey: String = BuildConfig.API_SERVICE_KEY, // 공공데이터포탈에서 받은 인증키
    @SerializedName("inqryDiv") var inqryDiv: String? = null, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
    @SerializedName("inqryBgnDt") var inqryBgnDt: String? = targetTime(3), // 검색하고자하는 조회시작일시
    @SerializedName("inqryEndDt") var inqryEndDt: String? = targetTime(0), // 검색하고자하는 조회종료일시
    @SerializedName("type") val type: String = "json",// 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
)

open class BidAmountInfo( // 입찰공고목록 정보에 대한 물품기초금액, 공사기초금액, 입찰가격산식A정보조회, 개찰결과 공사 목록, 공사 예비가격상세 목록 조회
    @SerializedName("bidNtceNo") var bidNtceNo: String? = null, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
) : BidCommonParams()
data class BidLimitRegion( // 입찰공고목록 정보에 대한 면허제한정보, 참가가능지역정보
    @SerializedName("bidNtceOrd") var bidNtceOrd: String? = null // 검색하고자 하는 입찰공고차수 (조회구분이 2인 경우 필수)
) : BidAmountInfo()

data class IndSearch(   //  업종검색
    @SerializedName("indstrytyClsfcCd") var indstrytyClsfcCd: String? = null,    // 2자리 분류코드
    @SerializedName("indstrytyCd") var indstrytyCd: String? = null, // 4자리 업종코드
    @SerializedName("indstrytyNm") var indstrytyNm: String? = null, // 업종명
):BidCommonParams()

data class BidSearch( // 나라장터검색조건에 의한 입찰공고공사조회
    @SerializedName("bidNtceNm") var bidNtceNm: String? = null, // 공고명
    @SerializedName("bidNm") var bidNm: String? = null, // 공고명(방위사업청 연계건)
    @SerializedName("ntceInsttCd") var ntceInsttCd: String? = null, // 공고기관코드
    @SerializedName("ntceInsttNm") var ntceInsttNm: String? = null, // 공고기관명
    @SerializedName("dminsttCd") var dminsttCd: String? = null, // 수요기관코드
    @SerializedName("dminsttNm") var dminsttNm: String? = null, // 수요기관명
    @SerializedName("refNo") var refNo: String? = null, // 참조번호
    @SerializedName("prtcptLmtRgnCd") var prtcptLmtRgnCd: String? = null, // 참가제한지역코드
    @SerializedName("prtcptLmtRgnNm") var prtcptLmtRgnNm: String? = null, // 참가제한지역명
    @SerializedName("indstrytyCd") var indstrytyCd: String? = null, // 업종코드
    @SerializedName("indstrytyNm") var indstrytyNm: String? = null, // 업종명
    @SerializedName("presmptPrceBgn") var presmptPrceBgn: String? = null, // 추정가격범위시작금액이상
    @SerializedName("presmptPrceEnd") var presmptPrceEnd: String? = null, // 추정가격범위종료금액이하
    @SerializedName("dtilPrdctClsfcNoNm") var dtilPrdctClsfcNoNm: String? = null, // 세부품명번호
    @SerializedName("masYn") var masYn: String? = null, // 다수공급경쟁자여부
    @SerializedName("prcrmntReqNo") var prcrmntReqNo: String? = null, // 조달요청번호
    @SerializedName("bidClseExcpYn") var bidClseExcpYn: String? = null, // 입찰마감제외여부
    @SerializedName("intrntnlDivCd") var intrntnlDivCd: String? = null // 국내/국제입찰 구분값
) : BidCommonParams()