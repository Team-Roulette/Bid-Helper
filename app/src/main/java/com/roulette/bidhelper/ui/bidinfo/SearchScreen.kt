package com.roulette.bidhelper.ui.bidinfo


import android.content.Context
import android.util.Log

import android.app.DatePickerDialog
import android.widget.Toast

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.derivedStateOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.spinners.categoryMap
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList

import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale


@Composable
fun SearchScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedMainCategory by remember {
        mutableStateOf<String?>(null)
    }
    var selectedFirstCategory by remember {
        mutableStateOf<String?>(null)
    }
    var selectedSecondCategory by remember {
        mutableStateOf<String?>(null)
    }
    var selectedLocation by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        BidInfoSpinnerView(
            title = R.string.bid_info_main_category,
            list = mainCategoryList,
            onItemSelected = { selectedItem ->
                selectedMainCategory = selectedItem
            },
            "mainCategoryList"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        BidInfoSpinnerView(title = R.string.bid_info_first_category,
            list = when (selectedMainCategory) {
                null -> emptyList()
                else -> categoryMap[selectedMainCategory]!!
            },
            onItemSelected = { selectedItem ->
                selectedFirstCategory = selectedItem
            },
            "firstCategoryList"
        )
        Log.d("asdf", selectedMainCategory.toString())

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        BidInfoSpinnerView(title = R.string.bid_info_second_category, list = when (selectedFirstCategory) {
            null -> emptyList()
            else -> categoryMap[selectedFirstCategory]!!
        },
            onItemSelected = { selectedItem ->
                selectedSecondCategory = selectedItem
            },"secondCategoryList"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        BidInfoSpinnerView(
            title = R.string.bid_info_local_limit,
            list = placeCategoryList,
            onItemSelected = { selectedItem ->
                selectedLocation = selectedItem
            },
            "locationCategoryList"
        )


    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
    BidInfoCalendarView(title = R.string.bid_info_input_data_from)

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
    BidInfoCalendarView(title = R.string.bid_info_input_data_to)

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
    BidInfoBudgetView(title = R.string.bid_info_budget_setting)

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
    BidInfoSearchView(title = R.string.bid_info_search)

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )

    BidInfoButtonView(
        onClickReset = {},
        onClickSearch = onNextButtonClicked
    )
    }
}


@Composable
fun BidInfoSpinnerView(
    @StringRes
    title: Int,
    list: List<String>,
    onItemSelected: (String) -> Unit,// 선택값 반환
    sharedPreferencesKey: String, // SharedPreferences에 저장할 때 사용할 키
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("YourPreferenceName", Context.MODE_PRIVATE)
    //sharedPreference에서 값을 읽어와서 기본값으로 설정
    val defaultValue = sharedPreferences.getString(sharedPreferencesKey, if (list.isNotEmpty()) list[0] else "선택 없음")
    // 리스트가 비어 있지 않은지 확인하고, 비어 있다면 기본값 설정
    val currentValue = remember {
        mutableStateOf(defaultValue ?: "선택 없음")
    }
    val expanded = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded.value = !expanded.value }
                .border(width = 1.dp, color = Color.LightGray)
                .padding(vertical = 7.dp, horizontal = 15.dp)
        ) {
            Text(
                text = currentValue.value,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.fillMaxWidth(.9f)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            DropdownMenu(expanded = expanded.value, onDismissRequest = {
                expanded.value = false
            }) {
                list.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            currentValue.value = item
                            expanded.value = false
                            onItemSelected(item)
                        }
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidInfoCalendarView(
    @StringRes
    title: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }

    // 선택된 날짜를 저장하기 위한 상태
    var selectedDate by remember { mutableStateOf("") }
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

    // DatePickerDialog 초기화
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, monthOfYear, dayOfMonth ->
            // 날짜가 선택되면 이 부분이 호출됩니다.
            val calendar = Calendar.getInstance().apply {
                set(year, monthOfYear, dayOfMonth)
            }
            val selectedDateString = dateFormat.format(calendar.time)
            selectedDate = selectedDateString
            Toast.makeText(context, "Selected date: $selectedDateString", Toast.LENGTH_SHORT).show()

        },
        Calendar.getInstance().get(Calendar.YEAR),
        Calendar.getInstance().get(Calendar.MONTH),
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    )



    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(0.3f)) {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth(.6f)
                .border(width = 1.dp, color = Color.DarkGray)
                .clickable {
                    showDialog.value = true
                }
                .background(color = Color.LightGray)
                .padding(vertical = 7.dp, horizontal = 15.dp)
        ) {
            Text(
                text = selectedDate,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if(showDialog.value) {
            datePickerDialog.show()
            showDialog.value = false
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidInfoBudgetView(
    @StringRes
    title: Int,
    modifier: Modifier = Modifier
) {
    val list = listOf("기초금액", "추정가격")
    val currentValue = remember { mutableStateOf(list[0]) }
    val expanded = remember { mutableStateOf(false) }

    var min by remember { mutableStateOf(TextFieldValue(""))}
    var max by remember { mutableStateOf(TextFieldValue(""))}
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded.value = !expanded.value }
                    .border(width = 1.dp, color = Color.LightGray)
                    .padding(vertical = 7.dp, horizontal = 15.dp)
            ) {
                Text(
                    text = currentValue.value,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth(.9f)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )

                DropdownMenu(expanded = expanded.value, onDismissRequest = {
                    expanded.value = false
                }) {
                    list.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it) },
                            onClick = {
                                currentValue.value = it
                                expanded.value = false
                            }
                        )
                    }
                }
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = min,
                    label = { Text(text = "최소(억)", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.labelSmall,
                    onValueChange = {newValue ->
                        val newText = newValue.text
                        min = newValue.copy(
                            text = newText,
                            selection = TextRange(newText.length)
                        )

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ), // 키보드 타입을 숫자패드로 설정,
                    modifier = modifier.width(100.dp)
                )

                Spacer(modifier = Modifier.fillMaxWidth(.1f))

                OutlinedTextField(
                    value = max,
                    label = { Text(text = "최대(억)", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.labelSmall,
                    onValueChange = {newValue ->
                        val newText = newValue.text
                        max = newValue.copy(
                            text = newText,
                            selection = TextRange(newText.length)
                        )

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ), // 키보드 타입을 숫자패드로 설정,
                    modifier = modifier.width(100.dp)
                )

            }
        }
    }
}

@Composable
fun BidInfoSearchView(
    @StringRes
    title: Int,
    modifier: Modifier = Modifier
) {
    var content by remember{ mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(40.dp).border(1.dp, Color.LightGray)
        ) {
            BasicTextField(
                value = content,
                textStyle = MaterialTheme.typography.labelSmall,
                onValueChange = {
                    content = it
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun BidInfoButtonView(
    modifier: Modifier = Modifier,
    onClickSearch: () -> Unit,
    onClickReset: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp)
    ) {
        BidInfoButton(onClick = onClickSearch, text = "검색", icon = Icons.Filled.Search)
        BidInfoButton(onClick = onClickReset, text = "초기화", icon = Icons.Filled.Refresh)
    }
}

@Composable
fun BidInfoButton(
    onClick: () -> Unit,
    text: String,
    icon: ImageVector
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        border = BorderStroke(1.dp, color = Color.LightGray),
        modifier = Modifier.size(width = 120.dp, height = 50.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = text)
    }
}