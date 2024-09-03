package com.gultekinahmetabdullah.shareagent.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gultekinahmetabdullah.shareagent.`object`.Share
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SharesViewModel : ViewModel() {
    private val _shares = mutableStateListOf<Share>()
    val shares: List<Share> get() = _shares

    init {
        viewModelScope.launch {
            while (true) {
                updateShares((1..20).map { generateRandomShare() })
                delay(1000)
            }
        }
    }

    private fun updateShares(newShares: List<Share>) {
        _shares.clear()
        _shares.addAll(newShares)
        _shares.sortByDescending {
            it.dailyPercentage
        }
    }

    private fun generateRandomShare(): Share {
        val randomIsNegative = Math.random() > 0.5

        val randomString = ('A'..'Z').toList().shuffled().joinToString("").substring(0, 5)

        if (randomIsNegative) {
            return Share(
                id = Math.random().toString(),
                low = (Math.random() * 10).toString(),
                volumeLot = (Math.random() * 1000000).toString(),
                open = (Math.random() * 10).toString(),
                symbol = randomString,
                sell = (Math.random() * 10).toString(),
                description = randomString,
                last = (Math.random() * 10).toString(),
                volumeTL = (Math.random() * 1000000).toString(),
                dailyPercentage = (Math.random() * -10).toString(),
                high = (Math.random() * 10).toString(),
                buy = (Math.random() * 10).toString(),
                change = (Math.random() * -10).toString(),
                symbolCode = randomString,
                previousClose = (Math.random() * 10).toString()
            )
        }

        return Share(
            id = Math.random().toString(),
            low = (Math.random() * 10).toString(),
            volumeLot = (Math.random() * 1000000).toString(),
            open = (Math.random() * 10).toString(),
            symbol = randomString,
            sell = (Math.random() * 10).toString(),
            description = randomString,
            last = (Math.random() * 10).toString(),
            volumeTL = (Math.random() * 1000000).toString(),
            dailyPercentage = (Math.random() * 10).toString(),
            high = (Math.random() * 10).toString(),
            buy = (Math.random() * 10).toString(),
            change = (Math.random() * 10).toString(),
            symbolCode = randomString,
            previousClose = (Math.random() * 10).toString()
        )
    }
}
