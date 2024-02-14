package com.roulette.bidhelper.models.dtos


import com.google.gson.annotations.SerializedName

data class BidLicenseLimitDTO(
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
                @SerializedName("bidNtceNo")
                val bidNtceNo: String,
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String,
                @SerializedName("bsnsDivNm")
                val bsnsDivNm: String,
                @SerializedName("d2bMngCnstwkNo")
                val d2bMngCnstwkNo: String,
                @SerializedName("d2bMngDmndYear")
                val d2bMngDmndYear: String,
                @SerializedName("indstrytyMfrcFldList")
                val indstrytyMfrcFldList: String,
                @SerializedName("lcnsLmtNm")
                val lcnsLmtNm: String,
                @SerializedName("lmtGrpNo")
                val lmtGrpNo: String,
                @SerializedName("lmtSno")
                val lmtSno: String,
                @SerializedName("permsnIndstrytyList")
                val permsnIndstrytyList: String,
                @SerializedName("rgstDt")
                val rgstDt: String
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