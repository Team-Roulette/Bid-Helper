package com.roulette.bidhelper.models.apis


import com.google.gson.annotations.SerializedName

data class BidServiceSearchDTO(
    @SerializedName("response")
    val response: Response // API 응답 구조를 담는 메인 객체
) {
    data class Response(
        @SerializedName("body")
        val body: Body, // 응답 본문, 실제 사용 데이터 포함
        @SerializedName("header")
        val header: Header // 응답 헤더, 상태 코드 및 메시지 포함
    ) {
        data class Body(
            @SerializedName("items")
            val items: List<Item>, // 입찰 정보 목록을 포함하는 객체
            @SerializedName("numOfRows")
            val numOfRows: String, // 페이지당 항목 수
            @SerializedName("pageNo")
            val pageNo: String, // 현재 페이지 번호
            @SerializedName("totalCount")
            val totalCount: String // 전체 항목 수
        ) {
            data class Item(
                @SerializedName("arsltApplDocRcptMthdNm") val arsltApplDocRcptMthdNm: String, // 실적신청서 접수 방법명
                @SerializedName("arsltCmptYn") val arsltCmptYn: String, // 실적경쟁 여부
                @SerializedName("arsltReqstdocRcptDt") val arsltReqstdocRcptDt: String, // 실적신청서 접수 일시
                @SerializedName("asignBdgtAmt") val asignBdgtAmt: String, // 배정예산금액
                @SerializedName("bfSpecRgstNo") val bfSpecRgstNo: String, // 사전규격등록번호
                @SerializedName("bidBeginDt") val bidBeginDt: String, // 입찰 시작 일시
                @SerializedName("bidClseDt") val bidClseDt: String, // 입찰 마감 일시
                @SerializedName("bidGrntymnyPaymntYn") val bidGrntymnyPaymntYn: String, // 입찰보증금 납부 여부
                @SerializedName("bidMethdNm") val bidMethdNm: String, // 입찰 방식명
                @SerializedName("bidNtceDt") val bidNtceDt: String, // 입찰 공고 일시
                @SerializedName("bidNtceDtlUrl") val bidNtceDtlUrl: String, // 입찰 공고 상세 URL
                @SerializedName("bidNtceNm") val bidNtceNm: String, // 입찰 공고명
                @SerializedName("bidNtceNo") val bidNtceNo: String, // 입찰 공고번호
                @SerializedName("bidNtceOrd") val bidNtceOrd: String, // 입찰 공고차수
                @SerializedName("bidNtceUrl") val bidNtceUrl: String, // 입찰 공고 URL
                @SerializedName("bidPrtcptFee") val bidPrtcptFee: String, // 입찰참가수수료
                @SerializedName("bidPrtcptFeePaymntYn") val bidPrtcptFeePaymntYn: String, // 입찰참가수수료 납부 여부
                @SerializedName("bidPrtcptLmtYn") val bidPrtcptLmtYn: String, // 입찰 참가 제한 여부
                @SerializedName("bidQlfctRgstDt") val bidQlfctRgstDt: String, // 입찰참가자격등록마감일시
                @SerializedName("brffcBidprcPermsnYn") val brffcBidprcPermsnYn: String, // 지사투찰허용여부
                @SerializedName("chgDt") val chgDt: String, // 변경일시
                @SerializedName("chgNtceRsn") val chgNtceRsn: String, // 변경공고사유
                @SerializedName("cmmnSpldmdAgrmntClseDt") val cmmnSpldmdAgrmntClseDt: String, // 공동수급협정마감일시
                @SerializedName("cmmnSpldmdAgrmntRcptdocMethd") val cmmnSpldmdAgrmntRcptdocMethd: String, // 공동수급협정서접수방식
                @SerializedName("cmmnSpldmdCorpRgnLmtYn") val cmmnSpldmdCorpRgnLmtYn: String, // 공동수급업체지역제한여부
                @SerializedName("cmmnSpldmdMethdCd") val cmmnSpldmdMethdCd: String, // 공동수급방식코드
                @SerializedName("cmmnSpldmdMethdNm") val cmmnSpldmdMethdNm: String, // 공동수급방식명
                @SerializedName("cntrctCnclsMthdNm") val cntrctCnclsMthdNm: String, // 계약체결방법명
                @SerializedName("crdtrNm") val crdtrNm: String, // 채권자명
                @SerializedName("d2bMngAssmntLwstlmtRt") val d2bMngAssmntLwstlmtRt: String, // 방사청관리사정하한율
                @SerializedName("d2bMngAssmntUplmtRt") val d2bMngAssmntUplmtRt: String, // 방사청관리사정상한율
                @SerializedName("d2bMngBfEvalClseDt") val d2bMngBfEvalClseDt: String, // 방사청관리사전심사마감일시
                @SerializedName("d2bMngBfEvalObjYn") val d2bMngBfEvalObjYn: String, // 방사청관리사전심사대상여부
                @SerializedName("d2bMngBssamt") val d2bMngBssamt: String, // 방사청관리기초금액
                @SerializedName("d2bMngCnstwkLctNm") val d2bMngCnstwkLctNm: String, // 방사청관리공사위치명
                @SerializedName("d2bMngCnstwkNo") val d2bMngCnstwkNo: String, // 방사청관리공사번호
                @SerializedName("d2bMngCnstwkOutlnCntnts") val d2bMngCnstwkOutlnCntnts: String, // 방사청관리공사개요내용
                @SerializedName("d2bMngCnstwkPrdCntnts") val d2bMngCnstwkPrdCntnts: String, // 방사청관리공사기간내용
                @SerializedName("d2bMngCnstwkScleCntnts") val d2bMngCnstwkScleCntnts: String, // 방사청관리공사규모내용
                @SerializedName("d2bMngCntrctKindNm") val d2bMngCntrctKindNm: String, // 방사청관리계약종류명
                @SerializedName("d2bMngCntrybndDedtBgnDate") val d2bMngCntrybndDedtBgnDate: String, // 방사청관리국채납기시작일자
                @SerializedName("d2bMngCntrybndDedtEndDate") val d2bMngCntrybndDedtEndDate: String, // 방사청관리국채납기종료일자
                @SerializedName("d2bMngCompCorpRsrchObjYn") val d2bMngCompCorpRsrchObjYn: String, // 방사청관리복수업체연구대상여부
                @SerializedName("d2bMngDcsnNo") val d2bMngDcsnNo: String, // 방사청관리판단번호
                @SerializedName("d2bMngDmndYear") val d2bMngDmndYear: String, // 방사청관리요구년도
                @SerializedName("d2bMngExetTyCd") val d2bMngExetTyCd: String, // 방사청관리집행유형코드
                @SerializedName("d2bMngExetTyNm") val d2bMngExetTyNm: String, // 방사청관리집행유형명
                @SerializedName("d2bMngItemNo") val d2bMngItemNo: String, // 방사청관리항목번호
                @SerializedName("d2bMngNgttnPlanDate") val d2bMngNgttnPlanDate: String, // 방사청관리협상계획일자
                @SerializedName("d2bMngNgttnStleNm") val d2bMngNgttnStleNm: String, // 방사청관리협상형태명
                @SerializedName("d2bMngOrgnlbdgtDedtBgnDate") val d2bMngOrgnlbdgtDedtBgnDate: String, // 방사청관리본조납기시작일자
                @SerializedName("d2bMngOrgnlbdgtDedtEndDate") val d2bMngOrgnlbdgtDedtEndDate: String, // 방사청관리본조납기종료일자
                @SerializedName("d2bMngPblctPlceNm") val d2bMngPblctPlceNm: String, // 방사청관리게재장소명
                @SerializedName("d2bMngPrdctnAbltySbmsnClseDt") val d2bMngPrdctnAbltySbmsnClseDt: String, // 방사청관리생산능력제출마감일시
                @SerializedName("d2bMngPrdlstCd") val d2bMngPrdlstCd: String, // 방사청관리품목코드
                @SerializedName("d2bMngPrdlstNm") val d2bMngPrdlstNm: String, // 방사청관리품목명
                @SerializedName("d2bMngProgrsSttusNm") val d2bMngProgrsSttusNm: String, // 방사청관리진행상태명
                @SerializedName("d2bMngRgnLmtYn") val d2bMngRgnLmtYn: String, // 방사청관리지역제한여부
                @SerializedName("d2bMngRgstEvalExmpYn") val d2bMngRgstEvalExmpYn: String, // 방사청관리등록심사면제여부
                @SerializedName("d2bMngRsrvtnPrceBssAplYn") val d2bMngRsrvtnPrceBssAplYn: String, // 방사청관리예비가격기초적용여부
                @SerializedName("d2bMngRsrvtnPrceBssOpenYn") val d2bMngRsrvtnPrceBssOpenYn: String, // 방사청관리예비가격기초공개여부
                @SerializedName("d2bMngStdIndstryClsfcCdList") val d2bMngStdIndstryClsfcCdList: String, // 방사청관리표준산업분류코드목록
                @SerializedName("d2bMngUprcSstmTyNm") val d2bMngUprcSstmTyNm: String, // 방사청관리단가제도유형명
                @SerializedName("dcmtgOprtnDt") val dcmtgOprtnDt: String, // 문서 작성/운영 일자
                @SerializedName("dcmtgOprtnPlce") val dcmtgOprtnPlce: String, // 문서 작성/운영 장소
                @SerializedName("dminsttCd") val dminsttCd: String, // 부처 코드
                @SerializedName("dminsttNm") val dminsttNm: String, // 부처 이름
                @SerializedName("dminsttOfclEmailAdrs") val dminsttOfclEmailAdrs: String, // 부처 공식 이메일 주소
                @SerializedName("drwtPrdprcNum") val drwtPrdprcNum: String, // 추첨참가인원
                @SerializedName("dsgntCmptYn") val dsgntCmptYn: String, // 지정경쟁여부
                @SerializedName("dtlsBidYn") val dtlsBidYn: String, // 상세경매여부
                @SerializedName("exctvNm") val exctvNm: String, // 책임자 이름
                @SerializedName("indstrytyLmtYn") val indstrytyLmtYn: String, // 산업재산권한정여부
                @SerializedName("indutyVAT") val indutyVAT: String, // 산업재산권대상여부
                @SerializedName("infoBizYn") val infoBizYn: String, // 정보기업여부
                @SerializedName("intrbidYn") val intrbidYn: String, // 유찰여부
                @SerializedName("jntcontrctDutyRgnNm1") val jntcontrctDutyRgnNm1: String, // 공동계약권역명1
                @SerializedName("jntcontrctDutyRgnNm2") val jntcontrctDutyRgnNm2: String, // 공동계약권역명2
                @SerializedName("jntcontrctDutyRgnNm3") val jntcontrctDutyRgnNm3: String, // 공동계약권역명3
                @SerializedName("linkInsttNm") val linkInsttNm: String, // 연계기관명
                @SerializedName("mnfctYn") val mnfctYn: String, // 제조업여부
                @SerializedName("ntceDscrptYn") val ntceDscrptYn: String, // 공고서명설명여부
                @SerializedName("ntceInsttCd") val ntceInsttCd: String, // 공고기관코드
                @SerializedName("ntceInsttNm") val ntceInsttNm: String, // 공고기관명
                @SerializedName("ntceInsttOfclEmailAdrs") val ntceInsttOfclEmailAdrs: String, // 공고기관공식이메일주소
                @SerializedName("ntceInsttOfclNm") val ntceInsttOfclNm: String, // 공고기관공식담당자명
                @SerializedName("ntceInsttOfclTelNo") val ntceInsttOfclTelNo: String, // 공고기관공식전화번호
                @SerializedName("ntceKindNm") val ntceKindNm: String, // 공고종류명
                @SerializedName("ntceSpecDocUrl1") val ntceSpecDocUrl1: String, // 공고특정문서URL1
                @SerializedName("ntceSpecDocUrl10") val ntceSpecDocUrl10: String, // 공고특정문서URL10
                @SerializedName("ntceSpecDocUrl2") val ntceSpecDocUrl2: String, // 공고특정문서URL2
                @SerializedName("ntceSpecDocUrl3") val ntceSpecDocUrl3: String, // 공고특정문서URL3
                @SerializedName("ntceSpecDocUrl4") val ntceSpecDocUrl4: String, // 공고특정문서URL4
                @SerializedName("ntceSpecDocUrl5") val ntceSpecDocUrl5: String, // 공고특정문서URL5
                @SerializedName("ntceSpecDocUrl6") val ntceSpecDocUrl6: String, // 공고특정문서URL6
                @SerializedName("ntceSpecDocUrl7") val ntceSpecDocUrl7: String, // 공고특정문서URL7
                @SerializedName("ntceSpecDocUrl8") val ntceSpecDocUrl8: String, // 공고특정문서URL8
                @SerializedName("ntceSpecDocUrl9") val ntceSpecDocUrl9: String, // 공고특정문서URL9
                @SerializedName("ntceSpecFileNm1") val ntceSpecFileNm1: String, // 공고특정문서파일명1
                @SerializedName("ntceSpecFileNm10") val ntceSpecFileNm10: String, // 공고특정문서파일명10
                @SerializedName("ntceSpecFileNm2") val ntceSpecFileNm2: String, // 공고특정문서파일명2
                @SerializedName("ntceSpecFileNm3") val ntceSpecFileNm3: String, // 공고특정문서파일명3
                @SerializedName("ntceSpecFileNm4") val ntceSpecFileNm4: String, // 공고특정문서파일명4
                @SerializedName("ntceSpecFileNm5") val ntceSpecFileNm5: String, // 공고특정문서파일명5
                @SerializedName("ntceSpecFileNm6") val ntceSpecFileNm6: String, // 공고특정문서파일명6
                @SerializedName("ntceSpecFileNm7") val ntceSpecFileNm7: String, // 공고특정문서파일명7
                @SerializedName("ntceSpecFileNm8") val ntceSpecFileNm8: String, // 공고특정문서파일명8
                @SerializedName("ntceSpecFileNm9") val ntceSpecFileNm9: String, // 공고특정문서파일명9
                @SerializedName("opengDt") val opengDt: String, // 개찰일시
                @SerializedName("opengPlce") val opengPlce: String, // 개찰장소
                @SerializedName("orderPlanUntyNo") val orderPlanUntyNo: String, // 발주계획단위번호
                @SerializedName("ppswGnrlSrvceYn") val ppswGnrlSrvceYn: String, // 소재일반용역여부
                @SerializedName("pqApplDocRcptDt") val pqApplDocRcptDt: String, // PQ신청서접수일자
                @SerializedName("pqApplDocRcptMthdNm") val pqApplDocRcptMthdNm: String, // PQ신청서접수방식명
                @SerializedName("pqEvalYn") val pqEvalYn: String, // PQ평가여부
                @SerializedName("prdctClsfcLmtYn") val prdctClsfcLmtYn: String, // 품목분류제한여부
                @SerializedName("prearngPrceDcsnMthdNm") val prearngPrceDcsnMthdNm: String, // 예정가결정방법명
                @SerializedName("presmptPrce") val presmptPrce: String, // 추정가
                @SerializedName("purchsObjPrdctList") val purchsObjPrdctList: String, // 구매대상품목명
                @SerializedName("rbidOpengDt") val rbidOpengDt: String, // 입찰개시일시
                @SerializedName("rbidPermsnYn") val rbidPermsnYn: String, // 입찰허용여부
                @SerializedName("reNtceYn") val reNtceYn: String, // 재공고여부
                @SerializedName("refNo") val refNo: String, // 참조번호
                @SerializedName("rgnDutyJntcontrctRt") val rgnDutyJntcontrctRt: String, // 지역책임공동계약률
                @SerializedName("rgstDt") val rgstDt: String, // 등록일시
                @SerializedName("rgstTyNm") val rgstTyNm: String, // 등록유형명
                @SerializedName("rsrvtnPrceReMkngMthdNm") val rsrvtnPrceReMkngMthdNm: String, // 예비가재결정방법명
                @SerializedName("srvceDivNm") val srvceDivNm: String, // 서비스구분명
                @SerializedName("stdNtceDocUrl") val stdNtceDocUrl: String, // 표준공고문URL
                @SerializedName("sucsfbidLwltRate") val sucsfbidLwltRate: String, // 낙찰최저율
                @SerializedName("sucsfbidMthdCd") val sucsfbidMthdCd: String, // 낙찰방식코드
                @SerializedName("sucsfbidMthdNm") val sucsfbidMthdNm: String, // 낙찰방식명
                @SerializedName("totPrdprcNum") val totPrdprcNum: String, // 총추첨인원
                @SerializedName("tpEvalApplClseDt") val tpEvalApplClseDt: String, // 기술평가신청마감일시
                @SerializedName("tpEvalApplMthdNm") val tpEvalApplMthdNm: String, // 기술평가신청방법명
                @SerializedName("tpEvalYn") val tpEvalYn: String, // 기술평가여부
                @SerializedName("untyNtceNo") val untyNtceNo: String, // 단위공고번호
                @SerializedName("VAT") val vAT: String // 부가가치세
            )
        }

        data class Header(
            @SerializedName("resultCode") val resultCode: String, // 결과 코드 (예: "00"은 정상)
            @SerializedName("resultMsg") val resultMsg: String // 결과 메시지 (예: "정상 처리되었습니다.")
        )
    }
}