package com.roulette.bidhelper.models.apis.after

import com.google.gson.annotations.SerializedName

// 나라장터 검색조건에 의한 낙찰된 목록 현황 공사조회
data class BidStatusConstWorkSearchDTO(
    @SerializedName("response") val response: Response
) {
    data class Response(
        @SerializedName("body") val body: Body,
        @SerializedName("header") val header: Header
    ) {
        data class Body(
            @SerializedName("items") val items: List<Item>,
            @SerializedName("numOfRows") val numOfRows: String, // 한 페이지 결과 수
            @SerializedName("pageNo") val pageNo: String, // 페이지 번호
            @SerializedName("totalCount") val totalCount: String // 데이터 총 개수
        ) /*{
            data class Item(
                @SerializedName("bidClsfcNo") val bidClsfcNo: String, // 입찰분류번호
                @SerializedName("bidNtceNm") val bidNtceNm: String, // 입찰공고명
                @SerializedName("bidNtceNo") val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceOrd") val bidNtceOrd: String, // 입찰공고차수
                @SerializedName("bidwinnrAdrs") val bidwinnrAdrs: String, // 최종낙찰업체주소
                @SerializedName("bidwinnrBizno") val bidwinnrBizno: String, // 최종낙찰업체사업자등록번호
                @SerializedName("bidwinnrCeoNm") val bidwinnrCeoNm: String, // 최종낙찰업체대표자명
                @SerializedName("bidwinnrNm") val bidwinnrNm: String, // 최종낙찰업체명
                @SerializedName("bidwinnrTelNo") val bidwinnrTelNo: String, // 최종낙찰업체전화번호
                @SerializedName("dminsttCd") val dminsttCd: String, // 수요기관코드
                @SerializedName("dminsttNm") val dminsttNm: String, // 수요기관명
                @SerializedName("fnlSucsfCorpOfcl") val fnlSucsfCorpOfcl: String, // 최종낙찰업체담당자
                @SerializedName("fnlSucsfDate") val fnlSucsfDate: String, // 최종낙찰일자
                @SerializedName("linkInsttNm") val linkInsttNm: String, // 연계기관명
                @SerializedName("ntceDivCd") val ntceDivCd: String, // 공고구분코드
                @SerializedName("prtcptCnum") val prtcptCnum: String, // 참가업체수
                @SerializedName("rbidNo") val rbidNo: String, // 재입찰번호
                @SerializedName("rgstDt") val rgstDt: String, // 등록일시
                @SerializedName("rlOpengDt") val rlOpengDt: String, // 실개찰일시
                @SerializedName("sucsfbidAmt") val sucsfbidAmt: String, // 최종낙찰금액
                @SerializedName("sucsfbidRate") val sucsfbidRate: String // 최종낙찰률
            )
        }*/

        data class Header(
            @SerializedName("resultCode") val resultCode: String, // 결과코드
            @SerializedName("resultMsg") val resultMsg: String // 결과메세지
        )
    }
}
