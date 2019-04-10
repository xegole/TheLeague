package com.bigthinkapps.theleague.network

import com.bigthinkapps.theleague.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TeamService {

    companion object {
        private var retrofit: Retrofit? = null

        private fun getClient(): Retrofit? {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit
            } else {
                retrofit
            }
        }

        fun getTeamService(): TeamApi = getClient()!!.create(TeamApi::class.java)
    }
}