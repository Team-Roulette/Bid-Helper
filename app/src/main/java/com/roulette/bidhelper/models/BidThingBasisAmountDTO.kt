package com.roulette.bidhelper.models

import com.google.gson.annotations.SerializedName
data class BidThingBasisAmountDTO(
    @SerializedName("response") val response: Response
)

data class Response(
    @SerializedName("body") val body: Body,
    @SerializedName("header") val header: Header
)

data class Body(
    @SerializedName("items") val items: List<Item>,
    @SerializedName("numOfRows") val numOfRows: String,
    @SerializedName("pageNo") val pageNo: String,
    @SerializedName("totalCount") val totalCount: String
)

data class Header(
    @SerializedName("resultCode") val resultCode: String,
    @SerializedName("resultMsg") val resultMsg: String
)

data class Item( //
    @SerializedName("bidClsfcNo") val bidClsfcNo: String,
    @SerializedName("bidNtceNm") val bidNtceNm: String,
    @SerializedName("bidNtceNo") val bidNtceNo: String,
    @SerializedName("bidNtceOrd") val bidNtceOrd: String,
    @SerializedName("bssamt") val bssamt: String,
    @SerializedName("bssamtOpenDt") val bssamtOpenDt: String,
    @SerializedName("dfcltydgrCfcnt") val dfcltydgrCfcnt: String,
    @SerializedName("envCnsrvcst") val envCnsrvcst: String,
    @SerializedName("etcGnrlexpnsBssRate") val etcGnrlexpnsBssRate: String,
    @SerializedName("evlBssAmt") val evlBssAmt: String,
    @SerializedName("gnrlMngcstBssRate") val gnrlMngcstBssRate: String,
    @SerializedName("industSftyHelthMngcst") val industSftyHelthMngcst: String,
    @SerializedName("inptDt") val inptDt: String,
    @SerializedName("lbrcstBssRate") val lbrcstBssRate: String,
    @SerializedName("mrfnHealthInsrprm") val mrfnHealthInsrprm: String,
    @SerializedName("npnInsrprm") val npnInsrprm: String,
    @SerializedName("prftBssRate") val prftBssRate: String,
    @SerializedName("rmrk1") val rmrk1: String,
    @SerializedName("rmrk2") val rmrk2: String,
    @SerializedName("rsrvtnPrceRngBgnRate") val rsrvtnPrceRngBgnRate: String,
    @SerializedName("rsrvtnPrceRngEndRate") val rsrvtnPrceRngEndRate: String,
    @SerializedName("rtrfundNon") val rtrfundNon: String,
    @SerializedName("scontrctPayprcePayGrntyFee") val scontrctPayprcePayGrntyFee: String,
    @SerializedName("usefulAmt") val usefulAmt: String
)