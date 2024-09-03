package com.gultekinahmetabdullah.shareagent.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.gultekinahmetabdullah.shareagent.`object`.Share

class SharesViewModel : ViewModel() {
    private val _shares = mutableStateListOf<Share>()
    val shares: List<Share> get() = _shares

    fun updateShares(newShares: List<Share>) {
        _shares.clear()
        _shares.addAll(newShares)
    }
}
