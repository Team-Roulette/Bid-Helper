package com.roulette.bidhelper.ui.bidinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.functions.BiddingPriceCalculator
import com.roulette.bidhelper.ui.bidinfo.graph.GraphView
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoPreciseViewModel
import com.roulette.bidhelper.ui.calculator.CalculatorView
import com.roulette.bidhelper.ui.calculator.Price
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.Locale

val title = listOf(
    "공고명", "공고번호", "발주처명", "수요처명",
    "지역제한", "업종", "입찰일", "등록일", "기초금액", "추정가격"
)
lateinit var contents: List<String>

@Composable
fun PreciseScreen(
    viewModel: BidInfoPreciseViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ){
        viewModel.selectedItem.value?.apply {
            contents = listOf(
                bidNtceNm,
                bidNtceNo,
                dminsttNm,
                dminsttNm,
                cmmnSpldmdCorpRgnLmtYn,
                "",
                bidBeginDt,
                bidNtceDt,
                d2bMngBssamt,
                presmptPrce
            )
        }
        BidInfoTabLayout()
    }
}

@Composable
fun BidInfoSummaryScreen(
    titles: List<String>,
    contents: List<String>,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(scrollState)
            .padding(horizontal = 25.dp, vertical = 35.dp)
            .border(width = 1.dp, color = Color.LightGray)
    ){
        for(i in titles.indices) {
            BidInfoTextView(title = titles[i], content= contents[i])
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
                .width(100.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .background(color = Color.LightGray))
        Text(
            text = content,
            style = MaterialTheme.typography.displaySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
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
fun BidInfoPreciseCalculatorScreen(
    formatter:NumberFormat = NumberFormat.getNumberInstance(Locale.KOREA)
) {

    val scrollState = rememberScrollState()

    var answer by remember { mutableStateOf(BigDecimal(0)) }
    val price by remember { mutableStateOf(Price()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        CalculatorView(Price())

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            Button(
                onClick = {
                    answer = BiddingPriceCalculator().predictBiddingPrice(
                        price.base,
                        price.a,
                        price.low,
                        price.estimate
                    )?.setScale(0, RoundingMode.HALF_UP)!!
                },
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray, contentColor = Color.Black
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .size(width = 90.dp, height = 40.dp)
            ) {
                Text(text = "예측하기")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = formatter.format(answer).toString(),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }

        GraphView()
    }
}

@Composable
fun BidInfoPreciseGraphView(

) {

}

@Composable
fun BidInfoTabLayout(
    modifier:Modifier = Modifier
) {
    val list = listOf("공고정보", "계산기")
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
        0 -> BidInfoSummaryScreen(titles = title, contents = contents)
        1 -> BidInfoPreciseCalculatorScreen()
        else -> Text("Selection not valid", color = Color.Red)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreciseScreenPreview() {
    BidInfoPreciseCalculatorScreen()
}









