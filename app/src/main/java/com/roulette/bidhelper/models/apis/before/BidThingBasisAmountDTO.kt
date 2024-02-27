package com.roulette.bidhelper.models.apis.before

import com.google.gson.annotations.SerializedName

// 입찰공고목록 정보에 대한 물품기초금액조회
data class BidThingBasisAmountDTO(
    @SerializedName("response") val response: Response // 전체 응답을 포함
) {
    data class Response(
        @SerializedName("body") val body: Body, // 응답 본문
        @SerializedName("header") val header: Header // 응답 헤더
    ) {
        data class Body(
            @SerializedName("items") val items: List<Item>, // 입찰 항목 목록
            @SerializedName("numOfRows") val numOfRows: String, // 페이지당 행 수
            @SerializedName("pageNo") val pageNo: String, // 페이지 번호
            @SerializedName("totalCount") val totalCount: String // 총 항목 수
        ) {
            data class Item(
                @SerializedName("bidClsfcNo") val bidClsfcNo: String, // 입찰 분류 번호
                @SerializedName("bidNtceNm") val bidNtceNm: String, // 입찰 공고명
                @SerializedName("bidNtceNo") val bidNtceNo: String, // 입찰 공고번호
                @SerializedName("bidNtceOrd") val bidNtceOrd: String, // 입찰 공고차수
                @SerializedName("bssamt") val bssamt: String, // 기초금액
                @SerializedName("bssamtOpenDt") val bssamtOpenDt: String, // 기초금액 공개 일시
                @SerializedName("dfcltydgrCfcnt") val dfcltydgrCfcnt: String, // 난이도 계수
                @SerializedName("envCnsrvcst") val envCnsrvcst: String, // 환경보전비
                @SerializedName("etcGnrlexpnsBssRate") val etcGnrlexpnsBssRate: String, // 기타 경비 기준율
                @SerializedName("evlBssAmt") val evlBssAmt: String, // 평가 기준금액
                @SerializedName("gnrlMngcstBssRate") val gnrlMngcstBssRate: String, // 일반관리비 기준율
                @SerializedName("industSftyHelthMngcst") val industSftyHelthMngcst: String, // 산업안전보건관리비
                @SerializedName("inptDt") val inptDt: String, // 입력 일시
                @SerializedName("lbrcstBssRate") val lbrcstBssRate: String, // 노무비 기준율
                @SerializedName("mrfnHealthInsrprm") val mrfnHealthInsrprm: String, // 국민건강보험료
                @SerializedName("npnInsrprm") val npnInsrprm: String, // 국민연금보험료
                @SerializedName("prftBssRate") val prftBssRate: String, // 이윤 기준율
                @SerializedName("rmrk1") val rmrk1: String, // 비고1
                @SerializedName("rmrk2") val rmrk2: String, // 비고2
                @SerializedName("rsrvtnPrceRngBgnRate") val rsrvtnPrceRngBgnRate: String, // 예비가격 범위 시작률
                @SerializedName("rsrvtnPrceRngEndRate") val rsrvtnPrceRngEndRate: String, // 예비가격 범위 종료율
                @SerializedName("rtrfundNon") val rtrfundNon: String, // 퇴직공제부금비
                @SerializedName("scontrctPayprcePayGrntyFee") val scontrctPayprcePayGrntyFee: String, // 하도급대금지급보증수수료
                @SerializedName("usefulAmt") val usefulAmt: String // 가용금액
            )
        }

        data class Header(
            @SerializedName("resultCode") val resultCode: String, // 결과코드
            @SerializedName("resultMsg") val resultMsg: String // 결과메시지
        )
    }
}
