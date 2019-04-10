package com.bigthinkapps.theleague.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bigthinkapps.theleague.data.TeamEvent
import com.bigthinkapps.theleague.data.remote.TeamEventDataSourceImpl
import com.bigthinkapps.theleague.data.repository.TeamEventRepository
import com.bigthinkapps.theleague.network.TeamService

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val teamService by lazy {
        TeamService.getTeamService()
    }

    private val repository by lazy {
        TeamEventRepository(TeamEventDataSourceImpl(teamService))
    }

    val items = MutableLiveData<List<TeamEvent>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getTeamEvents(idTeam: String) {
        isLoading.value = true
        repository.listAll(idTeam, {
            items.value = it
            isLoading.value = false
        }, {
            isLoading.value = false
        })
    }

    fun onPause() {
        repository.onDispose()
    }
}