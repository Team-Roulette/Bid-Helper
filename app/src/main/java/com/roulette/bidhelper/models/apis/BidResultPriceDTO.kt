package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName

// 개찰결과 공사 예비가격상세 목록 조회
data class BidResultPriceDTO(
    @SerializedName("response")
    val response: Response // 응답 전체를 담는 객체
) {
    data class Response(
        @SerializedName("body")
        val body: Body, // 응답 본문
        @SerializedName("header")
        val header: Header // 응답 헤더
    ) {
        data class Body(
            @SerializedName("items")
            val items: List<Item>, // 입찰 항목 목록
            @SerializedName("numOfRows")
            val numOfRows: String, // 페이지당 결과 수
            @SerializedName("pageNo")
            val pageNo: String, // 페이지 번호
            @SerializedName("totalCount")
            val totalCount: String // 전체 결과 수
        ) {
            data class Item(
                @SerializedName("bidClsfcNo")
                val bidClsfcNo: String, // 입찰 분류 번호
                @SerializedName("bidNtceNm")
                val bidNtceNm: String, // 입찰 공고명
                @SerializedName("bidNtceNo")
                val bidNtceNo: String, // 입찰 공고번호
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String, // 입찰 공고차수
                @SerializedName("dminsttCd")
                val dminsttCd: String, // 수요기관 코드
                @SerializedName("dminsttNm")
                val dminsttNm: String, // 수요기관명
                @SerializedName("inptDt")
                val inptDt: String, // 입력 일시
                @SerializedName("ntceInsttCd")
                val ntceInsttCd: String, // 공고기관 코드
                @SerializedName("ntceInsttNm")
                val ntceInsttNm: String, // 공고기관명
                @SerializedName("opengCorpInfo")
                val opengCorpInfo: String, // 개찰 업체 정보
                @SerializedName("opengDt")
                val opengDt: String, // 개찰 일시
                @SerializedName("progrsDivCdNm")
                val progrsDivCdNm: String, // 진행 구분 코드명
                @SerializedName("prtcptCnum")
                val prtcptCnum: String, // 참가업체 수
                @SerializedName("rbidNo")
                val rbidNo: String, // 재입찰 번호
                @SerializedName("rsrvtnPrceFileExistnceYn")
                val rsrvtnPrceFileExistnceYn: String // 예비가격 파일 존재 여부
            )
        }

        data class Header(
            @SerializedName("resultCode")
            val resultCode: String, // 결과 코드
            @SerializedName("resultMsg")
            val resultMsg: String // 결과 메세지
        )
    }
}
