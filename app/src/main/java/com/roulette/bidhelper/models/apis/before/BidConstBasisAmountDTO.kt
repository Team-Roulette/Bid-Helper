package com.roulette.bidhelper.models.apis.before

import com.google.gson.annotations.SerializedName

// 입찰공고목록 정보에 대한 공사기초금액조회
data class BidConstBasisAmountDTO(
    @SerializedName("response")
    val response: Response // API 응답 본문
) {
    data class Response(
        @SerializedName("body")
        val body: Body, // 실제 데이터가 담긴 본문
        @SerializedName("header")
        val header: Header // 응답 헤더 정보
    ) {
        data class Body(
            @SerializedName("items")
            val items: List<Item>, // 입찰 기초금액 정보 항목 리스트
            @SerializedName("numOfRows")
            val numOfRows: String, // 페이지당 결과 수
            @SerializedName("pageNo")
            val pageNo: String, // 페이지 번호
            @SerializedName("totalCount")
            val totalCount: String // 전체 결과 수
        ) {
            data class Item(
                @SerializedName("bidClsfcNo")
                val bidClsfcNo: String, // 입찰분류번호
                @SerializedName("bidNtceNm")
                val bidNtceNm: String, // 입찰공고명
                @SerializedName("bidNtceNo")
                val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String, // 입찰공고차수
                @SerializedName("bidPrceCalclAYn")
                val bidPrceCalclAYn: String, // 입찰가격산식A여부
                @SerializedName("bssAmtPurcnstcst")
                val bssAmtPurcnstcst: String, // 기초금액순공사비
                @SerializedName("bssamt")
                val bssamt: String, // 기초금액
                @SerializedName("bssamtOpenDt")
                val bssamtOpenDt: String, // 기초금액공개일시
                @SerializedName("dfcltydgrCfcnt")
                val dfcltydgrCfcnt: String, // 난이도계수
                @SerializedName("envCnsrvcst")
                val envCnsrvcst: String, // 환경보전비
                @SerializedName("etcGnrlexpnsBssRate")
                val etcGnrlexpnsBssRate: String, // 기타경비기준율
                @SerializedName("evlBssAmt")
                val evlBssAmt: String, // 평가기준금액
                @SerializedName("gnrlMngcstBssRate")
                val gnrlMngcstBssRate: String, // 일반관리비기준율
                @SerializedName("inptDt")
                val inptDt: String, // 입력일시
                @SerializedName("lbrcstBssRate")
                val lbrcstBssRate: String, // 노무비기준율
                @SerializedName("mrfnHealthInsrprm")
                val mrfnHealthInsrprm: String, // 국민건강보험료
                @SerializedName("npnInsrprm")
                val npnInsrprm: String, // 국민연금보험료
                @SerializedName("odsnLngtrmrcprInsrprm")
                val odsnLngtrmrcprInsrprm: String, // 노인장기요양보험료
                @SerializedName("prftBssRate")
                val prftBssRate: String, // 이윤기준율
                @SerializedName("qltyMngcst")
                val qltyMngcst: String, // 품질관리비
                @SerializedName("qltyMngcstAObjYn")
                val qltyMngcstAObjYn: String, // 품질관리비A적용대상여부
                @SerializedName("rmrk1")
                val rmrk1: String, // 비고1
                @SerializedName("rmrk2")
                val rmrk2: String, // 비고2
                @SerializedName("rsrvtnPrceRngBgnRate")
                val rsrvtnPrceRngBgnRate: String, // 예비가격범위시작률
                @SerializedName("rsrvtnPrceRngEndRate")
                val rsrvtnPrceRngEndRate: String, // 예비가격범위종료율
                @SerializedName("rtrfundNon")
                val rtrfundNon: String, // 퇴직공제부금비
                @SerializedName("scontrctPayprcePayGrntyFee")
                val scontrctPayprcePayGrntyFee: String, // 하도급대금지급보증수수료
                @SerializedName("sftyChckMngcst")
                val sftyChckMngcst: String, // 안전관리비
                @SerializedName("sftyMngcst")
                val sftyMngcst: String, // 산업안전보건관리비
                @SerializedName("usefulAmt")
                val usefulAmt: String // 가용금액
            )
        }

        data class Header(
            @SerializedName("resultCode")
            val resultCode: String, // 결과코드
            @SerializedName("resultMsg")
            val resultMsg: String // 결과메시지
        )
    }
}
