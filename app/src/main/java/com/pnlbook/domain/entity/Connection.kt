package com.pnlbook.domain.entity

import com.pnlbook.domain.Exchange

data class Connection(
    val id: Int = 0,
    val label: String,
    val exchange: Exchange,
    val apiKey: String,
    val apiSecret: String,
    val passphrase: String? = null,
    val isSpotEnabled: Boolean = false,
    val isFuturesEnabled: Boolean = false
)