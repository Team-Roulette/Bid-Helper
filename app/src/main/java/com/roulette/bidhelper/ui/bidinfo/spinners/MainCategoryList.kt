package com.roulette.bidhelper.ui.bidinfo.spinners

val placeCategoryList = listOf(
    "지역제한선택", "서울", "부산", "인천", "대구", "광주", "대전", "울산", "세종",
    "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "전국(지역제한없음)"
)


/**
 * 업종구분 -> mainCategory
 * 1차구분 -> firstCategory
 * 2차구분 -> secondCategory
 *
 * 공사의 1차구분: firstCategoryList_1
 * 구매의 1차구분: firstCategoryList_2
 *
 * 공사의 일반건설공사의 2차구분: secondCategoryList_1_1
 */

val mainCategoryList = listOf(
    "업종구분", "공사", "구매", "용역"
)

val firstCategoryList_1 = listOf(
    "==공사 전체==",
    "일반건설공사",
    "전문건설공사",
    "전문건설공사(대업종)",
    "전기/통신/산림/환경/기타공사"
)

val firstCategoryList_2 = listOf(
    "==구매 전체==",
    "가구.사무용가구.교구/주방관련",
    "건설/시설자재",
    "조경관련",
    "기계장비/산업기계/농축산기계",
    "전기(UPS,자동제어),조명",
    "전동기/회전기기/축전지",
    "전자.통신.방송기기.신호등.소방안전.탐지(CCTV)",
    "군수품관련",
    "학교관련기타구매",
    "식음료/농.축.해산물(급식,부식)/건강보조",
    "운송기기/하역기계",
    "의료기기/의약품",
    "운동/레저/악기",
    "의류/섬유",
    "연료관련/원자재",
    "수처리.오염.환경/청소장비",
    "플라스틱/합성수지",
    "영상장비,사진/졸업앨범",
    "도서출판인쇄(안내.표지판)",
    "컴퓨터/사무기관련",
    "가전제품/냉난방.공조기.에어컨",
    "실험/계측기기/시험기",
    "동식물",
    "장의/커튼/상패/잡화",
    "기타"
)

val firstCategoryList_3 = listOf(
    "==용역 전체==",
    "엔지니어링",
    "감리관련",
    "설계관련",
    "안전진단",
    "광고/홍보/간판",
    "위탁(식당/어린이집/자판기/검침)등",
    "위생(청소/소독/물탱크/세탁/병원페기물)",
    "관리업",
    "신재생에너지",
    "측량/사진/드론",
    "연구.학술.경영.컨설팅.특허/리서치.조사",
    "폐기물",
    "컴퓨터통신",
    "문화재관련(수리/지표조사)",
    "보험",
    "리스/임대/대여",
    "은행/의료/장의(무연고.행려등)",
    "오수/분뇨/폐수",
    "수로조사",
    "운송/해운/여행/우편/택배",
    "기술사사무소",
    "민간투자",
    "어장정화",
    "환경평가",
    "전문자격(세무.회계.법무)",
    "전시/행사/이벤트/부스",
    "산업디자인(조각,조형물포함)",
    "비파괴검사",
    "알뜰시장",
    "재활용",
    "파견/대행/번역/교육/ISO",
    "보안,경비,무인경비",
    "전기안전/CCTV조사",
    "골재재취업",
    "석면조사",
    "건설/산림기술용역업",
    "기타용역"
)

val secondCategoryList_1_1 = listOf(
    "==일반건설공사 전체==",
    "토목공사",
    "토목건축공사",
    "건축공사",
    "조경고상",
    "산업.환경설비공사"
)

val secondCategoryList_1_2 = listOf(
    "==전문건설공사 전체==",
    "실내건축",
    "토공공사",
    "습식.방수공사업(미장방수조적)",
    "석공공사",
    "도장공사",
    "비계구조물해체",
    "석면해체,제거업",
    "금속구조물창호온실",
    "지붕판금건축물조립",
    "철근콘크리트공사",
    "상하수도공사",
    "보링그라우팅공사",
    "철도궤도공사",
    "포장공사",
    "수중공사",
    "조경식재공사",
    "조경시설물설치공사",
    "강구조물공사",
    "승강기설치",
    "철강재설치공사",
    "삭도설치.준설공사",
    "시설물유지관리",
    "기계설비공사업",
    "지하수개발업",
    "난방공사",
    "가스시설공사",
    "특정열사용기자재시공업",
    "정비사업(재건축,재개발,재정비등)",
    "문화재공사",
    "자연휴양림",
    "광해방지사업(토양개량.복원.정화)"
)

