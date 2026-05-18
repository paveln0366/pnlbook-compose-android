package com.pnlbook.presentation.connections

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pnlbook.domain.Exchange
import com.pnlbook.domain.entity.Connection

class ConnectionsViewModel(application: Application) : AndroidViewModel(application) {

    private val data = mutableListOf<Connection>().apply {
        repeat(10) {
            add(
                Connection(
                    id = it,
                    label = "Binance Futures",
                    exchange = Exchange.BINANCE,
                    apiKey = "api key 123",
                    apiSecret = "api secret 123",
                    passphrase = "passphrase",
                    isSpotEnabled = false,
                    isFuturesEnabled = true
                )
            )
        }
    }
    private val _connections = MutableLiveData<List<Connection>>(data)
    val connections: LiveData<List<Connection>> = _connections

    fun remove(connection: Connection) {
        val oldConnections = connections.value?.toMutableList() ?: mutableListOf()
        oldConnections.remove(connection)
        _connections.value = oldConnections
    }
}