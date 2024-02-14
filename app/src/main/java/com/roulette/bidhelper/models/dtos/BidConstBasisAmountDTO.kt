package com.roulette.bidhelper.models.dtos

import com.google.gson.annotations.SerializedName

data class BidConstBasisAmountDTO(
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
                @SerializedName("bidPrceCalclAYn")
                val bidPrceCalclAYn: String,
                @SerializedName("bssAmtPurcnstcst")
                val bssAmtPurcnstcst: String,
                @SerializedName("bssamt")
                val bssamt: String,
                @SerializedName("bssamtOpenDt")
                val bssamtOpenDt: String,
                @SerializedName("dfcltydgrCfcnt")
                val dfcltydgrCfcnt: String,
                @SerializedName("envCnsrvcst")
                val envCnsrvcst: String,
                @SerializedName("etcGnrlexpnsBssRate")
                val etcGnrlexpnsBssRate: String,
                @SerializedName("evlBssAmt")
                val evlBssAmt: String,
                @SerializedName("gnrlMngcstBssRate")
                val gnrlMngcstBssRate: String,
                @SerializedName("inptDt")
                val inptDt: String,
                @SerializedName("lbrcstBssRate")
                val lbrcstBssRate: String,
                @SerializedName("mrfnHealthInsrprm")
                val mrfnHealthInsrprm: String,
                @SerializedName("npnInsrprm")
                val npnInsrprm: String,
                @SerializedName("odsnLngtrmrcprInsrprm")
                val odsnLngtrmrcprInsrprm: String,
                @SerializedName("prftBssRate")
                val prftBssRate: String,
                @SerializedName("qltyMngcst")
                val qltyMngcst: String,
                @SerializedName("qltyMngcstAObjYn")
                val qltyMngcstAObjYn: String,
                @SerializedName("rmrk1")
                val rmrk1: String,
                @SerializedName("rmrk2")
                val rmrk2: String,
                @SerializedName("rsrvtnPrceRngBgnRate")
                val rsrvtnPrceRngBgnRate: String,
                @SerializedName("rsrvtnPrceRngEndRate")
                val rsrvtnPrceRngEndRate: String,
                @SerializedName("rtrfundNon")
                val rtrfundNon: String,
                @SerializedName("scontrctPayprcePayGrntyFee")
                val scontrctPayprcePayGrntyFee: String,
                @SerializedName("sftyChckMngcst")
                val sftyChckMngcst: String,
                @SerializedName("sftyMngcst")
                val sftyMngcst: String,
                @SerializedName("usefulAmt")
                val usefulAmt: String
            )
        }
    }

    data class Header(
        @SerializedName("resultCode")
        val resultCode: String,
        @SerializedName("resultMsg")
        val resultMsg: String
    )
}