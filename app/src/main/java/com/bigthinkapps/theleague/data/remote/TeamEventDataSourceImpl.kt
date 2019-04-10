package com.bigthinkapps.theleague.data.remote

import com.bigthinkapps.theleague.data.TeamEvent
import com.bigthinkapps.theleague.data.datasource.TeamEventDataSource
import com.bigthinkapps.theleague.network.TeamApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TeamEventDataSourceImpl(private val teamApi: TeamApi) : TeamEventDataSource {

    private var disposable: Disposable? = null

    override fun listAll(idTeam: String, success: (List<TeamEvent>) -> Unit, failure: () -> Unit) {
        disposable = teamApi.getEventsByTeam(idTeam)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ teamEventResponse ->
                success(teamEventResponse.events)
            }, {
                it.printStackTrace()
                failure()
            })
    }

    override fun onDispose() {
        disposable?.dispose()
    }
}