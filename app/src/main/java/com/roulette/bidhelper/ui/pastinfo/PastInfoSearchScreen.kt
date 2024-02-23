package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.roulette.bidhelper.R
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
        BidInfoSpinnerView(title = R.string.bid_info_first_category,
            list = if (categoryMap[viewModel.uiState.mainCategory] == null) emptyList()
            else categoryMap[viewModel.uiState.mainCategory]!!,
            currentValue = viewModel.uiState.firstCategory,
            changeUiState = { viewModel.updateUIState(firstCategory = it) }
        )

        SpacerView(modifier = Modifier)
        BidInfoSpinnerView(
            title = R.string.bid_info_second_category,
            list = if (categoryMap[viewModel.uiState.firstCategory] == null) emptyList()
            else categoryMap[viewModel.uiState.firstCategory]!!,
            currentValue = viewModel.uiState.secondCategory,
            changeUiState = { viewModel.updateUIState(secondCategory = it) }
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
            changeUiState = { viewModel.updateUIState(searchName = it) })

        SpacerView(modifier = Modifier)
        BidInfoButtonView(
            onClickReset = {},
            onClickSearch = onNextButtonClicked
        )
    }
}