val secondCategoryList_1_3 = listOf(
    "==전문건설공사(대업종) 전체==",
    "(대)철강구조물공사업",
    "(대)수중,준설공사업",
    "(대)승강기,삭도공사업",
    "(대)기계가스설비공사업",
    "(대)가스난방공사업",
    "(대)지반조성.포장공사업",
    "(대)실내건축공사업",
    "(대)금속창호,지붕건출물조립소강업",
    "(대)도장,습식,방수,석공사업",
    "(대)조경식재,시설물공사업",
    "(대)철근,콘크리트공사업",
    "(대)구조물해체.비계공사업",
    "(대)상,하수도설비공사업",
    "(대)철도,궤도공사업"
)

val secondCategoryList_1_4 = listOf(
    "==전기/통신/산림/환경/기타공사 전체==",
    "전기공사",
    "정보통신공사",
    "일반소방시설(기계)",
    "일반소방시설(전기)",
    "전문소방시설공사",
    "대기/수질방지시설업(소음.진동방지)",
    "신재생에너지(전체)",
    "오수처리시설등설계.시공업",
    "산림사업법인(구)",
    "산립사업법인(도시림조성)",
    "산림조합",
    "산림사업법인(숲가꾸기/병해충)",
    "산림사업법인(나무병원)",
    "산림사업법인(산림토목/숲길)",
    "골재재취업(육상골재)",
    "기상장비업",
    "강선건조업,선박수리",
    "기타공사"
)

val secondCategoryList_2_1 = listOf(
    "==가구.사무용가구.교구/주방관련 전체==",
    "가구관련제품",
    "주방관련제품"
)

val secondCategoryList_2_2 = listOf(
    "==건설/시설자재 전체==",
    "건설자재",
    "시설자재"
)

val secondCategoryList_2_3 = listOf(
    "==조경관련 전체==",
    "농약.비료.약재류",
    "상토.조경석/조경자재",
    "종자.묘목.잔디류,화훼,수목"
)

val secondCategoryList_2_4 = listOf(
    "==기계장비.산업기계.농축산기계 전체==",
    "중장비,건설기계",
    "농축산기계",
    "작업공구",
    "기계장비.유체조절기기",
    "산업기계",
    "산업용냉동.냉장기기"
)

val secondCategoryList_2_5 = listOf(
    "==전기(UPS,자동제어)/조명 전체==",
    "전기,전선,전기,무정전,UPS,자동제어 관련자재",
    "조명",
    "배전반,변압기",
    "전기자재기타"
)

val secondCategoryList_2_6 = listOf(
    "==전동기/회전기기/축전지 전체==",
    "엔진.전동기",
    "전지.발전기.동력전달.축전지",
    "모터,펌프",
    "기타 회전기기.경전기"
)

val secondCategoryList_2_7 = listOf(
    "==전자.통신.방송기기.신호등.소방안전.탐지(CCTV) 전체==",
    "신호등 관련",
    "보안.감시.탐지장비(CCTV)",
    "전자.통신.방송기기",
    "소방,안전관련(소화기등)"
)

val secondCategoryList_2_8 = listOf(
    "==군수품관련 전체==",
    "군수품"
)

val secondCategoryList_2_9 = listOf(
    "==학교관련기타구매 전체==",
    "학교지명구매"
)

val secondCategoryList_2_10 = listOf(
    "==식음료/농.축.해산물(급식,부식)/건강보조 전체==",
    "건강보조.약용식품",
    "급식.부식(농축해산물)",
    "식음료"
)

val secondCategoryList_2_11 = listOf(
    "==운송기기/하역기계 전체==",
    "운송기기관련",
    "전동차,철도관련",
    "항공,해양조선관련",
    "하역기계.장비,승강기,콘베이어"
)

val secondCategoryList_2_12 = listOf(
    "==의료기기/의약품 전체==",
    "의료기기",
    "의약품",
    "기타약품관련"
)

val secondCategoryList_2_13 = listOf(
    "==운동/레저/악기 전체==",
    "운동관련제품",
    "레저관련제품",
    "악기,장난감,교육관련교구,장식품"
)

val secondCategoryList_2_14 = listOf(
    "==의류/섬유 전체==",
    "의류,가방",
    "섬유관련(수건,타올포함)"
)

val secondCategoryList_2_15 = listOf(
    "==연료관련/원자재 전체==",
    "연료",
    "가스연료첨가제,윤활제.그리스및방부",
    "화학제품",
    "원자재"
)

