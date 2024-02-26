package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName

// 나라장터 검색조건에 의한 낙찰된 목록 현황 물품조회
data class BidStatusThingSearchDTO(
    @SerializedName("response")
    val response: Response
) {
    data class Response(
        @SerializedName("body")
        val body: Body,
        @SerializedName("header")
        val header: Header
    ) {
        data class Body(
            @SerializedName("items")
            val items: List<Item>,
            @SerializedName("numOfRows") // 한 페이지 결과 수
            val numOfRows: String,
            @SerializedName("pageNo") // 페이지 수
            val pageNo: String,
            @SerializedName("totalCount") // 데이터 총 개수
            val totalCount: String
        ) {
            data class Item(
                @SerializedName("bidClsfcNo") // 입찰분류번호
                val bidClsfcNo: String,
                @SerializedName("bidNtceNm") // 입찰공고명
                val bidNtceNm: String,
                @SerializedName("bidNtceNo") // 입찰공고번호
                val bidNtceNo: String,
                @SerializedName("bidNtceOrd") // 입찰공고차수
                val bidNtceOrd: String,
                @SerializedName("bidwinnrAdrs") // 최종낙찰업체주소
                val bidwinnrAdrs: String,
                @SerializedName("bidwinnrBizno") // 최종낙찰업체사업자등록번호
                val bidwinnrBizno: String,
                @SerializedName("bidwinnrCeoNm") // 최종낙찰업체대표자명
                val bidwinnrCeoNm: String,
                @SerializedName("bidwinnrNm") // 최종낙찰업체명
                val bidwinnrNm: String,
                @SerializedName("bidwinnrTelNo") // 최종낙찰업체전화번호
                val bidwinnrTelNo: String,
                @SerializedName("dminsttCd") // 수요기관코드
                val dminsttCd: String,
                @SerializedName("dminsttNm") // 수요기관명
                val dminsttNm: String,
                @SerializedName("fnlSucsfCorpOfcl") // 최종낙찰업체담당자
                val fnlSucsfCorpOfcl: String,
                @SerializedName("fnlSucsfDate") // 최종낙찰일자
                val fnlSucsfDate: String,
                @SerializedName("linkInsttNm") // 연계기관명
                val linkInsttNm: String,
                @SerializedName("ntceDivCd") // 공고구분코드
                val ntceDivCd: String,
                @SerializedName("prtcptCnum") // 참가업체수
                val prtcptCnum: String,
                @SerializedName("rbidNo") // 재입찰번호
                val rbidNo: String,
                @SerializedName("rgstDt") // 등록일시
                val rgstDt: String,
                @SerializedName("rlOpengDt") // 실개찰일시
                val rlOpengDt: String,
                @SerializedName("sucsfbidAmt") // 최종낙찰금액
                val sucsfbidAmt: String,
                @SerializedName("sucsfbidRate") // 최종낙찰률
                val sucsfbidRate: String
            )
        }

        data class Header(
            @SerializedName("resultCode") // 결과코드
            val resultCode: String,
            @SerializedName("resultMsg") // 결과메세지
            val resultMsg: String
        )
    }
}
