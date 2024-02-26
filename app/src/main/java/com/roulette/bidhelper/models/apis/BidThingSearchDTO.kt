package com.roulette.bidhelper.models.apis

import com.google.gson.annotations.SerializedName

// 나라장터검색조건에 의한 입찰공고물품조회
data class BidThingSearchDTO(
    @SerializedName("response") val response: Response // API 응답 본체
) {
    data class Response(
        @SerializedName("body") val body: Body, // 응답 본문
        @SerializedName("header") val header: Header // 응답 헤더
    ) {
        data class Body(
            @SerializedName("items") val items: List<Item>, // 입찰 항목 리스트
            @SerializedName("numOfRows") val numOfRows: String, // 페이지당 표시되는 항목 수
            @SerializedName("pageNo") val pageNo: String, // 현재 페이지 번호
            @SerializedName("totalCount") val totalCount: String // 총 항목 수
        ) {
            data class Item(
                @SerializedName("bidNtceNo") val bidNtceNo: String, // 입찰공고번호
                @SerializedName("bidNtceNm") val bidNtceNm: String, // 입찰공고명
                @SerializedName("ntceInsttCd") val ntceInsttCd: String, // 공고기관코드
                @SerializedName("dminsttNm") val dminsttNm: String, // 수요기관명
                @SerializedName("bidMethdNm") val bidMethdNm: String, // 입찰방식명
                @SerializedName("opengDt") val opengDt: String, // 개찰일시
                @SerializedName("bidBeginDt") val bidBeginDt: String, // 입찰개시일시
                @SerializedName("bidClseDt") val bidClseDt: String, // 입찰마감일시
                @SerializedName("arsltApplDocRcptDt") val arsltApplDocRcptDt: String, // 실적신청서 접수일시
                @SerializedName("arsltApplDocRcptMthdNm") val arsltApplDocRcptMthdNm: String, // 실적신청서접수방법명
                @SerializedName("asignBdgtAmt") val asignBdgtAmt: String, // 배정예산금액
                @SerializedName("bfSpecRgstNo") val bfSpecRgstNo: String, // 사전규격등록번호
                @SerializedName("bidGrntymnyPaymntYn") val bidGrntymnyPaymntYn: String, // 입찰보증금납부여부
                @SerializedName("bidNtceDt") val bidNtceDt: String, // 입찰공고일시
                @SerializedName("bidNtceDtlUrl") val bidNtceDtlUrl: String, // 입찰공고상세URL
                @SerializedName("bidNtceUrl") val bidNtceUrl: String, // 입찰공고URL
                @SerializedName("bidPrtcptFee") val bidPrtcptFee: String, // 입찰참가수수료
                @SerializedName("bidPrtcptFeePaymntYn") val bidPrtcptFeePaymntYn: String, // 입찰참가수수료납부여부
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
                @SerializedName("d2bMngBssamt") val d2bMngBssamt: String, // 방사청관리기초금액
                @SerializedName("d2bMngCntrctKindNm") val d2bMngCntrctKindNm: String, // 방사청관리계약종류명
                @SerializedName("d2bMngCntrybndDedtBgnDate") val d2bMngCntrybndDedtBgnDate: String, // 방사청관리국채납기시작일자
                @SerializedName("d2bMngCntrybndDedtEndDate") val d2bMngCntrybndDedtEndDate: String, // 방사청관리국채납기종료일자
                @SerializedName("d2bMngCompCorpRsrchObjYn") val d2bMngCompCorpRsrchObjYn: String, // 방사청관리복수업체연구대상여부
                @SerializedName("d2bMngDcmtgOprtnDt") val d2bMngDcmtgOprtnDt: String, // 방사청관리설명회실시일시
                @SerializedName("d2bMngDcmtgOprtnPlce") val d2bMngDcmtgOprtnPlce: String, // 방사청관리설명회실시장소
                @SerializedName("d2bMngDcsnNo") val d2bMngDcsnNo: String, // 방사청관리판단번호
                @SerializedName("d2bMngDmndYear") val d2bMngDmndYear: String, // 방사청관리요구년도
                @SerializedName("d2bMngExetTyCd") val d2bMngExetTyCd: String, // 방사청관리집행유형코드
                @SerializedName("d2bMngExetTyNm") val d2bMngExetTyNm: String, // 방사청관리집행유형명
                @SerializedName("d2bMngItemNo") val d2bMngItemNo: String, // 방사청관리항목번호
                @SerializedName("d2bMngNgttnPlanDate") val d2bMngNgttnPlanDate: String, // 방사청관리협상계획일자
                @SerializedName("d2bMngNgttnStleNm") val d2bMngNgttnStleNm: String, // 방사청관리협상형태명
                @SerializedName("d2bMngOrgnlbdgtDedtBgnDate") val d2bMngOrgnlbdgtDedtBgnDate: String, // 방사청관리본조납기시작일자
                @SerializedName("d2bMngOrgnlbdgtDedtEndDate") val d2bMngOrgnlbdgtDedtEndDate: String, // 방사청관리본조납기종료일자
                @SerializedName("d2bMngPrdctnAbltySbmsnClseDt") val d2bMngPrdctnAbltySbmsnClseDt: String, // 방사청관리생산능력제출마감일시
                @SerializedName("d2bMngPrdlstCd") val d2bMngPrdlstCd: String, // 방사청관리품목코드
                @SerializedName("d2bMngProgrsSttusNm") val d2bMngProgrsSttusNm: String, // 방사청관리진행상태명
                @SerializedName("d2bMngRgnLmtYn") val d2bMngRgnLmtYn: String, // 방사청관리지역제한여부
                @SerializedName("d2bMngRgstEvalExmpYn") val d2bMngRgstEvalExmpYn: String, // 방사청관리등록심사면제여부
                @SerializedName("d2bMngRrsrvtnPrceBssAplYn") val d2bMngRrsrvtnPrceBssAplYn: String, // 방사청관리예비가격기초적용여부
                @SerializedName("d2bMngRsrvtnPrceBssOpenYn") val d2bMngRsrvtnPrceBssOpenYn: String, // 방사청관리예비가격기초공개여부
                @SerializedName("d2bMngStdIndstryClsfcCdList") val d2bMngStdIndstryClsfcCdList: String, // 방사청관리표준산업분류코드목록
                @SerializedName("dlvrDaynum") val dlvrDaynum: String, // 납품일수
                @SerializedName("dlvrTmlmtDt") val dlvrTmlmtDt: String, // 납품기한일시
                @SerializedName("dlvryCndtnNm") val dlvryCndtnNm: String, // 인도조건명
                @SerializedName("dminsttCd") val dminsttCd: String, // 수요기관코드
                @SerializedName("dminsttOfclEmailAdrs") val dminsttOfclEmailAdrs: String, // 수요기관담당자이메일주소
                @SerializedName("drwtPrdprcNum") val drwtPrdprcNum: String, // 추첨예가건수
                @SerializedName("dsgntCmptYn") val dsgntCmptYn: String, // 지명경쟁여부
                @SerializedName("dtilPrdctClsfcNo") val dtilPrdctClsfcNo: String, // 세부품명번호
                @SerializedName("dtilPrdctClsfcNoNm") val dtilPrdctClsfcNoNm: String, // 세부품명
                @SerializedName("exctvNm") val exctvNm: String, // 집행관명
                @SerializedName("indstrytyLmtYn") val indstrytyLmtYn: String, // 업종제한여부
                @SerializedName("infoBizYn") val infoBizYn: String, // 정보화사업여부
                @SerializedName("intrbidYn") val intrbidYn: String, // 국제입찰여부
                @SerializedName("linkInsttNm") val linkInsttNm: String, // 연계기관명
                @SerializedName("mnfctYn") val mnfctYn: String, // 제조여부
                @SerializedName("ntceInsttNm") val ntceInsttNm: String, // 공고기관명
                @SerializedName("ntceInsttOfclEmailAdrs") val ntceInsttOfclEmailAdrs: String, // 공고기관담당자이메일주소
                @SerializedName("ntceInsttOfclNm") val ntceInsttOfclNm: String, // 공고기관담당자명
                @SerializedName("ntceInsttOfclTelNo") val ntceInsttOfclTelNo: String, // 공고기관담당자전화번호
                @SerializedName("ntceKindNm") val ntceKindNm: String, // 공고종류명
                @SerializedName("ntceSpecDocUrl1") val ntceSpecDocUrl1: String, // 공고규격서URL1
                @SerializedName("ntceSpecDocUrl10") val ntceSpecDocUrl10: String, // 공고규격서URL10
                @SerializedName("ntceSpecDocUrl2") val ntceSpecDocUrl2: String, // 공고규격서URL2
                @SerializedName("ntceSpecDocUrl3") val ntceSpecDocUrl3: String, // 공고규격서URL3
                @SerializedName("ntceSpecDocUrl4") val ntceSpecDocUrl4: String, // 공고규격서URL4
                @SerializedName("ntceSpecDocUrl5") val ntceSpecDocUrl5: String, // 공고규격서URL5
                @SerializedName("ntceSpecDocUrl6") val ntceSpecDocUrl6: String, // 공고규격서URL6
                @SerializedName("ntceSpecDocUrl7") val ntceSpecDocUrl7: String, // 공고규격서URL7
                @SerializedName("ntceSpecDocUrl8") val ntceSpecDocUrl8: String, // 공고규격서URL8
                @SerializedName("ntceSpecDocUrl9") val ntceSpecDocUrl9: String, // 공고규격서URL9
                @SerializedName("ntceSpecFileNm1") val ntceSpecFileNm1: String, // 공고규격파일명1
                @SerializedName("ntceSpecFileNm10") val ntceSpecFileNm10: String, // 공고규격파일명10
                @SerializedName("ntceSpecFileNm2") val ntceSpecFileNm2: String, // 공고규격파일명2
                @SerializedName("ntceSpecFileNm3") val ntceSpecFileNm3: String, // 공고규격파일명3
                @SerializedName("ntceSpecFileNm4") val ntceSpecFileNm4: String, // 공고규격파일명4
                @SerializedName("ntceSpecFileNm5") val ntceSpecFileNm5: String, // 공고규격파일명5
                @SerializedName("ntceSpecFileNm6") val ntceSpecFileNm6: String, // 공고규격파일명6
                @SerializedName("ntceSpecFileNm7") val ntceSpecFileNm7: String, // 공고규격파일명7
                @SerializedName("ntceSpecFileNm8") val ntceSpecFileNm8: String, // 공고규격파일명8
                @SerializedName("ntceSpecFileNm9") val ntceSpecFileNm9: String, // 공고규격파일명9
                @SerializedName("opengPlce") val opengPlce: String, // 개찰장소
                @SerializedName("orderPlanUntyNo") val orderPlanUntyNo: String, // 발주계획통합번호
                @SerializedName("prdctClsfcLmtYn") val prdctClsfcLmtYn: String, // 물품분류제한여부
                @SerializedName("prdctQty") val prdctQty: String, // 물품수량
                @SerializedName("prdctSpecNm") val prdctSpecNm: String, // 물품규격명
                @SerializedName("prdctUnit") val prdctUnit: String, // 물품단위
                @SerializedName("prdctUprc") val prdctUprc: String, // 물품단가
                @SerializedName("prearngPrceDcsnMthdNm") val prearngPrceDcsnMthdNm: String, // 예정가격결정방법명
                @SerializedName("presmptPrce") val presmptPrce: String, // 추정가격
                @SerializedName("purchsObjPrdctList") val purchsObjPrdctList: String, // 구매대상물품목록
                @SerializedName("rbidOpengDt") val rbidOpengDt: String, // 재입찰개찰일시
                @SerializedName("rbidPermsnYn") val rbidPermsnYn: String, // 재입찰허용여부
                @SerializedName("reNtceYn") val reNtceYn: String, // 재공고여부
                @SerializedName("refNo") val refNo: String, // 참조번호
                @SerializedName("rgstDt") val rgstDt: String, // 등록일시
                @SerializedName("rgstTyNm") val rgstTyNm: String, // 등록유형명
                @SerializedName("rsrvtnPrceReMkngMthdNm") val rsrvtnPrceReMkngMthdNm: String, // 예비가격재작성방법명
                @SerializedName("stdNtceDocUrl") val stdNtceDocUrl: String, // 표준공고서URL
                @SerializedName("sucsfbidLwltRate") val sucsfbidLwltRate: String, // 낙찰하한율
                @SerializedName("sucsfbidMthdCd") val sucsfbidMthdCd: String, // 낙찰방법코드
                @SerializedName("sucsfbidMthdNm") val sucsfbidMthdNm: String, // 낙찰방법명
                @SerializedName("totPrdprcNum") val totPrdprcNum: String, // 총예가건수
                @SerializedName("untyNtceNo") val untyNtceNo: String, // 통합공고번호
                @SerializedName("VAT") val vAT: String, // 부가가치세
                @SerializedName("indutyVAT") val indutyVAT: String // 주공종부가가치세
            )
        }

        data class Header(
            @SerializedName("resultCode") val resultCode: String, // 결과코드 ("00"은 정상)
            @SerializedName("resultMsg") val resultMsg: String // 결과메시지 ("정상"은 성공적인 응답)
        )
    }
}
