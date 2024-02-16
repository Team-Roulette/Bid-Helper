package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val title = listOf(
    "공고명", "공고번호", "발주처명", "수요처명",
    "지역제한", "업종", "입찰일", "등록일", "기초금액", "추정가격"
)

@Composable
fun PreciseScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ){
        BidInfoTabLayout()
    }
}

@Composable
fun BidInfoSummaryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 25.dp, vertical = 35.dp)
            .border(width = 1.dp, color = Color.LightGray)
    ){
        title.forEach{title->
            BidInfoTextView(title = title, content= "title")
            BidInfoHorizontalSpacer(modifier = Modifier)
        }
    }
}

@Composable
fun BidInfoTextView(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
    ){
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .background(color = Color.LightGray))
        Text(
            text = content,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

@Composable
fun BidInfoHorizontalSpacer(
    modifier: Modifier
) {
    Spacer(modifier = modifier
        .height(1.dp)
        .fillMaxWidth()
        .background(color = Color.LightGray))
}

@Composable
private fun BidInfoTabLayout(
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
        TabContent(selectedTabIndex = selectedIndex)
    }
}

@Composable
fun TabContent(selectedTabIndex: Int, modifier: Modifier = Modifier) {
    when (selectedTabIndex) {
        0 -> BidInfoSummaryScreen()
        1 -> BidInfoSummaryScreen()
        else -> Text("Selection not valid", color = Color.Red)
    }
}









