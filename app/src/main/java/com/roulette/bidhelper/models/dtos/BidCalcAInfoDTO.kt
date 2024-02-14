package com.roulette.bidhelper.models.dtos


import com.google.gson.annotations.SerializedName

data class BidCalcAInfoDTO(
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
                @SerializedName("bidPrceCalclAOpenDt")
                val bidPrceCalclAOpenDt: String,
                @SerializedName("mrfnHealthInsrprm")
                val mrfnHealthInsrprm: String,
                @SerializedName("npnInsrprm")
                val npnInsrprm: String,
                @SerializedName("ntceNticeDt")
                val ntceNticeDt: String,
                @SerializedName("odsnLngtrmrcprInsrprm")
                val odsnLngtrmrcprInsrprm: String,
                @SerializedName("prearngPrceDcsnMthdNm")
                val prearngPrceDcsnMthdNm: String,
                @SerializedName("qltyMngcst")
                val qltyMngcst: String,
                @SerializedName("qltyMngcstAObjYn")
                val qltyMngcstAObjYn: String,
                @SerializedName("rtrfundNon")
                val rtrfundNon: String,
                @SerializedName("sftyChckMngcst")
                val sftyChckMngcst: String,
                @SerializedName("sftyMngcst")
                val sftyMngcst: String
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