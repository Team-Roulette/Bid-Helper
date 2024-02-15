package com.roulette.bidhelper.ui.calculator

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.roulette.bidhelper.R
import java.math.BigDecimal

private const val TAG = "CalculatorScreen"

data class Price(
    var base: BigDecimal = BigDecimal(0),
    var a: BigDecimal = BigDecimal(0),
    var low: BigDecimal = BigDecimal(87.745),
    var estimate: BigDecimal = BigDecimal(0),
    var answer: BigDecimal = BigDecimal(0)
)

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier
) {
    val price by remember { mutableStateOf(Price()) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = stringResource(id = R.string.home_card_bid_calculator),
            style = MaterialTheme.typography.titleLarge
        )

        CalculatorView(
            price = price
        )

        Text(
            text = "계산 공식: 낙찰 하한율=(입찰가-A)/(예가-A)x100",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 20.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .size(width = 120.dp, height = 70.dp)
                .padding(top = 15.dp)
        ) {
            Text(text = "예측하기")
        }

        Text(
            text = price.answer.toString(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 30.dp)
        )

    }
}

@Composable
private fun CalculatorView(
    price: Price,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(10.dp)
    ) {
        DigitTextView(
            title = "기초가격(원)",
            onValueChange = {
                if (it.isDigitsOnly())
                    if (it.isEmpty())
                        price.base = BigDecimal(0)
                    else
                        price.base = it.toBigDecimal()

                Log.d(TAG, "${price.base}, ${price.a}, ${price.low}, ${price.estimate}")
            },
            modifier = Modifier.padding(top = 10.dp)
        )

        DigitTextView(
            title = "A값(원)", onValueChange = {
                if (it.isDigitsOnly())
                    if (it.isEmpty())
                        price.a = BigDecimal(0)
                    else
                        price.a = it.toBigDecimal()
            },
            modifier = Modifier.padding(top = 10.dp)
        )

        DigitTextView(
            title = "낙찰 하한률(%)", isDigit = false, onValueChange = {
                if (it.toDoubleOrNull() != null)
                    price.low = it.toBigDecimal()
            },
            modifier = Modifier.padding(top = 10.dp)
        )

        DigitTextView(
            title = "추정 퍼센트(%)", isDigit = false, onValueChange = {
                if (it.toDoubleOrNull() != null)
                    price.estimate = it.toBigDecimal()
            },
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "추정 퍼센트(%) = (추정 예가 / 기초 가격) x 100",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Red,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}

@Composable
private fun DigitTextView(
    modifier: Modifier = Modifier,
    title: String,
    isDigit: Boolean = true,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            textStyle = MaterialTheme.typography.bodyMedium,
            onValueChange = {
                if (isDigit) {
                    if (it.isDigitsOnly()) {
                        text = it
                        onValueChange(text.ifEmpty { "0" })
                    }
                } else {
                    if (it.toDoubleOrNull() != null) {
                        text = it
                        onValueChange(text.ifEmpty { "0" })
                    }
                }
            },
            label = { Text(text = title, style = MaterialTheme.typography.bodySmall) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // 키보드 타입을 숫자패드로 설정
            modifier = Modifier.fillMaxWidth()
        )
    }
}