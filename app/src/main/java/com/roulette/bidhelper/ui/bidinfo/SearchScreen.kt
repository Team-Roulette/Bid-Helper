package com.roulette.bidhelper.ui.bidinfo

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.spinners.categoryMap
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoSearchViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val TAG = "MainActivity"

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit,
    viewModel: BidInfoSearchViewModel
) {

    Column(
        modifier = modifier
    ) {
        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_main_category,
            list = mainCategoryList,
            currentValue = viewModel.uiState.mainCategory,
            changeUiState = { viewModel.updateUIState(mainCategory = it, firstCategory = categoryMap[it]!!.get(0), secondCategory = "") }
        )

        SpacerView(modifier = Modifier)
        BidInfoSearchView(
            title = R.string.bid_info_industry_name,
            content = viewModel.uiState.industryName,
            changeUiState = { viewModel.updateUIState(industryName = it) }
        )


        SpacerView(modifier = Modifier)
        BidInfoCalendarView(
            title = R.string.bid_info_input_data_from,
            selectedDate =  viewModel.uiState.dateFrom,
            changeUiState = { viewModel.updateUIState(dateFrom = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoCalendarView(
            title = R.string.bid_info_input_data_to,
            selectedDate = viewModel.uiState.dateTo,
            changeUiState = { viewModel.updateUIState(dateTo = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoBudgetView(
            title = R.string.bid_info_budget_setting,
            priceType = viewModel.uiState.priceType,
            minPrice = viewModel.uiState.minPrice,
            maxPrice = viewModel.uiState.maxPrice,
            changeUiState = { priceType, minPrice, maxPrice ->
              viewModel.updateUIState(priceType = priceType, minPrice = minPrice, maxPrice = maxPrice)
            }
        )

        SpacerView(modifier = Modifier)
        BidInfoSearchView(
            title = R.string.bid_info_search,
            content = viewModel.uiState.searchName,
            changeUiState = { viewModel.updateUIState(searchName = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoButtonView(
            onClickReset = {},
            onClickSearch = onNextButtonClicked
        )
    }
}

@Composable
fun SpacerView(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}


@Composable
fun BidInfoSpinnerView(
    @StringRes
    title: Int,
    list: List<String>,
    modifier: Modifier = Modifier,
    currentValue: String,
    changeUiState: (String) -> Unit,
) {
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
                text = currentValue,
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
                            changeUiState(item)
                            expanded.value = false
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
    modifier: Modifier = Modifier,
    @StringRes
    title: Int,
    selectedDate: String,
    changeUiState: (String) -> Unit
) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }

    // 선택된 날짜를 저장하기 위한 상태
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
            changeUiState(selectedDateString)
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

@Composable
fun BidInfoBudgetView(
    modifier: Modifier = Modifier,
    @StringRes
    title: Int,
    priceType: String,
    minPrice: String,
    maxPrice: String,
    changeUiState: (String, String, String) -> Unit
) {
    val list = listOf("기초금액", "추정가격")
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
            ){
                Text(
                    text = priceType,
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
                                changeUiState(it, minPrice, maxPrice)
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
                    value = minPrice,
                    label = { Text(text = "최소(억)", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.labelSmall,
                    onValueChange = {
                        changeUiState(priceType, it, maxPrice)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ), // 키보드 타입을 숫자패드로 설정,
                    modifier = modifier.width(100.dp)
                )

                Spacer(modifier = Modifier.fillMaxWidth(.1f))

                OutlinedTextField(
                    value = maxPrice,
                    label = { Text(text = "최대(억)", style = MaterialTheme.typography.bodySmall) },
                    textStyle = MaterialTheme.typography.labelSmall,
                    onValueChange = {
                        changeUiState(priceType, minPrice, it)
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
    content:String,
    changeUiState: (String) -> Unit,
    modifier: Modifier = Modifier
) {
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
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, Color.LightGray)
        ) {
            BasicTextField(
                value = content,
                textStyle = MaterialTheme.typography.labelSmall,
                onValueChange = {
                    changeUiState(it)
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
    onClick:() -> Unit,
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
