package com.roulette.bidhelper.functions

import java.math.BigDecimal
import java.math.RoundingMode

class biddingPriceCalculator {
    fun predictBiddingPrice(basicPrice: BigDecimal, aPrice: BigDecimal, lowerLimit: BigDecimal): BigDecimal? {
        // 기초금액, A, 낙찰하한율 -> 예상입찰가격
        return ((basicPrice.subtract(aPrice)).multiply(lowerLimit)
            .divide(BigDecimal(100))).add(aPrice)
    }

    fun calculateBiddingRate(basicPrice: BigDecimal, aPrice: BigDecimal, biddingPrice: BigDecimal): BigDecimal? {
        //기초금액, A, 입찰가격 -> 투찰률
        return ((biddingPrice.subtract(aPrice)).divide(basicPrice.subtract(aPrice), 5, RoundingMode.HALF_UP)).multiply(BigDecimal(100))
    }
}


