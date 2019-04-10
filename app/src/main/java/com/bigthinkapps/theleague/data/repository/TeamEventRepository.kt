package com.bigthinkapps.theleague.data.repository

import com.bigthinkapps.theleague.data.TeamEvent
import com.bigthinkapps.theleague.data.datasource.TeamEventDataSource

class TeamEventRepository(private val teamDataSource: TeamEventDataSource) : TeamEventDataSource {

    override fun listAll(idTeam: String, success: (List<TeamEvent>) -> Unit, failure: () -> Unit) {
        teamDataSource.listAll(idTeam, success, failure)
    }

    override fun onDispose() {
        teamDataSource.onDispose()
    }
}