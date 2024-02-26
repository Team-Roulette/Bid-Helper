package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName
// 입찰공고목록 정보에 대한 면허제한정보조회
data class BidLicenseLimitDTO(
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
            val items: List<Item>, // 입찰 업종 제한 정보 항목 리스트
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
                @SerializedName("bsnsDivNm")
                val bsnsDivNm: String, // 업무구분명
                @SerializedName("d2bMngCnstwkNo")
                val d2bMngCnstwkNo: String, // 방사청관리공사번호
                @SerializedName("d2bMngDmndYear")
                val d2bMngDmndYear: String, // 방사청관리요구년도
                @SerializedName("indstrytyMfrcFldList")
                val indstrytyMfrcFldList: String, // 주력업종분야목록
                @SerializedName("lcnsLmtNm")
                val lcnsLmtNm: String, // 면허제한명
                @SerializedName("lmtGrpNo")
                val lmtGrpNo: String, // 제한그룹번호
                @SerializedName("lmtSno")
                val lmtSno: String, // 제한순번
                @SerializedName("permsnIndstrytyList")
                val permsnIndstrytyList: String, // 허용업종목록
                @SerializedName("rgstDt")
                val rgstDt: String // 등록일시
            )
        }

        data class Header(
            @SerializedName("resultCode")
            val resultCode: String, // 결과코드
            @SerializedName("resultMsg")
            val resultMsg: String // 결과메세지
        )
    }
}