val secondCategoryList_2_16 = listOf(
    "==수처리.오염.환경/청소장비 전체==",
    "수처리오염방지환경구매",
    "청소장비.소모품"
)

val secondCategoryList_2_17 = listOf(
    "==플라스틱/합성수지 전체==",
    "고무 및 플라스틱",
    "합성수지",
    "실물모형",
    "기타 플라스틱 및 고무"
)

val secondCategoryList_2_18 = listOf(
    "==영상장비,사진/졸업앨범 전체==",
    "사진,영상장비",
    "졸업앨범"
)

val secondCategoryList_2_19 = listOf(
    "==도서출판인쇄(안내.표지판) 전체==",
    "인쇄,출판,판촉물(안내.표지판)",
    "도서,비도서구입",
    "상품권"
)

val secondCategoryList_2_20 = listOf(
    "==컴퓨터/사무기관련 전체==",
    "컴퓨터 소모품 설비",
    "사무용 기기 및 보조용품"
)

val secondCategoryList_2_21 = listOf(
    "==가전제품/냉난방.공조기.에어컨==",
    "가전기기 및 전자제품",
    "냉난방기.공조기.에어컨",
)

val secondCategoryList_2_22 = listOf(
    "==실험/계측기기/시험기 전체==",
    "실험실습기자재.계측기.시험기"
)

val secondCategoryList_2_23 = listOf(
    "==동식물 전체==",
    "동식물,어류,사료"
)

val secondCategoryList_2_24 = listOf(
    "==장의/커튼/상패/잡화 전체==",
    "시계,보석,악세서리,잡화관련",
    "장의용품",
    "커튼 및 차양,블라인드",
    "상패,기념패"
)

val secondCategoryList_2_25 = listOf(
    "==기타 전체==",
    "기타 구매입찰"
)

val secondCategoryList_3_1 = listOf(
    "==엔지니어링 전체==",
    "기계,설비 ENG.",
    "전자.정보 ENG.",
    "건설 ENG.",
    "전기 ENG.",
    "환경 ENG.",
    "원자력/방사선/비파괴 ENG.",
    "농림/해양/수산 ENG.",
    "기타 ENG."
)
val secondCategoryList_3_2 = listOf(
    "==감리관련 전체==",
    "종합감리용역",
    "토목감리용역",
    "건축감리용역",
    "기계설비감리용역",
    "전력감리업",
    "일반소방감리",
    "전문소방공사감리",
    "정보시스템감리",
    "석면해체감리",
    "기타감리업"
)

val secondCategoryList_3_3 = listOf(
    "==설계관련 전체==",
    "건축관련설계",
    "설계업(전력)",
    "전문소방시설설계",
    "일반소방설계(기계)",
    "일반소방설계(전기)",
    "종합설계용역",

    )
val secondCategoryList_3_4 = listOf(
    "==안전진단 전체==",
    "안전진단(교량및터널/항만/건축)",
    "안전진단(수리시설/전기/무대시설)"
)

val secondCategoryList_3_5 = listOf(
    "==광고/홍보/간판==",
    "옥외광고업(안내.표지판.간판등)",
    "영상(홍보)물, 동영상제작",
    "광고.홍보.디자인.광고대행"
)

val secondCategoryList_3_6 = listOf(
    "==위탁(식당/어린이집/자판기/검침)등 전체==",
    "위탁용역(어린이집.교육시설/복지후생등)",
    "식탁위탁용역",
    "자판기관리",
    "기타관리위탁(검핌.기타유지운영관리등"
)

val secondCategoryList_3_7 = listOf(
    "==위생(청소/소독/물탱크/세탁/병원폐기물) 전체==",
    "소독",
    "세탁물처리, 병원폐기물처리",
    "위생관리용역업",
    "물탱크청소, 기타위생청소"
)
val secondCategoryList_3_8 = listOf(
    "==관리업 전체==",
    "안전관련관리업/항공선박관리.정비업",
    "소방시설관리업",
    "주택관리업",
    "건물(시설)관리",
    "자동차관리.정비업.세차",
    "주차장관리",
    "조림/영림/수목 관리",
    "승강깅지보수정비",
    "기타유지보수정비"
)

val secondCategoryList_3_9 = listOf(
    "==신재생에너지 전체==",
    "신재생에너지전문기업",
    "에너지절약전문기업(esco)",
)
val secondCategoryList_3_10 = listOf(
    "==측량/사진/드론 전체==",
    "측지측량업",
    "공공측량업",
    "항공사진관련업",
    "지도관련,해도제작",
    "지하시설물측량업",
    "해양조사정보업(수로사업)",
    "초경량비행장치사용사업(드론)",
)
val secondCategoryList_3_11 = listOf(
    "==연구.학술.경영.컨설팅.특허/리서치.조사 전체==",
    "학술.연구.경영.컨설팅.특허",
    "원가계산용역",
    "리서치/조사/모집"
)

