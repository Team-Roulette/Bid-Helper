package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName

// 입찰 결과 목록 정보를 위한 DTO
data class BidResultListDTO(
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
                @SerializedName("bidwinrSlctnAplBssCntnts")
                val bidwinrSlctnAplBssCntnts: String, // 낙찰자 선정 적용 기준 내용
                @SerializedName("bsisPlnprc")
                val bsisPlnprc: String, // 기초 계획가격
                @SerializedName("bssamt")
                val bssamt: String, // 기초금액
                @SerializedName("bssamtBssUpNum")
                val bssamtBssUpNum: String, // 기초금액 기준 상위 번호
                @SerializedName("compnoRsrvtnPrceMkngDt")
                val compnoRsrvtnPrceMkngDt: String, // 예비가격 작성일
                @SerializedName("compnoRsrvtnPrceSno")
                val compnoRsrvtnPrceSno: String, // 예비가격 일련번호
                @SerializedName("drwtNum")
                val drwtNum: String, // 추첨 번호
                @SerializedName("drwtYn")
                val drwtYn: String, // 추첨 여부
                @SerializedName("inptDt")
                val inptDt: String, // 입력 일시
                @SerializedName("plnprc")
                val plnprc: String, // 계획가격
                @SerializedName("PrearngPrcePurcnstcst")
                val prearngPrcePurcnstcst: String, // 예정가격 계산 기준
                @SerializedName("rbidNo")
                val rbidNo: String, // 재입찰 번호
                @SerializedName("rlOpengDt")
                val rlOpengDt: String, // 실제 개찰 일시
                @SerializedName("totRsrvtnPrceNum")
                val totRsrvtnPrceNum: String // 총 예비가격 번호
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