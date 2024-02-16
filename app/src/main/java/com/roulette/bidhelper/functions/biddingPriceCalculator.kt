package com.roulette.bidhelper.functions

import android.util.Log
import java.math.BigDecimal
import java.math.RoundingMode

class BiddingPriceCalculator {
    fun predictBiddingPrice(basicPrice: BigDecimal, aPrice: BigDecimal, lowerLimit: BigDecimal, percentage: BigDecimal): BigDecimal? {
        // 기초금액, A, 낙찰하한율, 퍼센트입력 -> 기초 금액 * 퍼센트 = 추정예가로 예상입찰가격 반환
        var estimateBasicPrice = (basicPrice.multiply(percentage)).divide(BigDecimal(100))
            .divide(BigDecimal(100)).setScale(0, RoundingMode.HALF_UP).multiply(BigDecimal(100))  //10의자리에서 반올림
        Log.d("test1", estimateBasicPrice.toString())

        return ((estimateBasicPrice.subtract(aPrice)).multiply(lowerLimit)
            .divide(BigDecimal(100))).add(aPrice)
    }

    fun calculateBiddingRate(predictPrice: BigDecimal, aPrice: BigDecimal, biddingPrice: BigDecimal): BigDecimal? {
        // 예가(not 기초가), a값, 입찰가  -> 투찰률(87.745) 반환
        return ((biddingPrice.subtract(aPrice)).divide(predictPrice.subtract(aPrice), 5, RoundingMode.HALF_UP)).multiply(BigDecimal(100))
    }


}


