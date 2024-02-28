package com.roulette.bidhelper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.roulette.bidhelper.functions.OnBaseInfoListReceivedListener
import com.roulette.bidhelper.functions.RequestServer
import com.roulette.bidhelper.models.apis.IndSearch
import com.roulette.bidhelper.models.apis.etc.BidBaseInfoListDTO
import com.roulette.bidhelper.ui.home.HomeScreen
import com.roulette.bidhelper.ui.theme.BidHelperTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RequestServer.getBaseInfoList(IndSearch().apply{
            indstrytyClsfcCd = ""
            indstrytyCd = ""
            indstrytyNm = ""
        }, object : OnBaseInfoListReceivedListener {
            override fun onReceived(items: List<BidBaseInfoListDTO.Response.Body.Item>) {
                //items : 응답 아이템
                Log.i("test", items.toString())
            }
        })
        setContent {
            BidHelperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}