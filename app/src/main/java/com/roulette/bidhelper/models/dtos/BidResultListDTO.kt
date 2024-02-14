package com.roulette.bidhelper.models.dtos


import com.google.gson.annotations.SerializedName

data class BidResultListDTO(
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
                @SerializedName("bidwinrSlctnAplBssCntnts") 
                val bidwinrSlctnAplBssCntnts: String,
                @SerializedName("bsisPlnprc") 
                val bsisPlnprc: String,
                @SerializedName("bssamt") 
                val bssamt: String,
                @SerializedName("bssamtBssUpNum") 
                val bssamtBssUpNum: String,
                @SerializedName("compnoRsrvtnPrceMkngDt") 
                val compnoRsrvtnPrceMkngDt: String,
                @SerializedName("compnoRsrvtnPrceSno") 
                val compnoRsrvtnPrceSno: String,
                @SerializedName("drwtNum") 
                val drwtNum: String,
                @SerializedName("drwtYn") 
                val drwtYn: String,
                @SerializedName("inptDt") 
                val inptDt: String,
                @SerializedName("plnprc") 
                val plnprc: String,
                @SerializedName("PrearngPrcePurcnstcst") 
                val prearngPrcePurcnstcst: String,
                @SerializedName("rbidNo") 
                val rbidNo: String,
                @SerializedName("rlOpengDt") 
                val rlOpengDt: String,
                @SerializedName("totRsrvtnPrceNum") 
                val totRsrvtnPrceNum: String
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