val secondCategoryList_3_12 = listOf(
    "==폐기물 전체==",
    "폐기물수집.운반",
    "폐기물처리업",
    "폐기물종합처리업",
    "폐기물해양수거업"
)
val secondCategoryList_3_13 = listOf(
    "==컴퓨터통신 전체==",
    "소프트웨어사업자/SI",
    "컴퓨터및주변기기유지보수",
    "정보보호",
    "기타정보통신관련"
)
val secondCategoryList_3_14 = listOf(
    "==문화재관련(수리/지표조사) 전체==",
    "문화재수리업",
    "문화재지표조사"
)
val secondCategoryList_3_15 = listOf(
    "==보험 전체==",
    "보험"
)
val secondCategoryList_3_16 = listOf(
    "==리스/임대/대여 전체==",
    "리스.임대.대여",
    "기계대여업"
)
val secondCategoryList_3_17 = listOf(
    "==은행/의료/장의(무연고,행려등) 전체==",
    "은행관련",
    "의료관련",
    "장의관련(분묘이장.무연고.행령 등",
    "기타 서비스"
)
val secondCategoryList_3_18 = listOf(
    "==오수/분뇨/폐수 전체==",
    "==오수/분뇨/폐수 용역",
)

val secondCategoryList_3_19 = listOf(
    "==수로조사 전체==",
    "수로조사업"
)

val secondCategoryList_3_20 = listOf(
    "==운송/해운/여행/우편/택배 전체==",
    "화물,해운,특수운송",
    "수학.국내여행,해외여행",
    "숙박업,택배업",
    "우편발송대행",
    "여객자동차운송(전세/출퇴근버스)"
)

val secondCategoryList_3_21 = listOf(
    "==기술사사무소 전체==",
    "기술사사무소"
)

val secondCategoryList_3_22 = listOf(
    "==민간투자 전체==",
    "민간투자사업(BTL/SOC)"
)

val secondCategoryList_3_23 = listOf(
    "==어장정화 전체==",
    "어장정화.정비업"
)

val secondCategoryList_3_24 = listOf(
    "==환경평가 전체==",
    "환경평가/인구영향평가/지하수영향평가",
    "대기대행업",
    "개인정보영향평가기관",
    "작업환경측정평가"
)

val secondCategoryList_3_25 = listOf(
    "==전문자격(세무.회계.법무) 전체==",
    "세무사/회계사/법무사전문자격"
)

val secondCategoryList_3_26 = listOf(
    "==전시/행사/이벤트/부스 전체==",
    "전시.행사.이벤트.부스"
)

val secondCategoryList_3_27 = listOf(
    "==산업디자인(조각,조형물포함) 전체==",
    "산업디자인용역(조각,조형물포함)"
)

val secondCategoryList_3_28 = listOf(
    "==비파괴검사 전체==",
    "비파괴검사업"
)

val secondCategoryList_3_29 = listOf(
    "==알뜰시장 전체==",
    "알뜰시장"
)

val secondCategoryList_3_30 = listOf(
    "==재활용 전체==",
    "재활용"
)

val secondCategoryList_3_31 = listOf(
    "==파견/대행/번역/교육/ISO 전체==",
    "근로자파견/업무대행",
    "번역/교육/ISO인증",
    "행정대집행사업"
)

val secondCategoryList_3_32 = listOf(
    "==보안,경비,무인경비 전체==",
    "보안.경비.무인/기계경비"
)

val secondCategoryList_3_33 = listOf(
    "==전기안전/CCTV조사 전체==",
    "전기안전관리업",
    "CCTV조사"
)

val secondCategoryList_3_34 = listOf(
    "==골재채취업 전체==",
    "골재채취업"
)

val secondCategoryList_3_35 = listOf(
    "==석면조사 전체==",
    "석면조사업"
)

val secondCategoryList_3_36 = listOf(
    "==건설/산림기술용억업 전체==",
    "건설기술용역(종합)",
    "건설기술용역(설계사업관리)",
    "건설기술용역(품질검사)",
    "건설기술용역(산림경영계획)"
)

val secondCategoryList_3_37 = listOf(
    "==기타용역 전체==",
    "기타용역"
)

