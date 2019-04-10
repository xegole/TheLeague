package com.bigthinkapps.theleague.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigthinkapps.theleague.R
import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.view.adapter.contract.TeamAdapterContract
import com.bigthinkapps.theleague.view.adapter.viewholder.TeamViewHolder

class TeamAdapter : RecyclerView.Adapter<TeamViewHolder>(), TeamAdapterContract {

    private var teamList: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun getItemCount() = teamList.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.setData(teamList[position])
    }

    override fun replaceItems(list: List<Team>) {
        this.teamList = list
        notifyDataSetChanged()
    }
}