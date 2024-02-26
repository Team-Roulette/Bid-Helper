package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName
//입찰공고목록 정보에 대한 입찰가격 산식 A 정보 조회
data class BidCalcAInfoDTO(
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
            val items: List<Item>, // 입찰 정보 항목 리스트
            @SerializedName("numOfRows")
            val numOfRows: String, // 페이지당 결과 수
            @SerializedName("pageNo")
            val pageNo: String, // 페이지 번호
            @SerializedName("totalCount")
            val totalCount: String // 전체 결과 수
        ) {

            data class Item(
                @SerializedName("bidNtceNo")
                val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String, // 입찰공고차수
                @SerializedName("bidPrceCalclAOpenDt")
                val bidPrceCalclAOpenDt: String, // 입찰가격산식A공개일시
                @SerializedName("mrfnHealthInsrprm")
                val mrfnHealthInsrprm: String, // 국민건강보험료
                @SerializedName("npnInsrprm")
                val npnInsrprm: String, // 국민연금보험료
                @SerializedName("ntceNticeDt")
                val ntceNticeDt: String, // 공고게시일시
                @SerializedName("odsnLngtrmrcprInsrprm")
                val odsnLngtrmrcprInsrprm: String, // 노인장기요양보험료
                @SerializedName("prearngPrceDcsnMthdNm")
                val prearngPrceDcsnMthdNm: String, // 예정가격결정방법명
                @SerializedName("qltyMngcst")
                val qltyMngcst: String, // 품질관리비
                @SerializedName("qltyMngcstAObjYn")
                val qltyMngcstAObjYn: String, // 품질관리비A적용대상여부
                @SerializedName("rtrfundNon")
                val rtrfundNon: String, // 퇴직공제부금비
                @SerializedName("sftyChckMngcst")
                val sftyChckMngcst: String, // 안전관리비
                @SerializedName("sftyMngcst")
                val sftyMngcst: String // 산업안전보건관리비
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