val categoryMap = mapOf(
    "공사" to firstCategoryList_1,
    "구매" to firstCategoryList_2,
    "용역" to firstCategoryList_3,
    "일반건설공사" to secondCategoryList_1_1,
    "전문건설공사" to secondCategoryList_1_2,
    "전문건설공사(대업종)" to secondCategoryList_1_3,
    "전기/통신/산림/환경/기타공사" to secondCategoryList_1_4,
    "가구.사무용가구.교구/주방관련" to secondCategoryList_2_1,
    "건설/시설자재" to secondCategoryList_2_2,
    "조경관련" to secondCategoryList_2_3,
    "기계장비/산업기계/농축산기계" to secondCategoryList_2_4,
    "전기(UPS,자동제어),조명" to secondCategoryList_2_5,
    "전동기/회전기기/축전지" to secondCategoryList_2_6,
    "전자.통신.방송기기.신호등.소방안전.탐지(CCTV)" to secondCategoryList_2_7,
    "군수품관련" to secondCategoryList_2_8,
    "학교관련기타구매" to secondCategoryList_2_9,
    "식음료/농.축.해산물(급식,부식)/건강보조" to secondCategoryList_2_10,
    "운송기기/하역기계" to secondCategoryList_2_11,
    "의료기기/의약품" to secondCategoryList_2_12,
    "운동/레저/악기" to secondCategoryList_2_13,
    "의류/섬유" to secondCategoryList_2_14,
    "연료관련/원자재" to secondCategoryList_2_15,
    "수처리.오염.환경/청소장비" to secondCategoryList_2_16,
    "플라스틱/합성수지" to secondCategoryList_2_17,
    "영상장비,사진/졸업앨범" to secondCategoryList_2_18,
    "도서출판인쇄(안내.표지판)" to secondCategoryList_2_19,
    "컴퓨터/사무기관련" to secondCategoryList_2_20,
    "가전제품/냉난방.공조기.에어컨" to secondCategoryList_2_21,
    "실험/계측기기/시험기" to secondCategoryList_2_22,
    "동식물" to secondCategoryList_2_23,
    "장의/커튼/상패/잡화" to secondCategoryList_2_24,
    "기타" to secondCategoryList_2_25,
    "엔지니어링" to secondCategoryList_3_1,
    "감리관련" to secondCategoryList_3_2,
    "설계관련" to secondCategoryList_3_3,
    "안전진단" to secondCategoryList_3_4,
    "광고/홍보/간판" to secondCategoryList_3_5,
    "위탁(식당/어린이집/자판기/검침)등" to secondCategoryList_3_6,
    "위생(청소/소독/물탱크/세탁/병원페기물)" to secondCategoryList_3_7,
    "관리업" to secondCategoryList_3_8,
    "신재생에너지" to secondCategoryList_3_9,
    "측량/사진/드론" to secondCategoryList_3_10,
    "연구.학술.경영.컨설팅.특허/리서치.조사" to secondCategoryList_3_11,
    "폐기물" to secondCategoryList_3_12,
    "컴퓨터통신" to secondCategoryList_3_13,
    "문화재관련(수리/지표조사)" to secondCategoryList_3_14,
    "보험" to secondCategoryList_3_15,
    "리스/임대/대여" to secondCategoryList_3_16,
    "은행/의료/장의(무연고.행려등)" to secondCategoryList_3_17,
    "오수/분뇨/폐수" to secondCategoryList_3_18,
    "수로조사" to secondCategoryList_3_19,
    "운송/해운/여행/우편/택배" to secondCategoryList_3_20,
    "기술사사무소" to secondCategoryList_3_21,
    "민간투자" to secondCategoryList_3_22,
    "어장정화" to secondCategoryList_3_23,
    "환경평가" to secondCategoryList_3_24,
    "전문자격(세무.회계.법무)" to secondCategoryList_3_25,
    "전시/행사/이벤트/부스" to secondCategoryList_3_26,
    "산업디자인(조각,조형물포함)" to secondCategoryList_3_27,
    "비파괴검사" to secondCategoryList_3_28,
    "알뜰시장" to secondCategoryList_3_29,
    "재활용" to secondCategoryList_3_30,
    "파견/대행/번역/교육/ISO" to secondCategoryList_3_31,
    "보안,경비,무인경비" to secondCategoryList_3_32,
    "전기안전/CCTV조사" to secondCategoryList_3_33,
    "골재재취업" to secondCategoryList_3_34,
    "석면조사" to secondCategoryList_3_35,
    "건설/산림기술용역업" to secondCategoryList_3_36,
    "기타용역" to secondCategoryList_3_37
)