package com.roulette.bidhelper.ui.bidinfo.graph

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ContentInfoCompat.Flags

@Composable
fun GraphView(
    dataPoints:List<Float> = listOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 10f),
    graphHeight:Dp = 250.dp,
    paddingSize:Dp = 10.dp,
    borderColor: Color = Color.LightGray,
    borderWidth: Dp = 1.dp,
    graphPadding:Dp = 10.dp,
    graphWidth:Dp = 1.dp,
    graphColor: Color = Color.Blue,
    averageColor: Color = Color.Red
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = Unit) {
        scrollState.scrollTo(scrollState.maxValue)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(graphHeight)
            .padding(paddingSize)
            .border(width = borderWidth, color = borderColor, shape = RoundedCornerShape(0.dp))
    ) {

        /*line showing average of the elements*/
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = if(averageOf(dataPoints) > 0) averageOf(dataPoints).dp else 0.dp,
                        bottom = if(averageOf(dataPoints) < 0) (averageOf(dataPoints).dp * -1) else 0.dp
                    )
                    .height(1.dp)
                    .background(color = averageColor)
            )
        }

        /*Horizontal lines showing level*/
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            GraphLineAndTextView("102")
            GraphLineAndTextView("101")
            GraphLineAndTextView("100")
            GraphLineAndTextView("99")
            GraphLineAndTextView("98")
        }

        LineGraph(
            dataPoints = dataPoints,
            graphWidth = graphWidth,
            graphColor = graphColor,
            modifier = Modifier
                .horizontalScroll(scrollState)
                .width(1000.dp)
                .fillMaxHeight()
                .padding(vertical = graphPadding)
        )

    }
}

@Composable
fun GraphLineAndTextView(
    text: String,
    color: Color = Color.LightGray
) {
    Column {

        Text(
            text = "",
            fontSize = 10.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = color))

        Text(
            text = text,
            fontSize = 10.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun LineGraph(
    dataPoints: List<Float>,
    graphWidth: Dp,
    graphColor: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val strokeWidth = graphWidth.toPx()
        val path = Path()

        // 그래프의 시작점
        if (dataPoints.isNotEmpty()) {
            path.moveTo(0f, size.height - (dataPoints.first() / dataPoints.maxOrNull()!! * size.height))
        }

        // 데이터 포인트를 경로에 추가
        dataPoints.forEachIndexed { index, value ->
            val x = index * (size.width / (dataPoints.size - 1))
            val y = size.height - (value / dataPoints.maxOrNull()!! * size.height)
            path.lineTo(x, y)
        }

        // 경로 그리기
        drawPath(
            path = path,
            color = graphColor,
            style = Stroke(strokeWidth)
        )
    }
}

fun averageOf(numbers: List<Float>): Float {
    var sum = 0f
    for(num in numbers)
        sum += num

    return sum / numbers.size
}

@Preview(showBackground = true)
@Composable
fun GraphPreview() {
    GraphView()
}