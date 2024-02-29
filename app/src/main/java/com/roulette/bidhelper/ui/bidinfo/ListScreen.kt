package com.roulette.bidhelper.ui.bidinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.models.apis.before.Item
import com.roulette.bidhelper.ui.bidinfo.viewmodels.BidInfoListViewModel

@Composable
fun ListScreen(
    viewModel: BidInfoListViewModel<Any?>,
    onItemClicked: (Item) -> Unit,
    modifier: Modifier = Modifier
) {

    val itemList = viewModel.bidConstWorkSearch
//    val itemList2 = viewModel.bidConstBasisAmount
    val lifecycleOwner = LocalLifecycleOwner.current

    LazyColumn(
        modifier = modifier
    ) {
        viewModel.bidConstWorkSearch.observe(lifecycleOwner) { dto ->
            items(dto.response.body.items) {
                ListItem(
                    item = it,
                    onItemClicked = onItemClicked
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
            }
        }
    }
}

@Composable
fun ListItem(
    item: Item,
    modifier: Modifier = Modifier,
    onItemClicked: (Item) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .padding(horizontal = 20.dp, vertical = 15.dp)
            .clickable (enabled = true) { onItemClicked(item) }
    ) {
        Text(text = item.bidNtceNm, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold,
            maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(text = item.ntceInsttNm, style = MaterialTheme.typography.displaySmall)
        Text(text = "기초가격: ${item.d2bMngBssamt}", style = MaterialTheme.typography.displaySmall)
        Text(text = "추정가격: ${item.presmptPrce}", style = MaterialTheme.typography.displaySmall)
        Text(text = "[입찰일]${item.bidClseDt} [입력일]${item.rgstDt}", style = MaterialTheme.typography.displaySmall,
            maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}