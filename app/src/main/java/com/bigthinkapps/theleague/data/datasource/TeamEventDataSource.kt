package com.bigthinkapps.theleague.data.datasource

import com.bigthinkapps.theleague.data.TeamEvent

interface TeamEventDataSource {

    fun listAll(idTeam: String, success: (List<TeamEvent>) -> Unit, failure: () -> Unit)

    fun onDispose()
}