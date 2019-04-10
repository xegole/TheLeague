package com.bigthinkapps.theleague.data.datasource

import com.bigthinkapps.theleague.data.Team

interface TeamDataSource {

    fun listAll(league: String, success: (List<Team>) -> Unit, failure: () -> Unit)

    fun onDispose()
}