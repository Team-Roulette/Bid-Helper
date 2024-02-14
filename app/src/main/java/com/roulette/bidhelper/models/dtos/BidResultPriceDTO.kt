package com.roulette.bidhelper.models.dtos


import com.google.gson.annotations.SerializedName

data class BidResultPriceDTO(
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
            @SerializedName("numOfRows") 
            val numOfRows: String,
            @SerializedName("pageNo") 
            val pageNo: String,
            @SerializedName("totalCount") 
            val totalCount: String
        ) {
            data class Item(
                @SerializedName("bidClsfcNo") 
                val bidClsfcNo: String,
                @SerializedName("bidNtceNm") 
                val bidNtceNm: String,
                @SerializedName("bidNtceNo") 
                val bidNtceNo: String,
                @SerializedName("bidNtceOrd") 
                val bidNtceOrd: String,
                @SerializedName("dminsttCd") 
                val dminsttCd: String,
                @SerializedName("dminsttNm") 
                val dminsttNm: String,
                @SerializedName("inptDt") 
                val inptDt: String,
                @SerializedName("ntceInsttCd") 
                val ntceInsttCd: String,
                @SerializedName("ntceInsttNm") 
                val ntceInsttNm: String,
                @SerializedName("opengCorpInfo") 
                val opengCorpInfo: String,
                @SerializedName("opengDt") 
                val opengDt: String,
                @SerializedName("progrsDivCdNm") 
                val progrsDivCdNm: String,
                @SerializedName("prtcptCnum") 
                val prtcptCnum: String,
                @SerializedName("rbidNo") 
                val rbidNo: String,
                @SerializedName("rsrvtnPrceFileExistnceYn") 
                val rsrvtnPrceFileExistnceYn: String
            )
        }

        data class Header(
            @SerializedName("resultCode") 
            val resultCode: String,
            @SerializedName("resultMsg") 
            val resultMsg: String
        )
    }
}