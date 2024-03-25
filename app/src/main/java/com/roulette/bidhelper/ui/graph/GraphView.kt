package com.roulette.bidhelper.ui.graph

import android.graphics.Typeface
import android.util.Log
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roulette.bidhelper.functions.AssessmentItem


@Composable
fun GraphView(
    dataPoints:List<Float> = listOf(2f, 0f, 0f, 0f, 0f, 0f, 0f, 1f),
    datas: List<AssessmentItem>? = null,
    average: Float = 0f,
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
    val convertedDataPoints: List<Float>? = if(datas != null) {
        convertDataPoints(datas)
    } else {
        null
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(graphHeight)
            .padding(paddingSize)
            .border(width = borderWidth, color = borderColor, shape = RoundedCornerShape(0.dp))
    ) {

        GridLineView(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly)

        AverageLineView(
            average = average,
            modifier = Modifier.fillMaxSize()
        )

        LineGraph(
            dataPoints = convertedDataPoints,
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

// Horizontal Lines Showing Levels
@Composable
fun GridLineView(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.HorizontalOrVertical
) {
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement
    ) {
        GraphLineAndTextView("102")
        GraphLineAndTextView("101")
        GraphLineAndTextView("100")
        GraphLineAndTextView("99")
        GraphLineAndTextView("98")
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
fun AverageLineView(
    modifier: Modifier = Modifier,
    average: Float = 0f,
    strokeWidth: Float = 3f
){

    Canvas(modifier = modifier) {
        val calculatedAverage = size.height * (1f- (convertDataPoint(average) /100f))
        Log.d("AssessmentRate", "calculatedheight: "+ calculatedAverage)
        drawLine(
            start = Offset(0F, calculatedAverage),
            end = Offset(size.width, calculatedAverage),
            strokeWidth = strokeWidth,
            color = Color.Red
        )
    }
}

@Composable
fun LineGraph(
    modifier: Modifier = Modifier,
    dataPoints:List<Float>? = listOf(70f, 20f, 30f, 40f, 80f, 10f, 30f, 50f),
    baseNumber: Float = 100f,
    graphHeight:Dp = 250.dp,
    paddingSize:Dp = 10.dp,
    borderColor: Color = Color.LightGray,
    borderWidth: Dp = 1.dp,
    graphPadding:Dp = 10.dp,
    graphWidth:Dp = 1.dp,
    graphColor: Color = Color.Blue,
    averageColor: Color = Color.Red
){
    Canvas(modifier = modifier) {
        val paint = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            textSize = 20f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            color = android.graphics.Color.BLACK
        }
        val path = Path()
        val offsetList: MutableList<Offset> = mutableListOf()

        dataPoints?.forEachIndexed { index, value ->
            val x = index * (size.width / (dataPoints.size - 1))
            val y = size.height - (value / baseNumber * size.height)

            path.lineTo(x, y)
            offsetList.add(Offset(x, y))

            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawText(
                    value.toString(),
                    x + 10f, // 점 옆으로 약간 오프셋
                    y + (paint.textSize / 3), // 텍스트 베이스라인 조정
                    paint
                )
            }
        }

        drawPoints(
            points = offsetList,
            pointMode = PointMode.Points,
            color = Color.Red,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
        )


        drawPath(
            path = path,
            color = graphColor,
            style = Stroke(graphWidth.toPx())
        )
    }
}

fun convertDataPoints(
    dataPoints: List<AssessmentItem>
): List<Float> {
    val answer: MutableList<Float> = mutableListOf()

    for(point in dataPoints) {
        answer.add(convertDataPoint(point.assessmentRate.toFloat()))
    }

    return answer.toList()
}

fun convertDataPoint(
    dataPoint: Float
): Float {
    return 50f + ((dataPoint - 100f) / 2.5f * 50f)
}

@Preview(showBackground = true)
@Composable
fun LineGraphPreview() {
    GraphView()
}