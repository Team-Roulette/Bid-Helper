package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.R
import com.roulette.bidhelper.models.apis.BidResultUiState
import com.roulette.bidhelper.models.apis.after.Item
import com.roulette.bidhelper.ui.pastinfo.viewmodels.PastInfoListViewModel
import com.roulette.bidhelper.ui.pastinfo.viewmodels.PastResultUiState

@Composable
fun PastInfoListScreen(
    modifier: Modifier = Modifier,
    pastInfoViewModel: PastInfoListViewModel,
    onItemClicked:(Item) -> Unit,
) {

    when (val pastResultUiState = pastInfoViewModel.pastResultUiState) {
        is PastResultUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is PastResultUiState.Success -> ResultScreen(
            itemList = pastResultUiState.items,
            modifier = modifier.fillMaxWidth(),
            onItemClicked = onItemClicked
        )
        is PastResultUiState.Error -> LoadingScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "로딩 중"
    )
}

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    onItemClicked: (Item) -> Unit,
    itemList: List<Item>) {
    LazyColumn(
        modifier = modifier) {
        items(itemList) {
            ListItem(
                item = it,
                onItemClicked = onItemClicked
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
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
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .clickable (enabled = true) { onItemClicked(item) }
    ) {
        Text(text = item.bidNtceNm?: "", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold,
            maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(text = item.dminsttNm?: "", style = MaterialTheme.typography.displaySmall)
        Text(text = item.bidNtceNo?: "", style = MaterialTheme.typography.displaySmall)
        Text(text = item.bidwinnrNm?: "", style = MaterialTheme.typography.displaySmall)
    }
}