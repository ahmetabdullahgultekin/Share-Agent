package com.gultekinahmetabdullah.shareagent.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gultekinahmetabdullah.shareagent.`object`.Share
import com.gultekinahmetabdullah.shareagent.viewmodel.SharesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareListScreen(
    viewModel: SharesViewModel,
    navController: NavController
) {
    /*
        val newShares = remember {
            mutableListOf(
                Share(
                    id = "1",
                    low = "9.28",
                    volumeLot = "13029299",
                    open = "9.30",
                    symbol = "THYAO",
                    sell = "9.29",
                    description = "TURK HAVA YOLLARI AS",
                    last = "9.29",
                    volumeTL = "121500301",
                    dailyPercentage = "0.54",
                    high = "9.36",
                    buy = "9.28",
                    change = "0.05",
                    symbolCode = "THYAO",
                    previousClose = "9.24"
                ),

                Share(
                    id = "2",
                    low = "2.25",
                    volumeLot = "35123914",
                    open = "2.31",
                    symbol = "KRDMD",
                    sell = "2.27",
                    description = "KARDEMIR D GRUBU",
                    last = "2.26",
                    volumeTL = "80553475",
                    dailyPercentage = "-0.88",
                    high = "2.32",
                    buy = "2.26",
                    change = "-0.02",
                    symbolCode = "KRDMD",
                    previousClose = "2.28"
                ),

                Share(
                    id = "3",
                    low = "10.13",
                    volumeLot = "7915125",
                    open = "10.18",
                    symbol = "GARAN",
                    sell = "10.18",
                    description = "T. GARANTI BANKASI",
                    last = "10.18",
                    volumeTL = "80545836",
                    dailyPercentage = "0.39",
                    high = "10.21",
                    buy = "10.17",
                    change = "0.04",
                    symbolCode = "GARAN",
                    previousClose = "10.14"
                ),

                Share(
                    id = "4",
                    low = "1.86",
                    volumeLot = "16396988",
                    open = "1.90",
                    symbol = "IHLGM",
                    sell = "1.94",
                    description = "IHLAS GAYRIMENKUL",
                    last = "1.93",
                    volumeTL = "31725088",
                    dailyPercentage = "2.12",
                    high = "1.99",
                    buy = "1.93",
                    change = "0.04",
                    symbolCode = "IHLGM",
                    previousClose = "1.89"
                ),

                Share(
                    id = "5",
                    low = "12.50",
                    volumeLot = "2528928",
                    open = "12.50",
                    symbol = "HALKB",
                    sell = "12.55",
                    description = "T HALK BANKASI A.S.",
                    last = "12.54",
                    volumeTL = "31717754",
                    dailyPercentage = "0.88",
                    high = "12.59",
                    buy = "12.54",
                    change = "0.11",
                    symbolCode = "HALKB",
                    previousClose = "12.43"
                )
            )
        }

            val timeLeft by remember { mutableIntStateOf(2000) }

            // Simulate receiving new data
            LaunchedEffect(key1 = timeLeft) {
                delay(1000)
                viewModel.updateShares(newShares)
                println(
                    "Shares updated at ${System.currentTimeMillis()}"
                )
            }*/

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Shares",
                        textAlign = TextAlign.Center,
                    )
                },
            )
        }
    ) {
        val shares by remember { mutableStateOf(viewModel.shares) }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(0.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(shares) { share ->
                ShareItem(share = share, onClick = {
                    navController.navigate("shareDetail/${share.id}")
                })
            }
        }
    }
}

@Composable
fun ShareItem(share: Share, onClick: () -> Unit) {

    var isPressed by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                isPressed = !isPressed
                onClick()
            }),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.hsv(0f, 0f, 0.1f),
                        )
                    )
                )
                .height(48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = share.symbol,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),
                color = Color.White
            )

            val calcPercentage =
                ((share.dailyPercentage.toDoubleOrNull() ?: 0.0) * 100).toInt() / 100.0

            val calcPrice = ((share.last.toDoubleOrNull() ?: 0.0) * 100).toInt() / 100.0

            Text(
                modifier = Modifier.padding(16.dp),
                text = String.format("%.2f₺", calcPrice),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                color = Color.Gray
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = String.format("%.2f%%", calcPercentage),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
                color = if ((share.change.toDoubleOrNull()
                        ?: 0.0) >= 0
                ) Color.Green else Color.Red
            )
        }
    }
}
