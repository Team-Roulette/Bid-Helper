package com.roulette.bidhelper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.roulette.bidhelper.functions.biddingPriceCalculator
import com.roulette.bidhelper.ui.home.HomeScreen
import com.roulette.bidhelper.ui.theme.BidHelperTheme
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BidHelperTheme {
                HomeScreen()
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val basicPrice = BigDecimal(333146000)
    val aPrice = BigDecimal(10015866)
    val  lowerLimit= BigDecimal(87.7445)
    val test1 = biddingPriceCalculator().predictBiddingPrice(basicPrice, aPrice, lowerLimit, BigDecimal(99.86976))?.setScale(0, RoundingMode.HALF_UP)
    Log.d("test2", test1.toString())

    val predictPrice = test1?.add(BigDecimal(1))    // + 1
    // 예가(not 기초가), a값, 입찰가  -> 투찰률(87.745) 반환
    val test2 = biddingPriceCalculator().calculateBiddingRate(BigDecimal(332712100), aPrice, predictPrice!!)?.setScale(3, RoundingMode.HALF_UP)
    Log.d("test3", test2.toString())
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BidHelperTheme {
        Greeting("Android")
    }
}