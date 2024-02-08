package com.roulette.bidhelper.models

import com.google.gson.annotations.SerializedName

data class BidBasisAmount(
    @SerializedName("numOfRows") val numOfRows: String, // 한 페이지 결과 수
    @SerializedName("pageNo") val pageNo: String, // 페이지 번호,
    @SerializedName("ServiceKey") val serviceKey: String, // 공공데이터포탈에서 받은 인증키
    @SerializedName("inqryDiv") val inqryDiv: String, // 검색하고자하는 조회구분 1.입력일시, 2.입찰공고번호
    @SerializedName("inqryBgnDt") val inqryBgnDt: String?, // 검색하고자하는 조회시작일시
    @SerializedName("inqryEndDt") val inqryEndDt: String?, // 검색하고자하는 조회종료일시
    @SerializedName("bidNtceNo") val bidNtceNo: String?, // 검색하고자 하는 입찰공고번호, (조회구분 '2' 선택시 필수)
    @SerializedName("type") val type: String? // 오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정
)