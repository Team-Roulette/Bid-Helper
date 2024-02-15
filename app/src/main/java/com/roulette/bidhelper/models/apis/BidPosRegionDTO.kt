package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName

data class BidPosRegionDTO(
    @SerializedName("response")
    val response: Response // API 응답 전체를 나타냄
) {
    data class Response(
        @SerializedName("body")
        val body: Body, // 응답 본문
        @SerializedName("header")
        val header: Header // 응답 헤더
    ) {
        data class Body(
            @SerializedName("items")
            val items: List<Item>, // 입찰 참가 가능 지역 정보 리스트
            @SerializedName("numOfRows")
            val numOfRows: String, // 한 페이지 결과 수
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
                val bsnsDivNm: String, // 업무구분명 (공사, 물품, 용역 등)
                @SerializedName("d2bMngCnstwkNo")
                val d2bMngCnstwkNo: String, // 방사청관리공사번호
                @SerializedName("d2bMngDcsnNo")
                val d2bMngDcsnNo: String, // 방사청관리판단번호
                @SerializedName("d2bMngDmndYear")
                val d2bMngDmndYear: String, // 방사청관리요구년도
                @SerializedName("lmtSno")
                val lmtSno: String, // 제한순번
                @SerializedName("prtcptPsblRgnNm")
                val prtcptPsblRgnNm: String, // 참가가능지역명
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
