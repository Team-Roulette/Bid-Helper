package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.bidinfo.BidInfoHorizontalSpacer
import com.roulette.bidhelper.ui.bidinfo.BidInfoSummaryScreen
import com.roulette.bidhelper.ui.bidinfo.BidInfoTextView
/*
val title = listOf(
    "공고명", "공고번호", "발주처명", "수요처명",
    "지역제한", "업종", "입찰일", "등록일", "기초금액", "추정가격"
)*/

val title = listOf(
    "공고명", "공고번호", "수요기관", "참가업체수","최종낙찰업체", "최종낙찰금액", "최종낙찰률",
    "등록일", "개찰일", "낙찰일", "연계기관명"
)

@Composable
fun PastInfoPreciseScreen(
    modifier: Modifier = Modifier,
    item: Item
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ){
        PastInfoTabLayout(item = item)
    }
}

@Composable
private fun PastInfoTabLayout(
    item: Item,
    modifier:Modifier = Modifier
) {
    val list = listOf("공고요약", "상세정보")
    var selectedIndex by remember{ mutableStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = selectedIndex
        ){
            list.forEachIndexed { index, title ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    text = { Text(text = title) }
                )
            }
        }
        PastInfoTabContent(selectedTabIndex = selectedIndex, item = item)
    }
}

@Composable
private fun PastInfoTabContent(
    selectedTabIndex: Int,
    item: Item,
    modifier: Modifier = Modifier) {
    when (selectedTabIndex) {
        0 -> BidInfoSummaryScreen(titles = title, contents = getItemAsStringList(item))
        //1 -> PastInfoSummaryScreen(itemList = getItemAsStringList(item))
        else -> Text("Selection not valid", color = Color.Red)
    }
}

fun getItemAsStringList(item: Item): List<String> {

/*    val listTitle = listOf(
        "공고명", "공고번호", "수요기관", "참가업체수",
        "최종낙찰업체", "최종낙찰금액", "최종낙찰률", "등록일",
         "개찰일", "낙찰일", "연계기관명"
    )*/

    return listOf(
        item.bidNtceNm, item.bidNtceNo, item.dminsttNm, item.prtcptCnum,
        item.bidwinnrNm, item.sucsfbidAmt, item.sucsfbidRate, item.rgstDt,
        item.rlOpengDt, item.fnlSucsfDate, item.linkInsttNm
    )
}









