package com.myapp.catatuang

class CurrencyManager {
    enum class Currency {
        EUR, USD, RUB, BYN
    }

    fun getCurrency(currency: Currency): Double {
        return when (currency) {
            Currency.EUR -> 0.85
            Currency.USD -> 1.0
            Currency.RUB -> 75.0
            Currency.BYN -> 2.5
        }
    }
}