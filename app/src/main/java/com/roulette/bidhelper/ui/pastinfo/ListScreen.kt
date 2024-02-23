package com.roulette.bidhelper.ui.pastinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(
    onItemClicked:() -> Unit,
    modifier: Modifier = Modifier
) {
    val itemList = listOf("aaa", "bbb", "ccc", "ddd")
    LazyColumn(
        modifier = modifier) {
        items(itemList) {
            ListItem(
                item = it,
                onItemClicked = onItemClicked)
            Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
        }
    }
}

@Composable
fun ListItem(
    item: String,
    modifier: Modifier = Modifier,
    onItemClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .clickable (enabled = true, onClick = onItemClicked)
    ) {
        Text(text = item, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
        Text(text = item, style = MaterialTheme.typography.displaySmall)
        Text(text = item, style = MaterialTheme.typography.displaySmall)
        Text(text = item, style = MaterialTheme.typography.displaySmall)
        Text(text = item, style = MaterialTheme.typography.displaySmall)
    }
}