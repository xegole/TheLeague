package com.bigthinkapps.theleague.view.adapter.contract

import com.bigthinkapps.theleague.data.TeamEvent

interface TeamEventPagerContract {

    fun replaceItems(list: List<TeamEvent>)
}