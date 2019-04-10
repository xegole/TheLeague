package com.bigthinkapps.theleague.data.remote

import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.data.datasource.TeamDataSource
import com.bigthinkapps.theleague.network.TeamApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TeamDataSourceImpl(private val teamApi: TeamApi) : TeamDataSource {

    private var disposable: Disposable? = null

    override fun listAll(league: String, success: (List<Team>) -> Unit, failure: () -> Unit) {
        disposable = teamApi.getTeamsByLeague(league)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ teamResponse ->
                success(teamResponse.teams)
            }, {
                it.printStackTrace()
                failure()
            })
    }

    override fun onDispose() {
        disposable?.dispose()
    }
}