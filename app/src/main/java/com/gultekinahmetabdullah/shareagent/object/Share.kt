package com.gultekinahmetabdullah.shareagent.`object`

data class Share(
    val id: String, // Unique identifier for each share
    val low: String,
    val volumeLot: String,
    val open: String,
    val symbol: String,
    val sell: String,
    val description: String,
    val last: String,
    val volumeTL: String,
    val dailyPercentage: String,
    val high: String,
    val buy: String,
    val change: String,
    val symbolCode: String,
    val previousClose: String
) {
    companion object {
        val empty = Share(
            id = "Unknown",
            low = "Unknown",
            volumeLot = "Unknown",
            open = "Unknown",
            symbol = "Unknown",
            sell = "Unknown",
            description = "Unknown",
            last = "Unknown",
            volumeTL = "Unknown",
            dailyPercentage = "Unknown",
            high = "Unknown",
            buy = "Unknown",
            change = "Unknown",
            symbolCode = "Unknown",
            previousClose = "Unknown"
        )
    }
}

