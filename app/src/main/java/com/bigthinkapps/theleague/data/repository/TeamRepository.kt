package com.bigthinkapps.theleague.data.repository

import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.data.datasource.TeamDataSource

class TeamRepository(private val teamDataSource: TeamDataSource) : TeamDataSource {

    override fun listAll(league: String, success: (List<Team>) -> Unit, failure: () -> Unit) {
        teamDataSource.listAll(league, success, failure)
    }

    override fun onDispose() {
        teamDataSource.onDispose()
    }
}