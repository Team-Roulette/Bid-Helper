package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.R
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.bidinfo.BidInfoBudgetView
import com.roulette.bidhelper.ui.bidinfo.BidInfoButtonView
import com.roulette.bidhelper.ui.bidinfo.BidInfoCalendarView
import com.roulette.bidhelper.ui.bidinfo.BidInfoSearchView
import com.roulette.bidhelper.ui.bidinfo.BidInfoSpinnerView
import com.roulette.bidhelper.ui.bidinfo.SpacerView
import com.roulette.bidhelper.ui.bidinfo.spinners.categoryMap
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList
import com.roulette.bidhelper.ui.bidinfo.spinners.placeCategoryList
import com.roulette.bidhelper.ui.pastinfo.viewmodels.PastInfoSharedViewModel

@Composable
fun PastInfoSearchScreen(
    viewModel: PastInfoSharedViewModel,
    onNextButtonClicked: () -> Unit,
    onIndustryTextClicked: ()-> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_main_category,
            list = mainCategoryList,
            currentValue = viewModel.uiState.mainCategory,
            changeUiState = { viewModel.updateUIState(mainCategory = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoSearchView(
            title = R.string.bid_info_industry_name,
            content = viewModel.uiState.industryName,
            changeUiState = { viewModel.updateUIState(industryName = it) },
            textFieldEnabled = false,
            modifier = Modifier
                .clickable(onClick = onIndustryTextClicked)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )

        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_local_limit,
            list = placeCategoryList,
            currentValue = viewModel.uiState.locale,
            changeUiState = { viewModel.updateUIState(locale = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoCalendarView(
            title = R.string.past_info_input_data_from,
            selectedDate = viewModel.uiState.dateFrom,
            changeUiState = { viewModel.updateUIState(dateFrom = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoCalendarView(
            title = R.string.past_info_input_data_to,
            selectedDate = viewModel.uiState.dateTo,
            changeUiState = { viewModel.updateUIState(dateTo = it) })

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
            changeUiState = { viewModel.updateUIState(searchName = it) },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        )

        SpacerView(modifier = Modifier)
        BidInfoButtonView(
            onClickReset = {},
            onClickSearch = onNextButtonClicked
        )
    }
}
