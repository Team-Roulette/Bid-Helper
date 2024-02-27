package com.roulette.bidhelper.ui.filter

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.BidInfoBudgetView
import com.roulette.bidhelper.ui.bidinfo.BidInfoSpinnerView
import com.roulette.bidhelper.ui.bidinfo.SpacerView
import com.roulette.bidhelper.ui.bidinfo.spinners.categoryMap
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import com.roulette.bidhelper.ui.filter.viewmodels.FilterViewModel
import com.roulette.bidhelper.ui.filter.viewmodels.FilterViewModelFactory

private const val TAG = "MainActivity"

@Composable
fun FilterScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("FilterDB", Context.MODE_PRIVATE)
    val factory = FilterViewModelFactory(sharedPreferences)
    val viewModel: FilterViewModel = viewModel(factory = factory)

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
        BidInfoSpinnerView(title = R.string.bid_info_first_category,
            list = if(categoryMap[viewModel.uiState.mainCategory] == null) emptyList()
            else categoryMap[viewModel.uiState.mainCategory]!!,
            currentValue = viewModel.uiState.firstCategory,
            changeUiState = {
                viewModel.updateUIState(firstCategory = it, secondCategory = categoryMap[it]!!.get(0))
            }
        )

        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_second_category,
            list = if(categoryMap[viewModel.uiState.firstCategory] == null) emptyList()
            else categoryMap[viewModel.uiState.firstCategory]!!,
            currentValue = viewModel.uiState.secondCategory,
            changeUiState = {viewModel.updateUIState(secondCategory = it)}
        )

        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_local_limit,
            list = placeCategoryList,
            currentValue = viewModel.uiState.locale,
            changeUiState = {viewModel.updateUIState(locale = it)}
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
        FilterButtonView(
            onClickReset = {},
            onClickSave = {
                sharedPreferences.edit().apply {
                    putString("mainCategory", viewModel.uiState.mainCategory)
                    putString("firstCategory", viewModel.uiState.firstCategory)
                    putString("secondCategory", viewModel.uiState.secondCategory)
                    putString("locale", viewModel.uiState.locale)
                    putString("priceType", viewModel.uiState.priceType)
                    putString("minPrice", viewModel.uiState.minPrice)
                    putString("maxPrice", viewModel.uiState.maxPrice)
                }.apply()
                Toast.makeText(context, "저장에 성공하였습니다.", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Composable
fun FilterButtonView(
    modifier: Modifier = Modifier,
    onClickReset: () -> Unit,
    onClickSave: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp)
    ) {
        FilterButton(onClick = onClickReset, text = "초기화", icon = Icons.Filled.Refresh)
        FilterButton(onClick = onClickSave, text = "저장", icon = Icons.Filled.CheckCircle)
    }
}

@Composable
fun FilterButton(
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