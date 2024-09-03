package com.gultekinahmetabdullah.shareagent.screen

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gultekinahmetabdullah.shareagent.viewmodel.SharesViewModel

@Composable
fun MainScreen(viewModel: SharesViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "shareList",
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(1500)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(1500)
            )
        }
    ) {
        composable("shareList") {
            ShareListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("shareDetail/{shareId}") { backStackEntry ->
            ShareDetailScreen(
                viewModel = viewModel,
                shareId = backStackEntry.arguments?.getString("shareId") ?: "",
                navController = navController
            )
        }
    }
}
