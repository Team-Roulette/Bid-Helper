package com.roulette.bidhelper.models

data class BidBasisAmountDTO(val response: Response) { // 입찰공고목록 정보에 대한 물품기초금액조회
    data class Response(
        val body: Body,
        val header: Header
    ) {
        data class Body(
            val items: Items,
            val numOfRows: String,
            val pageNo: String,
            val totalCount: String
        ) {
            data class Items(
                val item: Item
            ) {
                data class Item(
                    val bidClsfcNo: String,
                    val bidNtceNm: String,
                    val bidNtceNo: String,
                    val bidNtceOrd: String,
                    val bssamt: String,
                    val bssamtOpenDt: String,
                    val dfcltydgrCfcnt: String,
                    val envCnsrvcst: String,
                    val etcGnrlexpnsBssRate: String,
                    val evlBssAmt: String,
                    val gnrlMngcstBssRate: String,
                    val industSftyHelthMngcst: String,
                    val inptDt: String,
                    val lbrcstBssRate: String,
                    val mrfnHealthInsrprm: String,
                    val npnInsrprm: String,
                    val prftBssRate: String,
                    val rmrk1: String,
                    val rmrk2: String,
                    val rsrvtnPrceRngBgnRate: String,
                    val rsrvtnPrceRngEndRate: String,
                    val rtrfundNon: String,
                    val scontrctPayprcePayGrntyFee: String,
                    val usefulAmt: String
                )
            }
        }

        data class Header(
            val resultCode: String,
            val resultMsg: String
        )
    }
}


