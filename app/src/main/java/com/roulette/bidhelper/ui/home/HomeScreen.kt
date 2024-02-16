package com.roulette.bidhelper.ui.home

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roulette.bidhelper.R
import com.roulette.bidhelper.ui.bidinfo.BidInfoScreen
import com.roulette.bidhelper.ui.bidinfo.FilterScreen
import com.roulette.bidhelper.ui.calculator.CalculatorScreen

enum class HomeScreen {
    Home,
    BidInfo,
    PastInfo,
    Calculator,
    Filter
}

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier.height(50.dp)
        )

        NavHost(
            navController = navController,
            startDestination = HomeScreen.Home.name
        ){
            composable(route = HomeScreen.Home.name) {
                HomeBody(navController = navController)
            }

            composable(route = HomeScreen.BidInfo.name) {
                BidInfoScreen()
            }

            composable(route = HomeScreen.PastInfo.name) {
                //PastInfoScreen()
            }

            composable(route = HomeScreen.Calculator.name) {
                CalculatorScreen()
            }

            composable(route = HomeScreen.Filter.name) {
                FilterScreen()
            }
        }
    }

}

@Composable
fun HomeBody(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {

        Text(
            text = stringResource(id = R.string.app_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp)

        )

        HomeButton(
            topRadius = 10.dp,
            titleRes = R.string.home_card_bid_info,
            bgColorRes = R.color.color_home_button_1,
            onClick = {navController.navigate(HomeScreen.BidInfo.name)},
            modifier = modifier.fillMaxWidth()
        )

        HomeButton(
            titleRes = R.string.home_card_past_info,
            bgColorRes = R.color.color_home_button_2,
            onClick = {},
            modifier = modifier.fillMaxWidth()
        )

        HomeButton(
            titleRes = R.string.home_card_bid_calculator,
            bgColorRes = R.color.color_home_button_3,
            onClick = {navController.navigate(HomeScreen.Calculator.name)},
            modifier = modifier.fillMaxWidth()
        )

        HomeButton(
            bottomRadius = 10.dp,
            titleRes = R.string.home_card_bid_filter,
            bgColorRes = R.color.color_home_button_4,
            onClick = {navController.navigate(HomeScreen.Filter.name)},
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeButton(
    topRadius: Dp = 0.dp,
    bottomRadius: Dp = 0.dp ,
    @ColorRes
    bgColorRes: Int,
    @StringRes
    titleRes: Int,
    onClick:()->Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(
            topStart=topRadius,
            topEnd=topRadius,
            bottomStart = bottomRadius,
            bottomEnd = bottomRadius
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = bgColorRes)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = titleRes),
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFFFFFF),
                modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}