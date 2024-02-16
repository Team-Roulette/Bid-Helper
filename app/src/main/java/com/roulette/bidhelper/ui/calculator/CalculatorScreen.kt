package com.roulette.bidhelper.ui.calculator

import android.text.TextUtils.isDigitsOnly
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
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.roulette.bidhelper.R
import com.roulette.bidhelper.functions.BiddingPriceCalculator
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

private const val TAG = "CalculatorScreen"
private const val MAX_PRICE_LENGTH = 24
private const val MAX_PERCENT_LENGTH = 10
data class Price(
    var base: BigDecimal = BigDecimal(0),
    var a: BigDecimal = BigDecimal(0),
    var low: BigDecimal = BigDecimal(87.7445),
    var estimate: BigDecimal = BigDecimal(0),
    var answer: BigDecimal = BigDecimal(0)
)

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier
) {
    val price by remember { mutableStateOf(Price()) }
    var answer by remember { mutableStateOf(BigDecimal(0)) }
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
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
            onClick = {
                answer = BiddingPriceCalculator().predictBiddingPrice(price.base, price.a, price.low)?.setScale(0, RoundingMode.HALF_UP)!!
            },
            modifier = Modifier
                .size(width = 120.dp, height = 70.dp)
                .padding(top = 15.dp)
        ) {
            Text(text = "예측하기")
        }

        Text(
            text = formatter.format(answer).toString(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 30.dp)
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
        IntegerTextField(
            title = "기초가격(원)",
            changePriceValue = {price.base = it},
            content = if(price.base == BigDecimal(0)) "" else price.base.toString(),
            modifier = Modifier.padding(top = 10.dp)
        )

        IntegerTextField(
            title = "A값(원)",
            changePriceValue = {price.a = it},
            content = if(price.a == BigDecimal(0)) "" else price.a.toString(),
            modifier = Modifier.padding(top = 10.dp)
        )

        DoubleTextField(
            title = "낙찰 하한률(%)",
            changePriceValue = {price.low = it},
            content = if(price.low == BigDecimal(0)) "" else price.low.setScale(3, RoundingMode.HALF_UP).toString(),
            modifier = Modifier.padding(top = 10.dp)
        )

        DoubleTextField(
            title = "추정 퍼센트(%)",
            changePriceValue = {price.estimate = it},
            content = if(price.estimate == BigDecimal(0)) "" else price.estimate.toString(),
            imeAction = ImeAction.Done,
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
private fun IntegerTextField(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Number,
    changePriceValue:(BigDecimal) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue(content))}

    OutlinedTextField(
        value = textFieldValue,
        label = { Text(text = title, style = MaterialTheme.typography.bodySmall) },
        onValueChange = {newValue ->
            if(newValue.text.length < MAX_PRICE_LENGTH) {
                val newText = newValue.text.reformatNumberString()
                textFieldValue = newValue.copy(
                    text = newText,
                    selection = TextRange(newText.length)
                )
                changePriceValue(newText.formattedTextToBigDecimal())
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ), // 키보드 타입을 숫자패드로 설정,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
private fun DoubleTextField(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Number,
    changePriceValue:(BigDecimal) -> Unit
) {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(
            text = content, selection = TextRange(content.length)))}

    OutlinedTextField(
        value = textFieldValue,
        label = { Text(text = title, style = MaterialTheme.typography.bodySmall) },
        onValueChange = {newValue ->
            if(newValue.text.length <= MAX_PERCENT_LENGTH) {
                if (newValue.text.toDoubleOrNull() != null) {
                    textFieldValue = newValue.copy(
                        selection = TextRange(newValue.text.length)
                    )
                    changePriceValue(textFieldValue.text.toBigDecimal())
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ), // 키보드 타입을 숫자패드로 설정,
        modifier = modifier.fillMaxWidth()
    )
}


private fun String.reformatNumberString(): String {
    val formatter = NumberFormat.getNumberInstance(java.util.Locale.KOREA)
    val temp =
        if(this.isNotEmptyAndNotBlank()) {
            val num = formatter.parse(this)!!.toLong()
            formatter.format(num)
        } else {
            ""
        }
    return temp
}

private fun String.formattedTextToBigDecimal(): BigDecimal{
    val formatter = NumberFormat.getNumberInstance(java.util.Locale.KOREA)
    val number =  if(this.isNotEmptyAndNotBlank()) {
            formatter.parse(this)!!.toLong()
        } else {
            0
        }
    return number.toBigDecimal()
}

private fun String.isNotEmptyAndNotBlank(): Boolean = this.isNotEmpty() && isNotBlank()

