package com.roulette.bidhelper.models.apis.after

import com.google.gson.annotations.SerializedName

// 개찰결과 공사 예비가격 상세 목록 조회
// 물품 및 용역도 거의 비슷하니까 이걸로 쓰자

data class BidConstWorkResultPriceDTO(
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
                @SerializedName("resultCode")
                val resultCode: String, // 결과코드
                @SerializedName("resultMsg")
                val resultMsg: String, // 결과메세지
                @SerializedName("numOfRows")
                val numOfRows: String, // 한 페이지 결과 수
                @SerializedName("pageNo")
                val pageNo: String, // 페이지 수
                @SerializedName("totalCount")
                val totalCount: String, // 데이터 총 개수
                @SerializedName("bidNtceNo")
                val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String, // 입찰공고차수
                @SerializedName("bidClsfcNo")
                val bidClsfcNo: String, // 입찰분류번호
                @SerializedName("rbidNo")
                val rbidNo: String, // 재입찰번호
                @SerializedName("bidNtceNm")
                val bidNtceNm: String, // 입찰공고명
                @SerializedName("inptDt")
                val inptDt: String, // 입력 일시
                @SerializedName("plnprc")
                val plnprc: String, // 예정가격
                @SerializedName("bssamt")
                val bssamt: String, // 기초금액
                @SerializedName("drwtYn")
                val drwtYn: String, // 추첨여부
                @SerializedName("drwtNum")
                val drwtNum: String, // 추첨횟수
                @SerializedName("bidwinrSlctnAplBssCntnts")
                val bidwinrSlctnAplBssCntnts: String, // 최종낙찰자선정적용기준내용
                @SerializedName("rlOpengDt")
                val rlOpengDt: String, // 실개찰일시
                @SerializedName("bssamtBssUpNum")
                val bssamtBssUpNum: String, // 기초금액기준상위건수
                @SerializedName("dminsttCd")
                val dminsttCd: String, // 수요기관 코드
                @SerializedName("dminsttNm")
                val dminsttNm: String, // 수요기관명
                @SerializedName("ntceInsttCd")
                val ntceInsttCd: String, // 공고기관 코드
                @SerializedName("ntceInsttNm")
                val ntceInsttNm: String, // 공고기관명
                @SerializedName("opengCorpInfo")
                val opengCorpInfo: String, // 개찰 업체 정보
                @SerializedName("progrsDivCdNm")
                val progrsDivCdNm: String, // 진행 구분 코드명
                @SerializedName("prtcptCnum")
                val prtcptCnum: String, // 참가업체 수
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
