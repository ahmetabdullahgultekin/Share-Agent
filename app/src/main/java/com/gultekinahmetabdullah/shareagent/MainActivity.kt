package com.gultekinahmetabdullah.shareagent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.gultekinahmetabdullah.shareagent.screen.MainScreen
import com.gultekinahmetabdullah.shareagent.ui.theme.ShareAgentTheme
import com.gultekinahmetabdullah.shareagent.viewmodel.SharesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel = SharesViewModel()

            ShareAgentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}