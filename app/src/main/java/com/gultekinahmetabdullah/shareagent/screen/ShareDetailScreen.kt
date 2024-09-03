package com.gultekinahmetabdullah.shareagent.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gultekinahmetabdullah.shareagent.viewmodel.SharesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareDetailScreen(
    viewModel: SharesViewModel,
    shareId: String,
    navController: NavController
) {
    // Find the specific share based on the shareId
    val share = viewModel.shares.find { it.id == shareId }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(
                        text = "Share Details",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
            )
        }
    ) {

        if (share != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                // Detail Cards
                DetailCard(title = "Description", value = share.description)
                DetailCard(title = "Last Price", value = share.last, isHighlighted = true)
                DetailCard(title = "Open Price", value = share.open)
                DetailCard(title = "High", value = share.high)
                DetailCard(title = "Low", value = share.low)
                DetailCard(title = "Buy Price", value = share.buy)
                DetailCard(title = "Sell Price", value = share.sell)
                DetailCard(title = "Change", value = share.change, isHighlighted = true)
                DetailCard(title = "Daily Percentage", value = share.dailyPercentage)
                DetailCard(title = "Volume (Lot)", value = share.volumeLot)
                DetailCard(title = "Volume (TL)", value = share.volumeTL)
                DetailCard(title = "Previous Close", value = share.previousClose)
            }
        } else {
            // Handle case when share is not found
            Text(
                text = "Share not found",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Red,
                    fontSize = 18.sp
                )
            )
        }
    }
}

@Composable
fun DetailCard(title: String, value: String, isHighlighted: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp,
            disabledElevation = 0.dp,
            focusedElevation = 8.dp,
            hoveredElevation = 8.dp,
            draggedElevation = 8.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    color = Color.White
                )

                val newValue = value.toDoubleOrNull() ?: 0.0

                Text(
                    text = String.format("%.2f", newValue),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp
                    ),
                    color = Color.Gray
                )
            }
        }
    }
}
