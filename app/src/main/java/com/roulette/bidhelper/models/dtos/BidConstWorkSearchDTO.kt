package com.roulette.bidhelper.models.dtos


import com.google.gson.annotations.SerializedName

data class BidConstWorkSearchDTO(
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
            @SerializedName("aplBssCntnts")
            val aplBssCntnts: String,
            @SerializedName("arsltApplDocRcptDt")
            val arsltApplDocRcptDt: String,
            @SerializedName("arsltApplDocRcptMthdNm")
            val arsltApplDocRcptMthdNm: String,
            @SerializedName("arsltCmptYn")
            val arsltCmptYn: String,
            @SerializedName("bdgtAmt")
            val bdgtAmt: String,
            @SerializedName("bfSpecRgstNo")
            val bfSpecRgstNo: String,
            @SerializedName("bidBeginDt")
            val bidBeginDt: String,
            @SerializedName("bidClseDt")
            val bidClseDt: String,
            @SerializedName("bidGrntymnyPaymntYn")
            val bidGrntymnyPaymntYn: String,
            @SerializedName("bidMethdNm")
            val bidMethdNm: String,
            @SerializedName("bidNtceDt")
            val bidNtceDt: String,
            @SerializedName("bidNtceDtlUrl")
            val bidNtceDtlUrl: String,
            @SerializedName("bidNtceNm")
            val bidNtceNm: String,
            @SerializedName("bidNtceNo")
            val bidNtceNo: String,
            @SerializedName("bidNtceOrd")
            val bidNtceOrd: String,
            @SerializedName("bidNtceUrl")
            val bidNtceUrl: String,
            @SerializedName("bidPrtcptFee")
            val bidPrtcptFee: String,
            @SerializedName("bidPrtcptFeePaymntYn")
            val bidPrtcptFeePaymntYn: String,
            @SerializedName("bidPrtcptLmtYn")
            val bidPrtcptLmtYn: String,
            @SerializedName("bidQlfctRgstDt")
            val bidQlfctRgstDt: String,
            @SerializedName("bidWgrnteeRcptClseDt")
            val bidWgrnteeRcptClseDt: String,
            @SerializedName("brffcBidprcPermsnYn")
            val brffcBidprcPermsnYn: String,
            @SerializedName("chgDt")
            val chgDt: String,
            @SerializedName("chgNtceRsn")
            val chgNtceRsn: String,
            @SerializedName("ciblAplYn")
            val ciblAplYn: String,
            @SerializedName("cmmnSpldmdAgrmntClseDt")
            val cmmnSpldmdAgrmntClseDt: String,
            @SerializedName("cmmnSpldmdAgrmntRcptdocMethd")
            val cmmnSpldmdAgrmntRcptdocMethd: String,
            @SerializedName("cmmnSpldmdCnum")
            val cmmnSpldmdCnum: String,
            @SerializedName("cmmnSpldmdCorpRgnLmtYn")
            val cmmnSpldmdCorpRgnLmtYn: String,
            @SerializedName("cmmnSpldmdMethdCd")
            val cmmnSpldmdMethdCd: String,
            @SerializedName("cmmnSpldmdMethdNm")
            val cmmnSpldmdMethdNm: String,
            @SerializedName("cnstrtnAbltyEvlAmtList")
            val cnstrtnAbltyEvlAmtList: String,
            @SerializedName("cnstrtsiteRgnNm")
            val cnstrtsiteRgnNm: String,
            @SerializedName("cnsttyAccotShreRateList")
            val cnsttyAccotShreRateList: String,
            @SerializedName("cntrctCnclsMthdNm")
            val cntrctCnclsMthdNm: String,
            @SerializedName("contrctrcnstrtnGovsplyMtrlAmt")
            val contrctrcnstrtnGovsplyMtrlAmt: String,
            @SerializedName("crdtrNm")
            val crdtrNm: String,
            @SerializedName("d2bMngAssmntLwstlmtRt")
            val d2bMngAssmntLwstlmtRt: String,
            @SerializedName("d2bMngAssmntUplmtRt")
            val d2bMngAssmntUplmtRt: String,
            @SerializedName("d2bMngBfEvalClseDt")
            val d2bMngBfEvalClseDt: String,
            @SerializedName("d2bMngBfEvalObjYn")
            val d2bMngBfEvalObjYn: String,
            @SerializedName("d2bMngBssamt")
            val d2bMngBssamt: String,
            @SerializedName("d2bMngCnstwkDivNm")
            val d2bMngCnstwkDivNm: String,
            @SerializedName("d2bMngCnstwkLctNm")
            val d2bMngCnstwkLctNm: String,
            @SerializedName("d2bMngCnstwkNo")
            val d2bMngCnstwkNo: String,
            @SerializedName("d2bMngCnstwkOutlnCntnts")
            val d2bMngCnstwkOutlnCntnts: String,
            @SerializedName("d2bMngCnstwkPrdCntnts")
            val d2bMngCnstwkPrdCntnts: String,
            @SerializedName("d2bMngCnstwkScleCntnts")
            val d2bMngCnstwkScleCntnts: String,
            @SerializedName("d2bMngDmndYear")
            val d2bMngDmndYear: String,
            @SerializedName("d2bMngNgttnPlanDate")
            val d2bMngNgttnPlanDate: String,
            @SerializedName("d2bMngNgttnStleNm")
            val d2bMngNgttnStleNm: String,
            @SerializedName("d2bMngPblctPlceNm")
            val d2bMngPblctPlceNm: String,
            @SerializedName("d2bMngProgrsSttusNm")
            val d2bMngProgrsSttusNm: String,
            @SerializedName("d2bMngRgnLmtYn")
            val d2bMngRgnLmtYn: String,
            @SerializedName("d2bMngRgstEvalExmpYn")
            val d2bMngRgstEvalExmpYn: String,
            @SerializedName("d2bMngRsrvtnPrceBssAplYn")
            val d2bMngRsrvtnPrceBssAplYn: String,
            @SerializedName("dcmtgOprtnDt")
            val dcmtgOprtnDt: String,
            @SerializedName("dcmtgOprtnPlce")
            val dcmtgOprtnPlce: String,
            @SerializedName("dminsttCd")
            val dminsttCd: String,
            @SerializedName("dminsttNm")
            val dminsttNm: String,
            @SerializedName("dminsttOfclEmailAdrs")
            val dminsttOfclEmailAdrs: String,
            @SerializedName("drwtPrdprcNum")
            val drwtPrdprcNum: String,
            @SerializedName("dsgntCmptYn")
            val dsgntCmptYn: String,
            @SerializedName("dtlsBidYn")
            val dtlsBidYn: String,
            @SerializedName("exctvNm")
            val exctvNm: String,
            @SerializedName("govcnstrtnGovsplyMtrlAmt")
            val govcnstrtnGovsplyMtrlAmt: String,
            @SerializedName("govsplyAmt")
            val govsplyAmt: String,
            @SerializedName("incntvRgnNm1")
            val incntvRgnNm1: String,
            @SerializedName("incntvRgnNm2")
            val incntvRgnNm2: String,
            @SerializedName("incntvRgnNm3")
            val incntvRgnNm3: String,
            @SerializedName("incntvRgnNm4")
            val incntvRgnNm4: String,
            @SerializedName("indstrytyEvlRt")
            val indstrytyEvlRt: String,
            @SerializedName("indstrytyLmtYn")
            val indstrytyLmtYn: String,
            @SerializedName("indstrytyMfrcFldEvlYn")
            val indstrytyMfrcFldEvlYn: String,
            @SerializedName("indutyVAT")
            val indutyVAT: String,
            @SerializedName("intrbidYn")
            val intrbidYn: String,
            @SerializedName("jntcontrctDutyRgnNm1")
            val jntcontrctDutyRgnNm1: String,
            @SerializedName("jntcontrctDutyRgnNm2")
            val jntcontrctDutyRgnNm2: String,
            @SerializedName("jntcontrctDutyRgnNm3")
            val jntcontrctDutyRgnNm3: String,
            @SerializedName("linkInsttNm")
            val linkInsttNm: String,
            @SerializedName("mainCnsttyCnstwkPrearngAmt")
            val mainCnsttyCnstwkPrearngAmt: String,
            @SerializedName("mainCnsttyNm")
            val mainCnsttyNm: String,
            @SerializedName("mainCnsttyPresmptPrce")
            val mainCnsttyPresmptPrce: String,
            @SerializedName("mtltyAdvcPsblYn")
            val mtltyAdvcPsblYn: String,
            @SerializedName("mtltyAdvcPsblYnCnstwkNm")
            val mtltyAdvcPsblYnCnstwkNm: String,
            @SerializedName("ntceDscrptYn")
            val ntceDscrptYn: String,
            @SerializedName("ntceInsttCd")
            val ntceInsttCd: String,
            @SerializedName("ntceInsttNm")
            val ntceInsttNm: String,
            @SerializedName("ntceInsttOfclEmailAdrs")
            val ntceInsttOfclEmailAdrs: String,
            @SerializedName("ntceInsttOfclNm")
            val ntceInsttOfclNm: String,
            @SerializedName("ntceInsttOfclTelNo")
            val ntceInsttOfclTelNo: String,
            @SerializedName("ntceKindNm")
            val ntceKindNm: String,
            @SerializedName("ntceSpecDocUrl1")
            val ntceSpecDocUrl1: String,
            @SerializedName("ntceSpecDocUrl10")
            val ntceSpecDocUrl10: String,
            @SerializedName("ntceSpecDocUrl2")
            val ntceSpecDocUrl2: String,
            @SerializedName("ntceSpecDocUrl3")
            val ntceSpecDocUrl3: String,
            @SerializedName("ntceSpecDocUrl4")
            val ntceSpecDocUrl4: String,
            @SerializedName("ntceSpecDocUrl5")
            val ntceSpecDocUrl5: String,
            @SerializedName("ntceSpecDocUrl6")
            val ntceSpecDocUrl6: String,
            @SerializedName("ntceSpecDocUrl7")
            val ntceSpecDocUrl7: String,
            @SerializedName("ntceSpecDocUrl8")
            val ntceSpecDocUrl8: String,
            @SerializedName("ntceSpecDocUrl9")
            val ntceSpecDocUrl9: String,
            @SerializedName("ntceSpecFileNm1")
            val ntceSpecFileNm1: String,
            @SerializedName("ntceSpecFileNm10")
            val ntceSpecFileNm10: String,
            @SerializedName("ntceSpecFileNm2")
            val ntceSpecFileNm2: String,
            @SerializedName("ntceSpecFileNm3")
            val ntceSpecFileNm3: String,
            @SerializedName("ntceSpecFileNm4")
            val ntceSpecFileNm4: String,
            @SerializedName("ntceSpecFileNm5")
            val ntceSpecFileNm5: String,
            @SerializedName("ntceSpecFileNm6")
            val ntceSpecFileNm6: String,
            @SerializedName("ntceSpecFileNm7")
            val ntceSpecFileNm7: String,
            @SerializedName("ntceSpecFileNm8")
            val ntceSpecFileNm8: String,
            @SerializedName("ntceSpecFileNm9")
            val ntceSpecFileNm9: String,
            @SerializedName("opengDt")
            val opengDt: String,
            @SerializedName("opengPlce")
            val opengPlce: String,
            @SerializedName("orderPlanUntyNo")
            val orderPlanUntyNo: String,
            @SerializedName("pqApplDocRcptDt")
            val pqApplDocRcptDt: String,
            @SerializedName("pqApplDocRcptMthdNm")
            val pqApplDocRcptMthdNm: String,
            @SerializedName("pqEvalYn")
            val pqEvalYn: String,
            @SerializedName("prearngPrceDcsnMthdNm")
            val prearngPrceDcsnMthdNm: String,
            @SerializedName("presmptPrce")
            val presmptPrce: String,
            @SerializedName("rbidOpengDt")
            val rbidOpengDt: String,
            @SerializedName("rbidPermsnYn")
            val rbidPermsnYn: String,
            @SerializedName("reNtceYn")
            val reNtceYn: String,
            @SerializedName("refNo")
            val refNo: String,
            @SerializedName("rgnDutyJntcontrctRt")
            val rgnDutyJntcontrctRt: String,
            @SerializedName("rgnDutyJntcontrctYn")
            val rgnDutyJntcontrctYn: String,
            @SerializedName("rgstDt")
            val rgstDt: String,
            @SerializedName("rgstTyNm")
            val rgstTyNm: String,
            @SerializedName("rsrvtnPrceReMkngMthdNm")
            val rsrvtnPrceReMkngMthdNm: String,
            @SerializedName("sptDscrptDocUrl1")
            val sptDscrptDocUrl1: String,
            @SerializedName("sptDscrptDocUrl2")
            val sptDscrptDocUrl2: String,
            @SerializedName("sptDscrptDocUrl3")
            val sptDscrptDocUrl3: String,
            @SerializedName("sptDscrptDocUrl4")
            val sptDscrptDocUrl4: String,
            @SerializedName("sptDscrptDocUrl5")
            val sptDscrptDocUrl5: String,
            @SerializedName("stdNtceDocUrl")
            val stdNtceDocUrl: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt1")
            val subsiCnsttyIndstrytyEvlRt1: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt2")
            val subsiCnsttyIndstrytyEvlRt2: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt3")
            val subsiCnsttyIndstrytyEvlRt3: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt4")
            val subsiCnsttyIndstrytyEvlRt4: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt5")
            val subsiCnsttyIndstrytyEvlRt5: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt6")
            val subsiCnsttyIndstrytyEvlRt6: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt7")
            val subsiCnsttyIndstrytyEvlRt7: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt8")
            val subsiCnsttyIndstrytyEvlRt8: String,
            @SerializedName("subsiCnsttyIndstrytyEvlRt9")
            val subsiCnsttyIndstrytyEvlRt9: String,
            @SerializedName("subsiCnsttyNm1")
            val subsiCnsttyNm1: String,
            @SerializedName("subsiCnsttyNm2")
            val subsiCnsttyNm2: String,
            @SerializedName("subsiCnsttyNm3")
            val subsiCnsttyNm3: String,
            @SerializedName("subsiCnsttyNm4")
            val subsiCnsttyNm4: String,
            @SerializedName("subsiCnsttyNm5")
            val subsiCnsttyNm5: String,
            @SerializedName("subsiCnsttyNm6")
            val subsiCnsttyNm6: String,
            @SerializedName("subsiCnsttyNm7")
            val subsiCnsttyNm7: String,
            @SerializedName("subsiCnsttyNm8")
            val subsiCnsttyNm8: String,
            @SerializedName("subsiCnsttyNm9")
            val subsiCnsttyNm9: String,
            @SerializedName("sucsfbidLwltRate")
            val sucsfbidLwltRate: String,
            @SerializedName("sucsfbidMthdCd")
            val sucsfbidMthdCd: String,
            @SerializedName("sucsfbidMthdNm")
            val sucsfbidMthdNm: String,
            @SerializedName("totPrdprcNum")
            val totPrdprcNum: String,
            @SerializedName("untyNtceNo")
            val untyNtceNo: String,
            @SerializedName("VAT")
            val vAT: String
        )
    }


    data class Header(
        @SerializedName("resultCode")
        val resultCode: String,
        @SerializedName("resultMsg")
        val resultMsg: String
    )
}