package com.bigthinkapps.theleague.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.bigthinkapps.theleague.data.TeamEvent
import com.bigthinkapps.theleague.view.adapter.contract.TeamEventPagerContract
import com.bigthinkapps.theleague.view.event.TeamEventFragment

class EventPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm), TeamEventPagerContract {

    private var teamList: List<TeamEvent> = emptyList()

    override fun getCount(): Int = teamList.size

    override fun getItem(position: Int): Fragment = TeamEventFragment.newInstance(teamList[position])

    override fun replaceItems(list: List<TeamEvent>) {
        this.teamList = list
        notifyDataSetChanged()
    }
}
