package com.roulette.bidhelper.models.apis.etc


import com.google.gson.annotations.SerializedName

// 업종 및 근거법규 정보 조회
data class BidBaseInfoListDTO(
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
            val numOfRows: Int,
            @SerializedName("pageNo")
            val pageNo: Int,
            @SerializedName("totalCount")
            val totalCount: Int
        ) {
            data class Item(
                @SerializedName("baseLawordArtclClauseNm")
                val baseLawordArtclClauseNm: String,
                @SerializedName("baseLawordNm")
                val baseLawordNm: String,
                @SerializedName("baseLawordUrl")
                val baseLawordUrl: String,
                @SerializedName("inclsnLcns")
                val inclsnLcns: String,
                @SerializedName("indstrytyCd")
                val indstrytyCd: String,
                @SerializedName("indstrytyChgDt")
                val indstrytyChgDt: String,
                @SerializedName("indstrytyClsfcCd")
                val indstrytyClsfcCd: String,
                @SerializedName("indstrytyClsfcNm")
                val indstrytyClsfcNm: String,
                @SerializedName("indstrytyNm")
                val indstrytyNm: String,
                @SerializedName("indstrytyRgstDt")
                val indstrytyRgstDt: String,
                @SerializedName("indstrytyUseYn")
                val indstrytyUseYn: String,
                @SerializedName("rltnRgltCntnts")
                val rltnRgltCntnts: String
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