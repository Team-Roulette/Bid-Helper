package com.roulette.bidhelper.ui.bidinfo

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.spinners.mainCategoryList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BidInfoTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "입찰 정보 - 상세 검색") },
        modifier = modifier.wrapContentSize())
}

@Composable
fun BidInfoScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { BidInfoTopAppBar() }
    ) { innerPadding ->

        BidInfoListScreen(
            modifier = modifier
            .padding(innerPadding)
        )
        /*BidInfoView(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        )*/
    }
}






@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BidInfoPreview() {
    BidInfoScreen()
}