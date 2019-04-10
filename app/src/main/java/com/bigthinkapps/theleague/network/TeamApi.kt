package com.bigthinkapps.theleague.network

import com.bigthinkapps.theleague.data.response.TeamEventResponse
import com.bigthinkapps.theleague.data.response.TeamResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamApi {

    @GET("search_all_teams.php")
    fun getTeamsByLeague(@Query("l") searchByLeague: String): Observable<TeamResponse>

    @GET("eventsnext.php")
    fun getEventsByTeam(@Query("id") idTeam: String): Observable<TeamEventResponse>
}