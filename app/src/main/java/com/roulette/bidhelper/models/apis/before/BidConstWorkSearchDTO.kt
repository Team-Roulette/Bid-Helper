package com.roulette.bidhelper.models.apis.before

import com.google.gson.annotations.SerializedName

// 나라장터검색조건에 의한 입찰공고공사조회
data class BidConstWorkSearchDTO(
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
            val items: List<Item>, // 입찰 공사 정보 항목 리스트
            @SerializedName("numOfRows")
            val numOfRows: String, // 한 페이지 결과 수
            @SerializedName("pageNo")
            val pageNo: String, // 페이지 번호
            @SerializedName("totalCount")
            val totalCount: String // 전체 결과 수
        ) {
            data class Item(
                @SerializedName("aplBssCntnts")
                val aplBssCntnts: String, // 적용기준내용
                @SerializedName("arsltApplDocRcptDt")
                val arsltApplDocRcptDt: String, // 실적신청서접수일시
                @SerializedName("arsltApplDocRcptMthdNm")
                val arsltApplDocRcptMthdNm: String, // 실적신청서접수방법명
                @SerializedName("arsltCmptYn")
                val arsltCmptYn: String, // 실적경쟁여부
                @SerializedName("bdgtAmt")
                val bdgtAmt: String, // 예산금액
                @SerializedName("bfSpecRgstNo")
                val bfSpecRgstNo: String, // 사전규격등록번호
                @SerializedName("bidBeginDt")
                val bidBeginDt: String, // 입찰개시일시
                @SerializedName("bidClseDt")
                val bidClseDt: String, // 입찰마감일시
                @SerializedName("bidGrntymnyPaymntYn")
                val bidGrntymnyPaymntYn: String, // 입찰보증금납부여부
                @SerializedName("bidMethdNm")
                val bidMethdNm: String, // 입찰방식명
                @SerializedName("bidNtceDt")
                val bidNtceDt: String, // 입찰공고일시
                @SerializedName("bidNtceDtlUrl")
                val bidNtceDtlUrl: String, // 입찰공고상세URL
                @SerializedName("bidNtceNm")
                val bidNtceNm: String, // 입찰공고명
                @SerializedName("bidNtceNo")
                val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceOrd")
                val bidNtceOrd: String, // 입찰공고차수
                @SerializedName("bidNtceUrl")
                val bidNtceUrl: String, // 입찰공고URL
                @SerializedName("bidPrtcptFee")
                val bidPrtcptFee: String, // 입찰참가수수료
                @SerializedName("bidPrtcptFeePaymntYn")
                val bidPrtcptFeePaymntYn: String, // 입찰참가수수료납부여부
                @SerializedName("bidPrtcptLmtYn")
                val bidPrtcptLmtYn: String, // 입찰참가제한여부
                @SerializedName("bidQlfctRgstDt")
                val bidQlfctRgstDt: String, // 입찰참가자격등록마감일시
                @SerializedName("bidWgrnteeRcptClseDt")
                val bidWgrnteeRcptClseDt: String, // 입찰보증서접수마감일시
                @SerializedName("brffcBidprcPermsnYn")
                val brffcBidprcPermsnYn: String, // 지사투찰허용여부
                @SerializedName("chgDt")
                val chgDt: String, // 변경일시
                @SerializedName("chgNtceRsn")
                val chgNtceRsn: String, // 변경공고사유
                @SerializedName("ciblAplYn")
                val ciblAplYn: String, // 건설산업법적용대상여부
                @SerializedName("cmmnSpldmdAgrmntClseDt")
                val cmmnSpldmdAgrmntClseDt: String, // 공동수급협정마감일시
                @SerializedName("cmmnSpldmdAgrmntRcptdocMethd")
                val cmmnSpldmdAgrmntRcptdocMethd: String, // 공동수급협정서접수방식
                @SerializedName("cmmnSpldmdCnum")
                val cmmnSpldmdCnum: String, // 공동수급업체수
                @SerializedName("cmmnSpldmdCorpRgnLmtYn")
                val cmmnSpldmdCorpRgnLmtYn: String, // 공동수급업체지역제한여부
                @SerializedName("cmmnSpldmdMethdCd")
                val cmmnSpldmdMethdCd: String, // 공동수급방식코드
                @SerializedName("cmmnSpldmdMethdNm")
                val cmmnSpldmdMethdNm: String, // 공동수급방식명
                @SerializedName("cnstrtnAbltyEvlAmtList")
                val cnstrtnAbltyEvlAmtList: String, // 시공능력평가금액목록
                @SerializedName("cnstrtsiteRgnNm")
                val cnstrtsiteRgnNm: String, // 공사현장지역명
                @SerializedName("cnsttyAccotShreRateList")
                val cnsttyAccotShreRateList: String, // 공종별지분율목록
                @SerializedName("cntrctCnclsMthdNm")
                val cntrctCnclsMthdNm: String, // 계약체결방법명
                @SerializedName("contrctrcnstrtnGovsplyMtrlAmt")
                val contrctrcnstrtnGovsplyMtrlAmt: String, // 도급자설치관급자재금액
                @SerializedName("crdtrNm")
                val crdtrNm: String, // 채권자명
                @SerializedName("d2bMngAssmntLwstlmtRt")
                val d2bMngAssmntLwstlmtRt: String, // 방사청관리사정하한율
                @SerializedName("d2bMngAssmntUplmtRt")
                val d2bMngAssmntUplmtRt: String, // 방사청관리사정상한율
                @SerializedName("d2bMngBfEvalClseDt")
                val d2bMngBfEvalClseDt: String, // 방사청관리사전심사마감일시
                @SerializedName("d2bMngBfEvalObjYn")
                val d2bMngBfEvalObjYn: String, // 방사청관리사전심사대상여부
                @SerializedName("d2bMngBssamt")
                val d2bMngBssamt: String, // 방사청관리기초금액
                @SerializedName("d2bMngCnstwkDivNm")
                val d2bMngCnstwkDivNm: String, // 방사청관리공사구분명
                @SerializedName("d2bMngCnstwkLctNm")
                val d2bMngCnstwkLctNm: String, // 방사청관리공사위치명
                @SerializedName("d2bMngCnstwkNo")
                val d2bMngCnstwkNo: String, // 방사청관리공사번호
                @SerializedName("d2bMngCnstwkOutlnCntnts")
                val d2bMngCnstwkOutlnCntnts: String, // 방사청관리공사개요내용
                @SerializedName("d2bMngCnstwkPrdCntnts")
                val d2bMngCnstwkPrdCntnts: String, // 방사청관리공사기간내용
                @SerializedName("d2bMngCnstwkScleCntnts")
                val d2bMngCnstwkScleCntnts: String, // 방사청관리공사규모내용
                @SerializedName("d2bMngDmndYear")
                val d2bMngDmndYear: String, // 방사청관리요구년도
                @SerializedName("d2bMngNgttnPlanDate")
                val d2bMngNgttnPlanDate: String, // 방사청관리협상계획일자
                @SerializedName("d2bMngNgttnStleNm")
                val d2bMngNgttnStleNm: String, // 방사청관리협상형태명
                @SerializedName("d2bMngPblctPlceNm")
                val d2bMngPblctPlceNm: String, // 방사청관리게재장소명
                @SerializedName("d2bMngProgrsSttusNm")
                val d2bMngProgrsSttusNm: String, // 방사청관리진행상태명
                @SerializedName("d2bMngRgnLmtYn")
                val d2bMngRgnLmtYn: String, // 방사청관리지역제한여부
                @SerializedName("d2bMngRgstEvalExmpYn")
                val d2bMngRgstEvalExmpYn: String, // 방사청관리등록심사면제여부
                @SerializedName("d2bMngRsrvtnPrceBssAplYn")
                val d2bMngRsrvtnPrceBssAplYn: String, // 방사청관리예비가격기초적용여부
                @SerializedName("dcmtgOprtnDt")
                val dcmtgOprtnDt: String, // 설명회실시일시
                @SerializedName("dcmtgOprtnPlce")
                val dcmtgOprtnPlce: String, // 설명회실시장소
                @SerializedName("dminsttCd")
                val dminsttCd: String, // 수요기관코드
                @SerializedName("dminsttNm")
                val dminsttNm: String, // 수요기관명
                @SerializedName("dminsttOfclEmailAdrs")
                val dminsttOfclEmailAdrs: String, // 수요기관담당자이메일주소
                @SerializedName("drwtPrdprcNum")
                val drwtPrdprcNum: String, // 추첨예가건수
                @SerializedName("dsgntCmptYn")
                val dsgntCmptYn: String, // 지명경쟁여부
                @SerializedName("dtlsBidYn")
                val dtlsBidYn: String, // 내역입찰여부
                @SerializedName("exctvNm")
                val exctvNm: String, // 집행관명
                @SerializedName("govcnstrtnGovsplyMtrlAmt")
                val govcnstrtnGovsplyMtrlAmt: String, // 관급자설치관급자재금액
                @SerializedName("govsplyAmt")
                val govsplyAmt: String, // 관급금액
                @SerializedName("incntvRgnNm1")
                val incntvRgnNm1: String, // 가산지역명1
                @SerializedName("incntvRgnNm2")
                val incntvRgnNm2: String, // 가산지역명2
                @SerializedName("incntvRgnNm3")
                val incntvRgnNm3: String, // 가산지역명3
                @SerializedName("incntvRgnNm4")
                val incntvRgnNm4: String, // 가산지역명4
                @SerializedName("indstrytyEvlRt")
                val indstrytyEvlRt: String, // 업종평가비율
                @SerializedName("indstrytyLmtYn")
                val indstrytyLmtYn: String, // 업종제한여부
                @SerializedName("indstrytyMfrcFldEvlYn")
                val indstrytyMfrcFldEvlYn: String, // 주력분야평가여부
                @SerializedName("indutyVAT")
                val indutyVAT: String, // 주공종부가가치세
                @SerializedName("intrbidYn")
                val intrbidYn: String, // 국제입찰여부
                @SerializedName("jntcontrctDutyRgnNm1")
                val jntcontrctDutyRgnNm1: String, // 공동도급의무지역명1
                @SerializedName("jntcontrctDutyRgnNm2")
                val jntcontrctDutyRgnNm2: String, // 공동도급의무지역명2
                @SerializedName("jntcontrctDutyRgnNm3")
                val jntcontrctDutyRgnNm3: String, // 공동도급의무지역명3
                @SerializedName("linkInsttNm")
                val linkInsttNm: String, // 연계기관명
                @SerializedName("mainCnsttyCnstwkPrearngAmt")
                val mainCnsttyCnstwkPrearngAmt: String, // 주공종공사예정금액
                @SerializedName("mainCnsttyNm")
                val mainCnsttyNm: String, // 주공종명
                @SerializedName("mainCnsttyPresmptPrce")
                val mainCnsttyPresmptPrce: String, // 주공종추정가격
                @SerializedName("mtltyAdvcPsblYn")
                val mtltyAdvcPsblYn: String, // 상호시장진출허용여부
                @SerializedName("mtltyAdvcPsblYnCnstwkNm")
                val mtltyAdvcPsblYnCnstwkNm: String, // 건설산업법적용대상공사명
                @SerializedName("ntceDscrptYn")
                val ntceDscrptYn: String, // 공고설명여부
                @SerializedName("ntceInsttCd")
                val ntceInsttCd: String, // 공고기관코드
                @SerializedName("ntceInsttNm")
                val ntceInsttNm: String, // 공고기관명
                @SerializedName("ntceInsttOfclEmailAdrs")
                val ntceInsttOfclEmailAdrs: String, // 공고기관담당자이메일주소
                @SerializedName("ntceInsttOfclNm")
                val ntceInsttOfclNm: String, // 공고기관담당자명
                @SerializedName("ntceInsttOfclTelNo")
                val ntceInsttOfclTelNo: String, // 공고기관담당자전화번호
                @SerializedName("ntceKindNm")
                val ntceKindNm: String, // 공고종류명
                @SerializedName("ntceSpecDocUrl1")
                val ntceSpecDocUrl1: String, // 공고규격서URL1
                @SerializedName("ntceSpecDocUrl10")
                val ntceSpecDocUrl10: String, // 공고규격서URL10
                @SerializedName("ntceSpecDocUrl2")
                val ntceSpecDocUrl2: String, // 공고규격서URL2
                @SerializedName("ntceSpecDocUrl3")
                val ntceSpecDocUrl3: String, // 공고규격서URL3
                @SerializedName("ntceSpecDocUrl4")
                val ntceSpecDocUrl4: String, // 공고규격서URL4
                @SerializedName("ntceSpecDocUrl5")
                val ntceSpecDocUrl5: String, // 공고규격서URL5
                @SerializedName("ntceSpecDocUrl6")
                val ntceSpecDocUrl6: String, // 공고규격서URL6
                @SerializedName("ntceSpecDocUrl7")
                val ntceSpecDocUrl7: String, // 공고규격서URL7
                @SerializedName("ntceSpecDocUrl8")
                val ntceSpecDocUrl8: String, // 공고규격서URL8
                @SerializedName("ntceSpecDocUrl9")
                val ntceSpecDocUrl9: String, // 공고규격서URL9
                @SerializedName("ntceSpecFileNm1")
                val ntceSpecFileNm1: String, // 공고규격파일명1
                @SerializedName("ntceSpecFileNm10")
                val ntceSpecFileNm10: String, // 공고규격파일명10
                @SerializedName("ntceSpecFileNm2")
                val ntceSpecFileNm2: String, // 공고규격파일명2
                @SerializedName("ntceSpecFileNm3")
                val ntceSpecFileNm3: String, // 공고규격파일명3
                @SerializedName("ntceSpecFileNm4")
                val ntceSpecFileNm4: String, // 공고규격파일명4
                @SerializedName("ntceSpecFileNm5")
                val ntceSpecFileNm5: String, // 공고규격파일명5
                @SerializedName("ntceSpecFileNm6")
                val ntceSpecFileNm6: String, // 공고규격파일명6
                @SerializedName("ntceSpecFileNm7")
                val ntceSpecFileNm7: String, // 공고규격파일명7
                @SerializedName("ntceSpecFileNm8")
                val ntceSpecFileNm8: String, // 공고규격파일명8
                @SerializedName("ntceSpecFileNm9")
                val ntceSpecFileNm9: String, // 공고규격파일명9
                @SerializedName("opengDt")
                val opengDt: String, // 개찰일시
                @SerializedName("opengPlce")
                val opengPlce: String, // 개찰장소
                @SerializedName("orderPlanUntyNo")
                val orderPlanUntyNo: String, // 발주계획통합번호
                @SerializedName("pqApplDocRcptDt")
                val pqApplDocRcptDt: String, // PQ신청서접수일시
                @SerializedName("pqApplDocRcptMthdNm")
                val pqApplDocRcptMthdNm: String, // PQ신청서접수방법명
                @SerializedName("pqEvalYn")
                val pqEvalYn: String, // PQ심사여부
                @SerializedName("prearngPrceDcsnMthdNm")
                val prearngPrceDcsnMthdNm: String, // 예정가격결정방법명
                @SerializedName("presmptPrce")
                val presmptPrce: String, // 추정가격
                @SerializedName("rbidOpengDt")
                val rbidOpengDt: String, // 재입찰개찰일시
                @SerializedName("rbidPermsnYn")
                val rbidPermsnYn: String, // 재입찰허용여부
                @SerializedName("reNtceYn")
                val reNtceYn: String, // 재공고여부
                @SerializedName("refNo")
                val refNo: String, // 참조번호
                @SerializedName("rgnDutyJntcontrctRt")
                val rgnDutyJntcontrctRt: String, // 지역의무공동도급비율
                @SerializedName("rgnDutyJntcontrctYn")
                val rgnDutyJntcontrctYn: String, // 지역의무공동도급여부
                @SerializedName("rgstDt")
                val rgstDt: String, // 등록일시
                @SerializedName("rgstTyNm")
                val rgstTyNm: String, // 등록유형명
                @SerializedName("rsrvtnPrceReMkngMthdNm")
                val rsrvtnPrceReMkngMthdNm: String, // 예비가격재작성방법명
                @SerializedName("sptDscrptDocUrl1")
                val sptDscrptDocUrl1: String, // 현장설명서URL1
                @SerializedName("sptDscrptDocUrl2")
                val sptDscrptDocUrl2: String, // 현장설명서URL2
                @SerializedName("sptDscrptDocUrl3")
                val sptDscrptDocUrl3: String, // 현장설명서URL3
                @SerializedName("sptDscrptDocUrl4")
                val sptDscrptDocUrl4: String, // 현장설명서URL4
                @SerializedName("sptDscrptDocUrl5")
                val sptDscrptDocUrl5: String, // 현장설명서URL5
                @SerializedName("stdNtceDocUrl")
                val stdNtceDocUrl: String, // 표준공고서URL
                @SerializedName("subsiCnsttyIndstrytyEvlRt1")
                val subsiCnsttyIndstrytyEvlRt1: String, // 부공종업종평가비율1
                @SerializedName("subsiCnsttyIndstrytyEvlRt2")
                val subsiCnsttyIndstrytyEvlRt2: String, // 부공종업종평가비율2
                @SerializedName("subsiCnsttyIndstrytyEvlRt3")
                val subsiCnsttyIndstrytyEvlRt3: String, // 부공종업종평가비율3
                @SerializedName("subsiCnsttyIndstrytyEvlRt4")
                val subsiCnsttyIndstrytyEvlRt4: String, // 부공종업종평가비율4
                @SerializedName("subsiCnsttyIndstrytyEvlRt5")
                val subsiCnsttyIndstrytyEvlRt5: String, // 부공종업종평가비율5
                @SerializedName("subsiCnsttyIndstrytyEvlRt6")
                val subsiCnsttyIndstrytyEvlRt6: String, // 부공종업종평가비율6
                @SerializedName("subsiCnsttyIndstrytyEvlRt7")
                val subsiCnsttyIndstrytyEvlRt7: String, // 부공종업종평가비율7
                @SerializedName("subsiCnsttyIndstrytyEvlRt8")
                val subsiCnsttyIndstrytyEvlRt8: String, // 부공종업종평가비율8
                @SerializedName("subsiCnsttyIndstrytyEvlRt9")
                val subsiCnsttyIndstrytyEvlRt9: String, // 부공종업종평가비율9
                @SerializedName("subsiCnsttyNm1")
                val subsiCnsttyNm1: String, // 부대공종명1
                @SerializedName("subsiCnsttyNm2")
                val subsiCnsttyNm2: String, // 부대공종명2
                @SerializedName("subsiCnsttyNm3")
                val subsiCnsttyNm3: String, // 부대공종명3
                @SerializedName("subsiCnsttyNm4")
                val subsiCnsttyNm4: String, // 부대공종명4
                @SerializedName("subsiCnsttyNm5")
                val subsiCnsttyNm5: String, // 부대공종명5
                @SerializedName("subsiCnsttyNm6")
                val subsiCnsttyNm6: String, // 부대공종명6
                @SerializedName("subsiCnsttyNm7")
                val subsiCnsttyNm7: String, // 부대공종명7
                @SerializedName("subsiCnsttyNm8")
                val subsiCnsttyNm8: String, // 부대공종명8
                @SerializedName("subsiCnsttyNm9")
                val subsiCnsttyNm9: String, // 부대공종명9
                @SerializedName("sucsfbidLwltRate")
                val sucsfbidLwltRate: String, // 낙찰하한율
                @SerializedName("sucsfbidMthdCd")
                val sucsfbidMthdCd: String, // 낙찰방법코드
                @SerializedName("sucsfbidMthdNm")
                val sucsfbidMthdNm: String, // 낙찰방법명
                @SerializedName("totPrdprcNum")
                val totPrdprcNum: String, // 총예가건수
                @SerializedName("untyNtceNo")
                val untyNtceNo: String, // 통합공고번호
                @SerializedName("VAT")
                val vAT: String // 부가가치세
            )
        }

        data class Header(
            @SerializedName("resultCode")
            val resultCode: String, // 결과코드
            @SerializedName("resultMsg")
            val resultMsg: String // 결과메세지
        )
    }
}
