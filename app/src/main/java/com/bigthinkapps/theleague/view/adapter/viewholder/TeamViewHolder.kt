package com.bigthinkapps.theleague.view.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.view.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_team.view.*

class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(team: Team) {
        itemView.labelTeamName.text = team.name
        itemView.labelStadium.text = team.stadium

        Picasso.get().load(team.urlBadge).into(itemView.imageBadge)

        itemView.setOnClickListener {
            goToIntent(it.context, team)
        }
    }

    private fun goToIntent(context: Context, team: Team) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DataExtra.EXTRA_TEAM_DATA, team)
        context.startActivity(intent)
    }
}