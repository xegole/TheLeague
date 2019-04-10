package com.bigthinkapps.theleague.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.data.remote.TeamDataSourceImpl
import com.bigthinkapps.theleague.data.repository.TeamRepository
import com.bigthinkapps.theleague.network.TeamService

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val teamService by lazy {
        TeamService.getTeamService()
    }

    private val repository by lazy {
        TeamRepository(TeamDataSourceImpl(teamService))
    }

    val teams = MutableLiveData<List<Team>>()
    val loadingVisibility = MutableLiveData<Boolean>()

    fun getTeamsByLeague(league: String) {
        teams.value = emptyList()
        loadingVisibility.value = true

        repository.listAll(league, {
            teams.value = it
            loadingVisibility.value = false
        }, {
            loadingVisibility.value = false
        })
    }

    fun onPause() {
        repository.onDispose()
    }
}